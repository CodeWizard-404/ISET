const { Sequelize } = require('sequelize');

// Create a new Sequelize instance to connect to your database
const sequelize = new Sequelize('projectmanagement', 'root', '', {
  host: 'localhost',
  dialect: 'mysql',
});

module.exports = sequelize;
