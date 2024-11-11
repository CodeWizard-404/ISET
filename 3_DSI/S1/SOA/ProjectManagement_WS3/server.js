const fs = require('fs');
const soap = require('soap');
const mysql = require('mysql2');

// Path to your WSDL file
const wsdlPath = 'ProjectTeam.wsdl';  // Make sure this is the correct relative path

// Read WSDL file and debug
let wsdl;
try {
    wsdl = fs.readFileSync(wsdlPath, 'utf8');
    console.log('WSDL File Read Successfully');
} catch (error) {
    console.error('Error reading WSDL file:', error.message);
    return;  // Exit if file is not found or there is an issue
}

// Set up MySQL connection
const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '', // Replace with your MySQL password
    database: 'projectmanagement'
});

// Define SOAP service logic
const service = {
    ProjectTeamService: {
        ProjectTeamPort: {
            AssignTeamToProject: function(args, callback) {
                const projectId = args.ProjectId;
                const teamId = args.TeamId;

                // Process query
                connection.query(
                    'SELECT * FROM project WHERE id = ?',
                    [projectId],
                    (err, projectResults) => {
                        if (err) {
                            callback({ status: 'Error: ' + err.message });
                            return;
                        }

                        if (projectResults.length === 0) {
                            callback({ status: 'Project not found' });
                            return;
                        }

                        connection.query(
                            'SELECT * FROM team WHERE id = ?',
                            [teamId],
                            (err, teamResults) => {
                                if (err) {
                                    callback({ status: 'Error: ' + err.message });
                                    return;
                                }

                                if (teamResults.length === 0) {
                                    callback({ status: 'Team not found' });
                                    return;
                                }

                                // Insert data into ProjectTeam table
                                connection.query(
                                    'INSERT INTO ProjectTeam (ProjectId, TeamId) VALUES (?, ?)',
                                    [projectId, teamId],
                                    (err, result) => {
                                        if (err) {
                                            callback({ status: 'Error: ' + err.message });
                                            return;
                                        }

                                        callback({
                                            status: 'Team successfully assigned to Project.'
                                        });
                                    }
                                );
                            }
                        );
                    }
                );
            }
        }
    }
};

// Define the URL of the SOAP service
const url = 'http://localhost:8000/ProjectTeamService';

// Listen for SOAP requests
soap.listen(url, service, wsdl, function() {
    console.log('SOAP service listening on ' + url);
});
