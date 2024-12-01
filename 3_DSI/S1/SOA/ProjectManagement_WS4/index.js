const express = require('express');
const bodyParser = require('body-parser');
const sequelize = require('./config/database');
const Calendar = require('./models/calendar');

const app = express();
app.use(bodyParser.json());

// Sync database
sequelize.sync().then(() => {
    console.log("Database synced successfully");
}).catch((err) => {
    console.log("Error syncing database:", err);
});

// Routes for Calendar Management
// 1. Get all events
app.get('/calendar', async (req, res) => {
    try {
        const events = await Calendar.findAll();
        res.json(events);
    } catch (error) {
        res.status(500).json({ error: 'Failed to retrieve events' });
    }
});

// 2. Create a new event
app.post('/calendar', async (req, res) => {
    const { name, description, start_date, end_date, project_id } = req.body;

    try {
        const newEvent = await Calendar.create({
            name,
            description,
            start_date,
            end_date,
            project_id,
        });
        res.status(201).json(newEvent);
    } catch (error) {
        res.status(400).json({ error: 'Failed to create event' });
    }
});

// 3. Get a specific event
app.get('/calendar/:id', async (req, res) => {
    try {
        const event = await Calendar.findByPk(req.params.id);
        if (event) {
            res.json(event);
        } else {
            res.status(404).json({ error: 'Event not found' });
        }
    } catch (error) {
        res.status(500).json({ error: 'Failed to retrieve event' });
    }
});

// 4. Update an event
app.put('/calendar/:id', async (req, res) => {
    const { name, description, start_date, end_date, project_id } = req.body;

    try {
        const event = await Calendar.findByPk(req.params.id);
        if (event) {
            event.name = name;
            event.description = description;
            event.start_date = start_date;
            event.end_date = end_date;
            event.project_id = project_id;
            await event.save();
            res.json(event);
        } else {
            res.status(404).json({ error: 'Event not found' });
        }
    } catch (error) {
        res.status(500).json({ error: 'Failed to update event' });
    }
});

// 5. Delete an event
app.delete('/calendar/:id', async (req, res) => {
    try {
        const event = await Calendar.findByPk(req.params.id);
        if (event) {
            await event.destroy();
            res.status(204).send();
        } else {
            res.status(404).json({ error: 'Event not found' });
        }
    } catch (error) {
        res.status(500).json({ error: 'Failed to delete event' });
    }
});

// Start the server
const PORT = process.env.PORT || 4000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
