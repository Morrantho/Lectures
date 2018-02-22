let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

mongoose.model('Category',new mongoose.Schema({
	title:{type:String,required:true,minlength:1,maxlength:255},
},{timestamps:true}));
