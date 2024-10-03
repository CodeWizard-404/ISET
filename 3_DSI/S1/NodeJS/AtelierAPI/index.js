const http = require('http');
const axios = require('axios');

const PORT = 3000;
const API_URL = 'https://restcountries.com/v3.1/';

const server = http.createServer((req, res) => {
    // Route /countries
    if (req.url === '/countries' && req.method === 'GET') {
        axios.get(`${API_URL}all`)
            .then(response => {
                const countryNames = response.data.map(country => country.name.common);
                res.writeHead(200, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify(countryNames));
            })
            .catch(error => {
                res.writeHead(500, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify({ error: 'Failed to fetch country data' }));
            });
        return; 
    }

    // Route /country/{name}
    const countryRegex = /^\/country\/([a-zA-Z]+)$/;
    const countryMatch = req.url.match(countryRegex);
    if (countryMatch && req.method === 'GET') {
        const countryName = countryMatch[1];
        axios.get(`${API_URL}name/${countryName}`)
            .then(response => {
                res.writeHead(200, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify(response.data[0]));
            })
            .catch(error => {
                res.writeHead(404, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify({ error: 'Country not found' }));
            });
        return;  
    }

    // Route /flag/{name}
    const flagRegex = /^\/flag\/([a-zA-Z]+)$/;
    const flagMatch = req.url.match(flagRegex);
    if (flagMatch && req.method === 'GET') {
        const countryName = flagMatch[1];
        axios.get(`${API_URL}name/${countryName}`)
            .then(response => {
                const flagUrl = response.data[0].flags.png;
                //res.writeHead(200, { 'Content-Type': 'application/json' });
                //res.end(JSON.stringify({ flagUrl }));
                res.writeHead(302, { Location: flagUrl });
                res.end();
            })
            .catch(error => {
                res.writeHead(404, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify({ error: 'Country or flag not found' }));
            });
        return;  
    }

    //invalid routes
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('Route not found');
});

server.listen(PORT, () => {
    console.log(`Server is listening on port ${PORT}`);
});
