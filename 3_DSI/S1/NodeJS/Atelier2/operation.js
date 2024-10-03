require('dotenv').config();

function perimeter(radius){
    return 2 * process.env.PI * radius;
}
function surface(radius){
    return process.env.PI * radius * radius;
}

module.exports = {
    perimeter,
    surface,
};