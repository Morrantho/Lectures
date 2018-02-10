let User = require("mongoose").model("User");

class UserController{
	all(req,res){
		User.find({},(err,users)=>{
			if(err){
				res.render("index");
			}else{
				res.render("index",{users:users});
			}
		})
	}

	create(req,res){
		let user = new User(req.body);

		user.save((err)=>{
			if(err){
				res.render("index",{errors:user.errors});
			}else{
				res.redirect("/users");
			}
		})
	}
}

module.exports = new UserController();