let User = require("mongoose").model("User");

class UserController{
	all(req,res){
		User.find({},(err,users)=>{
			if(err){
				res.render("users");
			}else{
				res.render("users",{users:users});
			}
		})
	}

	create(req,res){
		let user = new User(req.body);

		user.save((err)=>{
			if(err){
				res.render("users",{errors:user.errors});
			}else{
				res.redirect("/users");
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
					res.redirect("/users/"+user._id);
				}else{
					res.redirect("/users");
				}
			});
		})
	}

	findById(req,res){
		User.findOne({_id:req.params.id},(err,user)=>{
			if(err){
				res.redirect("/users");
			}else{
				res.render("user",{user:user});
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