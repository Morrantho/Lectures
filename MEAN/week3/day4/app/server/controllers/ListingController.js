let Listing = require("mongoose").model("Listing");
let User    = require("mongoose").model("User");

class ListingController{
	all(req,res){
		Listing.find({})
		.populate({
			path:"user",
			model:"User"
		})
		.exec((err,listings)=>{
			if(listings){
				return res.json(listings);
			}else{
				return res.json({errors:"Failed to retrieve listings."});
			}
		});
	}

	findById(req,res){
		Listing.findOne({_id:req.params.id})
		.populate({
			path:"user",
			model:"User"
		})
		.exec((err,listing)=>{
			if(listing){
				return res.json(listing);
			}else{
				return res.json({errors:"Failed to populate listing."});
			}
		});
	}

	create(req,res){
		let listing = new Listing(req.body);

		listing.user = req.session.user_id;

		listing.save((err)=>{
			if(err){
				return res.json({errors:listing.errors});
			}else{
				User.findOne({_id:req.session.user_id},(err,user)=>{
					if(user){
						user.listings.push(listing);

						user.save(err=>{
							if(err){
								return res.json({errors:user.errors});
							}else{
								return res.json(listing);
							}
						})
					}else{
						return res.json({errors:"Failed to lookup user."});
					}
				});

			}
		});
	}

	update(req,res){
		Listing.findOne({_id:req.params.id},(err,listing)=>{
			if(err){
				return res.json({errors:err});
			}else{
				listing.title = req.body.title;
				listing.description = req.body.description;
				listing.price = req.body.price;
				listing.location = req.body.location;
				listing.src = req.body.src;

				listing.save(err=>{
					if(err){
						return res.json({errors:err});
					}else{
						return res.json(listing);
					}
				});
			}
		});
	}

	destroy(req,res){
		Listing.remove({_id:req.params.id},(err)=>{
			if(err){
				return res.json(false);
			}else{
				return res.json(true);
			}
		});
	}

	lotd(req,res){
		Listing.find({})
		.populate({
			path:"user",
			model:"User"
		})
		.exec((err,listings)=>{
			if(listings){
				let index = Math.floor(Math.random() * listings.length);
				let listing = listings[index];

				return res.json(listing);
			}else{
				return res.json({errors:"Failed to retrieve listings."});
			}
		});
	}
}

module.exports = new ListingController();
