const express = require('express');
const app = express();
const expressLayouts = require('express-ejs-layouts');

app.use((req, res, next) => {
    console.log('middleware 1');
    next();
})
app.use((req, res, next) => {
    console.log('middleware 2');
    next();
})

app.set('view engine', 'ejs');
app.use(expressLayouts);
app.use(express.static('public'));

app.get('/', (req, res) => {
    res.render('index', { pageTitle: 'Chapitre EJS' });
});

app.get('/students', (req, res) => {
    const students = [
        { nom: 'std1', age: 17 },
        { nom: 'std2', age: 18 },
        { nom: 'std3', age: 20 },
        { nom: 'std4', age: 16 }
    ];
    res.render('students', { pageTitle: 'Student List', students });
});

app.listen(4000, () => console.log("http://localhost:4000"));
