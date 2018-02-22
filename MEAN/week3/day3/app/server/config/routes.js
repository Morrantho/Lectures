let UserController     		  = require("../controllers/UserController.js");
let ProductController  		  = require("../controllers/ProductController.js");
let CategoryController 	      = require("../controllers/CategoryController.js");
let ProductCategoryController = require("../controllers/ProductCategoryController.js");

let path = require("path");

module.exports =(app)=>{
// ********************************************************
// Users
// ********************************************************
	app.post("/users/new",UserController.register);
	app.get("/session",UserController.session);
// ********************************************************
// Products
// ********************************************************
	app.get("/products",ProductController.all);
	app.post("/products/new",ProductController.create);
// ********************************************************
// Categories
// ********************************************************
	app.get("/categories",CategoryController.all);
	app.post("/categories/new",CategoryController.create);
// ********************************************************
// ProductsCategories
// ********************************************************
	app.get("/procats",ProductCategoryController.all);
	app.post("/procats/new",ProductCategoryController.create);
// ********************************************************
// Angular
// ********************************************************
	app.all("*", (req,res,next) => {
		res.sendFile(path.resolve("./client/dist/index.html"))
	});
}
