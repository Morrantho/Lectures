let UserController    = require("../controllers/UserController.js");
let ListingController = require("../controllers/ListingController.js");

let path = require("path");

module.exports =(app)=>{
// ********************************************************
// Users
// ********************************************************
	app.post("/api/register",UserController.register);
	app.post("/api/login",UserController.login);
// ********************************************************
// Listings
// ********************************************************
	app.get("/api/listings",ListingController.all);
	app.post("/api/listings/new",ListingController.create);
	app.get("/api/listings/lotd",ListingController.lotd);
	app.get("/api/listings/:id",ListingController.findById);
	app.put("/api/listings/:id/update",ListingController.update);
	app.delete("/api/listings/:id/destroy",ListingController.destroy);
// ********************************************************
// Angular
// ********************************************************
	app.all("*", (req,res,next) => {
		res.sendFile(path.resolve("./client/dist/index.html"))
	});
}
