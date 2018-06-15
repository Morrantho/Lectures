const path = require("path");
const TaskController = require("../controllers/TaskController.js");

module.exports = function(app){
	app.get("/api/tasks",TaskController.all);
	app.post("/api/tasks",TaskController.create);
	app.get("/api/tasks/:id",TaskController.findById);
	app.delete("/api/tasks/:id",TaskController.delete);
	app.put("/api/tasks/:id",TaskController.update);

	app.all("*",(req,res,next)=>{
		res.sendFile(path.resolve("./client/public/dist/index.html"));
	});
}