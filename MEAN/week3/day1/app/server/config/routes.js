let UserController = require("../controllers/UserController.js");
let PostController = require("../controllers/PostController.js");

let path = require("path");

module.exports =(app)=>{
// ********************************************************
// Users
// ********************************************************
	app.post("/users/new",UserController.register);
	app.get("/session",UserController.session);
// ********************************************************
// Posts
// ********************************************************
	app.post("/posts/new",PostController.create);
	app.get("/posts",PostController.all);
	app.get("/posts/:id",PostController.findById);
// ********************************************************
// Comments
// ********************************************************
	app.post("/posts/:post_id/comments/new",PostController.createComment);
	app.get("/posts/:post_id/comments/comment_id",PostController.findCommentById);
// ********************************************************
// Angular
// ********************************************************
	app.all("*", (req,res,next) => {
		res.sendFile(path.resolve("./client/dist/index.html"))
	});
}
