let UserController = require("../controllers/UserController.js");

module.exports =(app)=>{
	app.get("/users",UserController.all);
	app.get("/users/:id",UserController.findById);
	app.post("/users/:id/destroy",UserController.destroy);	
	app.post("/users/:id/update",UserController.update);	
	app.post("/users/new",UserController.create);
}