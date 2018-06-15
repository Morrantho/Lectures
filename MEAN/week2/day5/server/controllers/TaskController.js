const Task = require("mongoose").model("Task");

class TaskController{
	all(req,res){
		Task.find({},(err,tasks)=>{
			if(tasks){
				return res.status(200).json(tasks);
			}else{
				return res.status(404).json({
					"error":err,
					"message":"Failed to find tasks"
				});	
			}
		});
	}

	findById(req,res){
		Task.findOne({_id:req.params.id},(err,task)=>{
			if(task){
				return res.status(200).json(task);
			}else{
				return res.status(404).json({
					"error":err,
					"message":"Failed to find task with id:"+req.params.id
				});
			}
		});
	}

	create(req,res){
		let task = new Task(req.body);

		task.save(err=>{
			if(err){
				return res.status(403).json({
					"error":err.errors,
					"message":"Failed to create Task!"
				});
			}else{
				return res.status(200).json(task);
			}
		});
	}

	update(req,res){
		Task.findOne({_id:req.params.id},(err,task)=>{
			if(task){
				task.title = req.body.title || task.title;
				task.description = req.body.description || task.description;
				task.completed = req.body.completed || task.completed;

				task.save(err=>{
					if(err){
						return res.status(403).json({
							"error":err,
							"message":"Failed to update task"+req.params.id
						});
					}else{
						return res.status(418).json(task);
					}
				});
			}else{
				return res.status(404).json({
					"error":err,
					"message":"Failed to find task "+req.params.id
				});
			}
		});
	}

	delete(req,res){
		Task.findOne({_id:req.params.id},(err,task)=>{
			if(task){
				Task.remove({_id:req.params.id},(err)=>{
					if(err){
						return res.status(404).json({
							"error":err,
							"message":"Failed to remove task "+req.params.id
						});
					}else{
						return res.json(task);
					}
				});
			}else{
				return res.status(404).json({
					"error":err,
					"message":"Failed to find task "+req.params.id
				});
			}
		});
	}
}

module.exports = new TaskController();