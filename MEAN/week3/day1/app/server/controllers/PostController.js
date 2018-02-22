let Post = require("mongoose").model("Post");
let Comment = require("mongoose").model("Comment");


class PostController{
	// /posts/new
	create(req,res){
		let post = new Post(req.body);
		post._user = req.session.user_id;

		post.save((err)=>{
			if(err){
				return res.json({errors:post.errors});
			}else{
				return res.json(post);
			}
		});
	}

	// /posts
	all(req,res){
		Post.find({})
		.populate({
			path:"_user",
			model:"User"
		})
		.populate({
			path:"_comments",
			model:"Comment",

			populate:({
				path:"_user",
				model:"User"
			})
		})
		.exec(
			(err,posts)=>{
				if(posts){
					return res.json(posts);
				}else{
					return res.json({errors:"Failed to retrieve posts."});
				}
			}
		)
	}

	// "/posts/123"
	findById(req,res){
		Post.findOne({_id:req.params.id})
		.populate("Comments")
		.populate("User")
		.exec(
			(err,post)=>{
				if(err){
					return res.json({errors:"Error looking up post."});
				}else{
					return res.json(post);
				}
			}
		);
	}

// ********************************************************
// Comments
// ********************************************************

	// "/posts/123/comments/new"
	createComment(req,res){
		let comment   = new Comment(req.body);
		comment._user = req.session.user_id;
		comment._post = req.params.post_id;

		comment.save((err)=>{
			if(err){
				return res.json({errors:comment.errors});
			}else{
				Post.findOne({_id:req.params.post_id},(err,post)=>{
					if(post){
						post._comments.push(comment);

						post.save((err)=>{
							if(err){
								return res.json({errors:"Failed to bind to post."});
							}else{
								return res.json(comment);
							}
						});
					}else{
						return res.json({errors:"Failed to retrieve post."});
					}
				});
			}
		});
	}

	// "/posts/123/comments/456"
	findCommentById(req,res){
		Comment.findOne(({_id:req.params.comment_id})
		.populate("User")
		.exec((err,comment)=>{
			if(err){
				return res.json({errors:""});
			}else{
				return res.json(comment);
			}
		}));
	}
}

module.exports = new PostController();
