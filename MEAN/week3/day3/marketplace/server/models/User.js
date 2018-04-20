let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

mongoose.model('User',new mongoose.Schema({
	email:{type:String,required:true,minlength:1,maxlength:255},
	password:{type:String,required:true,minlength:8,maxlength:2048},
	listings:[{type:ObjectId,ref:"Listings"}]
},{timestamps:true}));