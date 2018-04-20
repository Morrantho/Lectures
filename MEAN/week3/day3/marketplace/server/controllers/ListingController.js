let Listing = require("mongoose").model("Listing");
let User    = require("mongoose").model("User");

class ListingController{
	all(req,res){
		Listing.find({})
		.populate({
			model:"User",
			path:"user"
		})
		.exec((err,listings)=>{
			if(err){
				return res.json({errors:"Failed to lookup listings."});
			}else{
				return res.json(listings);
			}
		})
	}

	find(req,res){
		Listing.findOne({_id:req.params.id})
		.populate({
			model:"User",
			path:"user"
		})
		.exec((err,listing)=>{
			if(err){
				return res.json({errors:"Failed to find listing!"});
			}else{
				return res.json(listing);
			}
		});
	}

	create(req,res){
		if(!req.session.user_id){
			return res.json({errors:"You must be logged in to create a listing!"});
		}

		let newListing = new Listing(req.body);
		newListing.user = req.session.user_id;

		newListing.save((err)=>{
			if(err){
				return res.json({errors:err});
			}else{
				User.findOne({_id:req.session.user_id},(err,user)=>{
					user.listings.push(newListing);

					user.save((err)=>{
						if(err){
							return res.json({errors:err});
						}else{
							return res.json(newListing);
						}
					});
				});
			}
		});
	}

	update(req,res){
		console.log("UPDATE!!!!!!!!!!!!!!!!!!!!!!!");

		Listing.findOne({_id:req.params.id},(err,listing)=>{

			if(listing){
				listing.title = req.body.title || listing.title;
				listing.description = req.body.description || listing.description;
				listing.price = req.body.price || listing.price;
				listing.src = req.body.src || listing.src;
				listing.location = req.body.location || listing.location;

				listing.save((err)=>{
					if(err){
						return res.json({errors:err});
					}else{
						return res.json(listing);
					}
				});
			}else{
				return res.json({errors:"Failed to find listing!"});
			}
		});
	}

	destroy(req,res){
		Listing.findOne({_id:req.params.id},(err,listing)=>{

			if(listing){
				if(!req.session.user_id){
					return res.json("You must be logged in to delete a listing!");
				}

				User.findOne({_id:req.session.user_id},(err,user)=>{
					if(err){
						return res.json({errors:err});
					}else{
						Listing.remove({_id:req.params.id},(err)=>{
							if(err){
								return res.json({errors:"Failed to remove listing!"});
							}else{
								for(let i=0;i<user.listings.length;i++){
									if(user.listings[i] == listing._id){
										user.listings.splice(i);
									}
								}

								user.save((err)=>{
									if(err){
										return res.json({errors:err});
									}else{
										return res.json(listing);
									}
								});
							}
						});						
					}
				});



			}else{
				return res.json({errors:"Failed to destroy listing."});
			}

		});

	}

	botd(req,res){
		Listing.find({},(err,listings)=>{
			let rnd = Math.floor(Math.random()*listings.length);

			if(err){
				return res.json({errors:err});
			}else{
				return res.json(listings[rnd]);
			}
		})
	}
}

module.exports = new ListingController();