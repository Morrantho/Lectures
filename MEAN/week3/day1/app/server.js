let express    = require("express");
let app        = express();
let bodyParser = require("body-parser");
let session    = require("express-session");
const port     = 8000;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(__dirname+"/client/dist"));
app.use(express.json());
app.use(session({secret:"hideme"}));

require("./server/config/mongoose.js");
require("./server/config/routes.js")(app);

app.listen(port,()=>{
	console.log("Listening on: "+port);
});
