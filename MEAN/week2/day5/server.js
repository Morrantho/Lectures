const express    = require("express");
const path       = require("path");
const bodyParser = require("body-parser");
const mongoose   = require("mongoose");
const session    = require("express-session");
const flash      = require("express-flash");
const PORT       = 8000;

const app = express();

app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());
app.use(express.static(path.join(__dirname,'/client/public/dist')));
app.use(flash());

require("./server/config/mongoose.js");
require("./server/config/routes.js")(app);

app.listen(PORT,()=>{
	console.log("Server is running on:",PORT);
})