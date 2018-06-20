const mongoose = require("mongoose");
const path     = require("path");
const fs       = require("fs");
const models   = path.join(__dirname,"../models");

mongoose.connect("mongodb://localhost:/marketplace");

fs.readdirSync( models ).forEach( function(file){
	if( file.indexOf(".js") >= 0 ){
		require( models+"/"+file );
	}	
});