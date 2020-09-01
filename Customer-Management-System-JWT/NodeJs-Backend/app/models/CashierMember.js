var mongoose = require('mongoose');  
var UserSchema = new mongoose.Schema({  
  name: String,
  contact: String,
  userName:String,
  password: String
});
mongoose.model('CashierMember', UserSchema);

module.exports = mongoose.model('CashierMember');