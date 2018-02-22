let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

mongoose.model('Post',new mongoose.Schema({
	content:{type:String,required:[true,"Post content cannot be blank."],minlength:1,maxlength:1024},
	_user:{type:ObjectId,ref:"User"},
	_comments:[{type:ObjectId,ref:"Comments"}]
},{timestamps:true}));
