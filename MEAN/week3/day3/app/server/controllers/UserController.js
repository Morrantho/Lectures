let User = require("mongoose").model("User");

class UserController{

	register(req,res){
		User.findOne({email:req.body.email},(err,user)=>{
			if(user){
				return res.json({errors:"A user with this email already exists!"});
			}else{
				let newUser = new User(req.body);

				newUser.save((err)=>{
					if(err){
						return res.json({errors:newUser.errors});
					}else{
						req.session.user_id = newUser._id;
						return res.json(newUser);
					}
				});
			}
		});
	}

	logout(req,res){
		req.session.user_id = undefined;
		// return res.json(true);
	}

	session(req,res){
		if(req.session.user_id){
			User.findOne({_id:req.session.user_id},(err,user)=>{
				if(user){
					return res.json(user);
				}else{
					return res.json({errors:"Invalid Session."});
				}
			});
		}else{
			return res.json({errors:"Invalid Session."});
		}
	}
}

module.exports = new UserController();
