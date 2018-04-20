let UserController = require("../controllers/UserController.js");
let ListingController = require("../controllers/ListingController.js");
let path = require("path");

module.exports = (app)=>{
	app.post("/api/login",UserController.login);
	app.post("/api/register",UserController.register);
	app.get("/api/session",UserController.session);

	app.get("/api/clear",UserController.clear);

	app.get("/api/botd",ListingController.botd);

	app.get("/api/listings",ListingController.all);
	app.post("/api/listings",ListingController.create);
	app.get("/api/listings/:id",ListingController.find);

	app.delete("/api/listings/:id",ListingController.destroy);
	app.put("/api/listings/:id",ListingController.update);

	app.all("*",(req,res,next)=>{
		res.sendFile(path.resolve("./client/dist/index.html"));
	});
}