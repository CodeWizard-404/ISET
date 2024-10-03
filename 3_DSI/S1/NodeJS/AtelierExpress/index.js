const express = require('express')
const app = express()
app.get('/',(req,res)=>{
    res.send('<h1>Home Page</h1>')
})

app.get('/clients',(req,res)=>{
    res.send('<h1>Client Page</h1>')
})

app.post('/',(req,res)=>{
    res.send('Methode poste sur le chemin/')
})

app.put('/',(req,res)=>{
    res.send('Methode put sur le chemin/')
})

app.listen(3000,()=>{
    console.log('Server started on port 3000')
})