let Product = require("mongoose").model("Product");

class ProductController{
	create(req,res){
		let product = new Product(req.body);

		product.save((err)=>{
			if(err){
				return res.json({errors:product.errors});
			}else{
				return res.json(product);
			}
		});
	}

	all(req,res){
		Product.find({},(err,pros)=>{
			if(pros){
				return res.json(pros);
			}else{
				return res.json({errors:"Failed to find products"});
			}
		});
	}
}

module.exports = new ProductController();
