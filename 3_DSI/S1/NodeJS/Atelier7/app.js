const express = require('express');
const { MongoClient } = require('mongodb');
const path = require('path');

const app = express();
const port = 3030;

// MongoDB URI (Replace with your MongoDB URI)
const uri = 'mongodb://localhost:27017';
const dbName = 'student'; // Database name
let db, studentsCollection;

// Set up EJS view engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Middleware to parse incoming form data
app.use(express.urlencoded({ extended: true }));

// Connect to MongoDB
MongoClient.connect(uri, { useUnifiedTopology: true })
    .then((client) => {
        db = client.db(dbName);
        studentsCollection = db.collection('students');
        console.log('Connected to database');
    })
    .catch((err) => console.error(err));

// Home route to display the form and list of students
app.get('/', (req, res) => {
    studentsCollection.find().toArray()
        .then((students) => {
            res.render('index', { students });
        })
        .catch((err) => res.status(500).send(err));
});

// Post route to add a student to the list
app.post('/add-student', (req, res) => {
    const { username, email } = req.body;

    if (!username || !email) {
        return res.status(400).send('Both username and email are required');
    }

    // Insert new student into the database
    studentsCollection.insertOne({ username, email })
        .then(() => {
            res.redirect('/');
        })
        .catch((err) => res.status(500).send(err));
});

// Start the server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
