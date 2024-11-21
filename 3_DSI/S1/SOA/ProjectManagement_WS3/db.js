const mysql = require('mysql2');

const pool = mysql.createPool({
  host: 'localhost',
  user: 'root', // Replace with your DB username
  password: '', // Replace with your DB password
  database: 'projectmanagement', // Replace with your DB name
});

module.exports = pool.promise();
