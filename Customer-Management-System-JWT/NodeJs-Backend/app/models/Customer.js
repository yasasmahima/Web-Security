var mongoose = require('mongoose');  
var UserSchema = new mongoose.Schema({  
  name: String,
  contact: String,
});
mongoose.model('Customer', UserSchema);

module.exports = mongoose.model('Customer');