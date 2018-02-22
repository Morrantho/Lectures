let Category = require("mongoose").model("Category");

class CategoryController{
	create(req,res){
		let category = new Category(req.body);

		category.save((err)=>{
			if(err){
				return res.json({errors:category.errors});
			}else{
				return res.json(category);
			}
		});
	}

	all(req,res){
		Category.find({},(err,cats)=>{
			if(cats){
				return res.json(cats);
			}else{
				return res.json({errors:"Failed to find categories"});
			}
		});
	}
}

module.exports = new CategoryController();
