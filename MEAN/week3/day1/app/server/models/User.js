let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

mongoose.model('User',new mongoose.Schema({
	email:{type:String,required:true,minlength:1,maxlength:255},
	password:{type:String,required:true,minlength:1,maxlength:255},
	posts:[{type:ObjectId,ref:"Posts"}],
	comments:[{type:ObjectId,ref:"Comments"}],
},{timestamps:true}));
