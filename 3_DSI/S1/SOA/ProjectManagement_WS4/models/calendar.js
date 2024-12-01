const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Calendar = sequelize.define('Calendar', {
    id: {
        type: DataTypes.BIGINT,
        primaryKey: true,
        autoIncrement: true,
    },
    name: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    description: {
        type: DataTypes.TEXT,
        allowNull: true,
    },
    start_date: {
        type: DataTypes.DATE,
        allowNull: false,
    },
    end_date: {
        type: DataTypes.DATE,
        allowNull: false,
    },
    project_id: {
        type: DataTypes.BIGINT,
        allowNull: true,
        references: {
            model: 'project',
            key: 'id',
        },
    },
}, {
    tableName: 'calendar',
    timestamps: false, // Assuming you don't need created_at and updated_at
});

module.exports = Calendar;
