console.log("Hello NodeJS");


var moment = require('moment');

console.log(moment().format('MMMM Do YYYY'));
console.log(moment().startOf('day').fromNow());
console.log(moment().endOf('day').fromNow());