let ProductCategory = require("mongoose").model("ProductCategory");

class ProductCategoryController{
	all(req,res){
		ProductCategory.find({})
		.populate({
			path:"category",
			model:"Category"
		})
		.populate({
			path:"product",
			model:"Product"
		})
		.exec((err,data)=>{
			if(data && !err){
				return res.json(data);
			}else{
				return res.json({errors:err});
			}
		});
	}

	create(req,res){
		let procat = new ProductCategory(req.body);

		console.log(procat);

		procat.save((err)=>{
			if(err){
				return res.json({errors:procat.errors});
			}else{
				ProductCategory.findOne({_id:procat._id})
				.populate({
					path:"category",
					"model":"Category"
				})
				.populate({
					path:"product",
					model:"Product"
				})
				.exec((err,newProCat)=>{
					if(err){
						return res.json({errors:err});
					}else{
						return res.json(newProCat);
					}
				});
			}
		});
	}
}

module.exports = new ProductCategoryController();
