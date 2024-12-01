const express = require('express');
const mongoose = require('mongoose');
const path = require('path');

const app = express();
const port = 3031;

// MongoDB URI (Replace with your MongoDB URI)
const uri = 'mongodb://localhost:27017/student'; // Use your MongoDB URI

// Set up EJS view engine
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// Middleware to parse incoming form data
app.use(express.urlencoded({ extended: true }));

// Connect to MongoDB using Mongoose
mongoose.connect(uri, { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => {
        console.log('Connected to MongoDB');
    })
    .catch((err) => console.error(err));

// Define the Student Schema and Model
const studentSchema = new mongoose.Schema({
    username: { type: String, required: true },
    email: { type: String, required: true },
});

const Student = mongoose.model('Student', studentSchema);

// Home route to display the form and list of students
app.get('/', (req, res) => {
    Student.find()
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

    // Create a new student and save it to the database
    const newStudent = new Student({ username, email });

    newStudent.save()
        .then(() => {
            res.redirect('/');
        })
        .catch((err) => res.status(500).send(err));
});

// Start the server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
