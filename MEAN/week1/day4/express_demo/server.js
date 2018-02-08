let express = require("express");
let app = express();

app.use(express.static(__dirname + "/static"));
app.set('views', __dirname + '/views'); 
app.set('view engine', 'ejs');

app.get("/",(req,res)=>{
	res.render("index");
})

app.listen(8000,()=>{
	console.log("Running on port 8000");	
});