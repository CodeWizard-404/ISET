const mysql = require('mysql2');

const pool = mysql.createPool({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'projectmanagement',
});

console.log('db connection established');

module.exports = pool.promise();
