let express = require("express");
let app = express();

app.use(express.static(__dirname + "/static"));
app.set('views', __dirname + '/views'); 
app.set('view engine', 'ejs');

app.get("/",(req,res)=>{
	res.render("index");
})

app.listen(8000,function(){
	console.log("Server is running on port: 8000");
});