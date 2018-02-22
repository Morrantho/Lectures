let mongoose = require('mongoose');
let ObjectId = mongoose.Schema.Types.ObjectId;

mongoose.model('ProductCategory',new mongoose.Schema({
	category:{type:ObjectId,ref:"Category"},
	product:{type:ObjectId,ref:"Product"}
},{timestamps:true}));
