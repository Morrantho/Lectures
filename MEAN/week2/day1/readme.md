# Week 2 Day 1

## Modularization

<img src="https://coursework.vschool.io/content/images/2015/11/mongoosejs.png" alt="Mongoose JS Logo" width="200px">

### Overview:

* Modularizing Routes
* Modularizing Models
* Modularizing Views
* Modularizing Controllers

### Discussion Questions:

<details>

​	<summary>What is MVC?</summary>

​	MVC stands for Model, View and Controller. Its a standard used by Web Developers to distinguish and separate out core parts of our applications. Up to this point, we've been cramming all of our code into one big server.js file. We're going to be adapting the MVC standard today.
</details>

<details>

​	<summary>What do models look like in MEAN?</summary>

​	Our models are our "collections" in MongoDB. They are created for us in MongoDB automatically via mongoose when we define them using: new mongoose.Schema() and naming our collection using: mongoose.model()

​	Example "User.js" model:

```javascript

	// Require mongoose

	let mongoose = require('mongoose');

	// Name our model "User" and define it using mongoose.Schema()

	mongoose.model('User',new mongoose.Schema({
		name:{type:String,required:true,minlength:1,maxlength:255},
		email:{type:String,required:true,minlength:1,maxlength:255},
		password:{type:String,required:true,minlength:1,maxlength:255},
	}));

```
</details>

<details>

​	<summary>What do Controllers look like in MEAN?</summary>

​	Our Controllers are the logic of our application that state what should happen when our client's visit routes. Our controllers will manipulate one of our "models" via CRUD methods. In this case, our recently created "User" model.

​	Example "UserController.js" controller:

```javascript
	
	// Import our User model that we created above.

	let User = require("mongoose").model("User");

	class UserController{
		// Retrieves all users and renders them to our "users.ejs":

		all(req,res){
			User.find({},(err,users)=>{
				if(err){
					res.render("users");
				}else{
					res.render("users",{users:users});
				}
			})
		}

		// A post route for creating a new user:

		create(req,res){
			let user = new User(req.body);

			user.save((err)=>{
				if(err){
					res.render("users",{errors:user.errors});
				}else{
					res.redirect("/users");
				}
			})
		}

		// A post route for updating an existing user:

		update(req,res){
			User.findOne({_id:req.body._id},(err,user)=>{
				user.name=req.body.name;
				user.email=req.body.email;
				user.password=req.body.password;

				user.save((err)=>{
					if(err){
						res.redirect("/users/"+user._id);
					}else{
						res.redirect("/users");
					}
				});
			})
		}

		// A get route for finding and displaying one particular user.

		findById(req,res){
			User.findOne({_id:req.params.id},(err,user)=>{
				if(err){
					res.redirect("/users");
				}else{
					res.render("user",{user:user});
				}
			});
		}

		// A post route for deleting a user by Id.

		destroy(req,res){
			User.remove({_id:req.params.id},(err)=>{
				res.redirect("/users");
			});
		}
	}

	// Export our class, so we can use it in other files.

	module.exports = new UserController();

```
</details>

<details>
​	<summary>What are the differences between rendering data to views and returning JSON data?</summary>

​	The most important difference is that we won't be retrieving data from our database and then 	rendering it to a page to be sent out to clients. We will simply be returning JSON data from the routes we define instead. This means that any routes we navigate to will be JSON data that any front-end framework or API can use to display on their own web page.

​	This will tremendously reduce the load our server will take, since it doesn't have to render any data, but rather give it back to client's so that they can display it however they choose. In doing this, we've essentially turned our server into an A.P.I

</details>

<details>

​	<summary>Group Activity</summary>

​	Collaborate into groups of 3 or 4, discussing how you can break down your application into smaller parts. Take a look at the github "modular" example to see how you might do this.

​	Create one model, one controller and one view that retrieves and displays all of your model and lets you create instances of that model.  

</details>