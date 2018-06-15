let mongoose = require("mongoose");

let TaskSchema = new mongoose.Schema({
	title:{type:String,required:true,minlength:2,maxlength:64},
	description:{type:String,default:"",maxlength:1024},
	completed:{type:Boolean,default:false},
},{timestamps:true});

mongoose.model("Task",TaskSchema);