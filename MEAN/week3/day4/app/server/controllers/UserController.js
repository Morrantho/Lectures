let User = require("mongoose").model("User");

class UserController{
	all(req,res){
		User.find({},(err,users)=>{
			if(users){
				return res.json(users);
			}else{
				return res.json({errors:"Failed to retrieve users"});
			}
		});
	}

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

	login(req,res){
		User.findOne({email:req.body.email},(err,user)=>{
			if(!user){
				return res.json({errors:"No user with this email was found."});
			}else{
				if(req.body.password == user.password){
					req.session.user_id = user._id;
					return res.json(user);
				}else{
					return res.json({errors:"Invalid Credentials."});
				}
			}
		});
	}
}

module.exports = new UserController();
