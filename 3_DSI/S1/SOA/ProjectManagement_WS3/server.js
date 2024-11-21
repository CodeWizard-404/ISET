const express = require('express');
const soap = require('strong-soap').soap;
const fs = require('fs');
const path = require('path');
const db = require('./db');

const app = express();

// Define the SOAP service
const service = {
    ProjectService: {
        ProjectPort: {
            assignTeam: async function (args, callback) {
                const { teamId, projectId } = args;

                try {
                    // Check if the project and team exist
                    const [teamRows] = await db.query('SELECT * FROM team WHERE Id = ?', [teamId]);
                    const [projectRows] = await db.query('SELECT * FROM project WHERE id = ?', [projectId]);

                    if (!teamRows.length) {
                        return callback(null, { message: `Team with ID ${teamId} does not exist.` });
                    }

                    if (!projectRows.length) {
                        return callback(null, { message: `Project with ID ${projectId} does not exist.` });
                    }

                    // Check if the assignment already exists
                    const [existingAssignment] = await db.query(
                        'SELECT * FROM projectteam WHERE TeamId = ? AND ProjectId = ?',
                        [teamId, projectId]
                    );

                    if (existingAssignment.length) {
                        return callback(null, { message: `Team ${teamId} is already assigned to project ${projectId}.` });
                    }

                    // Assign the team to the project
                    await db.query('INSERT INTO projectteam (TeamId, ProjectId) VALUES (?, ?)', [teamId, projectId]);

                    callback(null, { message: `Team ${teamId} successfully assigned to project ${projectId}.` });
                } catch (error) {
                    console.error('Error assigning team to project:', error);
                    callback({ message: 'An error occurred while assigning the team to the project.' });
                }
            },
        },
    },
};

// Read the WSDL file
const wsdlPath = path.join(__dirname, 'ProjectService.wsdl');
const wsdlXML = fs.readFileSync(wsdlPath, 'utf8');

// Bind the SOAP service
const server = app.listen(3000, () => {
    console.log(`SOAP API running at http://localhost:3000/ProjectService?wsdl`);
});

soap.listen(server, '/ProjectService', service, wsdlXML);
