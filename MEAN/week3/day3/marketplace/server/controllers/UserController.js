let mongoose = require("mongoose");
let User = mongoose.model("User");
let bcrypt = require("bcrypt");

class UserController{
	clear(req,res){
		req.session.user_id = undefined;
	}

	register(req,res){
		User.findOne({email:req.body.email},(err,user)=>{
			if(user){
				return res.status(403).json({errors:"A user with this email already exists!"});
			}

			let newUser = new User(req.body);

			bcrypt.hash(newUser.password,8,function(err, hash){
				if(err)res.json({errors:err});
				newUser.password = hash;

				newUser.save((err)=>{
					if(err) res.status(403).json({errors:err});
					req.session.user_id = newUser._id;
					return res.status(200).json(newUser);
				});
			});

		});

	}

	// login(req,res){
	// 	User.findOne({email:req.body.email},(err,user)=>{
	// 		if(user){
	// 			bcrypt.compare(req.body.password, user.password, function(err, valid){
	// 				if(valid){
	// 					req.session.user_id = user._id;
	// 					return res.json(user);
	// 				}else{
	// 					return res.json({errors:"Invalid Credentials."});
	// 				}
	// 			});
	// 		}else{
	// 			return res.json({errors:"No user with this email was found."});
	// 		}
	// 	});
	// }

	login(req,res){
		User.findOne({email:req.body.email})
		.populate({
			model:"Listing",
			path:"listings"
		})
		.exec((err,user)=>{
			if(user){
				bcrypt.compare(req.body.password, user.password, function(err, valid){
					if(valid){
						req.session.user_id = user._id;
						return res.json(user);
					}else{
						return res.json({errors:"Invalid Credentials."});
					}
				});
			}else{
				return res.json({errors:"No user with this email was found."});
			}	
		});
	}

	session(req,res){
		if(req.session.user_id){
			User.findOne({_id:req.session.user_id})
			.populate({
				model:"Listing",
				path:"listings"
			})
			.exec((err,user)=>{
				if(user){
					return res.json(user); 
				}else{	
					return res.json({errors:err});
				}
			});
		}else{
			return res.json(false);
		}
	}
}

module.exports = new UserController();