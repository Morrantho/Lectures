let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

mongoose.model('Comment',new mongoose.Schema({
	content:{type:String,required:[true,"Post content cannot be blank."],minlength:1,maxlength:1024},
	_user:{type:ObjectId,ref:"User"},
	_post:{type:ObjectId,ref:"Post"}
},{timestamps:true}));
