let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

let u = mongoose.model('User',new mongoose.Schema({
	email:{type:String,required:true,minlength:1,maxlength:255},
	password:{type:String,required:true,minlength:1,maxlength:255},
},{timestamps:true}));
