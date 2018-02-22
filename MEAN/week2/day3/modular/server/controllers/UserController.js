let User = require("mongoose").model("User");

class UserController{
	all(req,res){
		User.find({},(err,users)=>{
			if(err){
				res.status(404).json("Failed to retrieve users");
			}else{
				res.json(users);
			}
		})
	}

	create(req,res){
		let user = new User(req.body);

		user.save((err)=>{
			if(err){
				res.status(406).json(user.errors);
			}else{
				res.json(user);
			}
		})
	}

	update(req,res){
		User.findOne({_id:req.body._id},(err,user)=>{
			user.name=req.body.name;
			user.email=req.body.email;
			user.password=req.body.password;

			user.save((err)=>{
				if(err){
					res.status(406).json(user.errors);
				}else{
					res.json(user);
				}
			});
		})
	}

	findById(req,res){
		User.findOne({_id:req.params.id},(err,user)=>{
			if(err){
				res.status(404).json("Failed to find user: "+req.params.id);
			}else{
				res.status(200).json(user);
			}
		});
	}

	destroy(req,res){
		User.remove({_id:req.params.id},(err)=>{
			res.redirect("/users");
		});
	}
}

module.exports = new UserController();