let express    = require("express");
let path       = require("path");
let app        = express();
let bodyParser = require("body-parser");

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, "./client/static")));
app.set('views', path.join(__dirname, './client/views'));
app.set('view engine', 'ejs');

require("./server/config/mongoose.js");
require("./server/config/routes.js")(app);

app.listen(8000,()=>{
	console.log("Server Running");
});