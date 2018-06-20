let ListingController = require("../controllers/ListingController.js");
let UserController = require("../controllers/UserController.js");

module.exports = function(app){
	/*UserController*/
	app.post("/api/users/register",UserController.register);
	app.post("/api/users/login",UserController.login);
	app.get("/api/users/logout",UserController.logout);
	app.get("/api/users/:id",UserController.findById);
	/*ListingController*/
	app.post("/api/listings",ListingController.create);
	app.get("/api/listings",ListingController.all);
	app.get("/api/listings/:id",ListingController.findById);
	app.put("/api/listings/:id",ListingController.update);
	app.delete("/api/listings/:id",ListingController.destroy);
}