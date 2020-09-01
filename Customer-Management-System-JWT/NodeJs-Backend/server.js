const express = require('express');
const bodyParser = require('body-parser');

// create express app
const app = express();

// parse requests of content-type - application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }))

// Configuring the database
const dbConfig = require('./config/database.config.js');
const mongoose = require('mongoose');

mongoose.Promise = global.Promise;

// Connecting to the database
mongoose.connect(dbConfig.url, {
    useNewUrlParser: true
}).then(() => {
    console.log("Successfully connected to the database");    
}).catch(err => {
    console.log('Could not connect to the database. Exiting now...', err);
    process.exit();
});

// parse requests of content-type - application/json
app.use(bodyParser.json())

// Allow Cross Origins
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });
  

// define a simple route
app.get('/', (req, res) => {
    res.json({"message": "Welcome to the Application."});
});

// Require Notes routes
var UserController = require('./app/controllers/CustomerController');
app.use('/customer', UserController);

var AuthController = require('./app/authentication/AuthController');
app.use('/cashier', AuthController);


// listen for requests
app.listen(8080, () => {
    console.log("Server is listening on port 8080");
});