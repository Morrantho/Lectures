let mongoose = require("mongoose");
let Schema   = mongoose.Schema;
let ObjectId = Schema.Types.ObjectId;

mongoose.model("Listing",new mongoose.Schema({
	title:{type:String},
	description:{type:String,maxlength:200},
	price:{type:Number,default:1,minlength:1},
	location:{type:String},
	img:{type:String},

	user:{type:ObjectId,ref:"User"}
},{timestamps:true}));
