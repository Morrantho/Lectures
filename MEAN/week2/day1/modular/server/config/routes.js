let UserController = require("../controllers/UserController.js");

module.exports =(app)=>{
	app.get("/users",UserController.all);
	app.post("/users/new",UserController.create);
}