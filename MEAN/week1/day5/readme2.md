# Week 1 - Day 5 - Afternoon

## Mongoose

<img src="https://coursework.vschool.io/content/images/2015/11/mongoosejs.png" width="400" alt="">

### Learning Objectives:

* Installation
* Connecting a DB to Node.
* CRUD with Mongoose.
* Validations
* Associations / Relationships

### Discussion Questions:

<details>
	<summary>Can we use Mongo without Mongoose? How?<summary>

	Yes. There are other Node modules that allow us to connect to a mongodb server other than Mongoose. In Python, py-mongo is a plugin that lets us do this same thing. Feel free to explore different plugins that will let you do this.
</details>

<details>
	<summary>Can we do joins with Mongoose?</summary>

	Sort've. MongoDB is non-relational, but we can still store references to Object Id's, which means we can compare against other Object Id's in another collection.
</details>

<details>
	<summary>How can we install Mongoose and connect it to a mongoDB database?</summary>

	First, we need to run <code>npm install mongoose --save</code> in our terminal. Then we need to require it and run <code>mongoose.connect()</code>. The last forward slash followed by a word is the database we are telling mongoDB to use.

	```javascript
		var mongoose = require('mongoose');
		mongoose.connect('mongodb://localhost/myDatabase');
	```
</details>

<details>
	<summary>What is a Mongoose Schema and how do we create one using Mongoose?</summary>

	A schema in Mongoose is simply a collection in MongoDB. Once we create one, we will have full access / control of MongoDB CRUD methods via our Node server. Mongoose will create this collection in the database we chose using: <code>mongoose.connect();</code>

	```javascript

		// Give this collection name and age columns.

		let UserSchema = new mongoose.Schema({
			name: String,
			age: Number
		})

		// Name this collection "User"

		mongoose.model('User', UserSchema);

		// Retrieve our newly created collection, so we can manipulate it.

		let User = mongoose.model('User')

	```
</details>

<details><summary>Where would these Database Calls be placed in our Node app? What would that look like?<summary>

These database calls would happen in our controllers, based on the CRUD action we intend to take:

	```javascript

		// Creating / Saving a new "User"

		app.post("/users/new",(req,res)=>{
			let user = new User(req.body);

			user.save((err)=>{
				if(err){
					res.status(400).json("Failed to save user");
				}else{
					res.redirect("/users");						
				}
			});
		});

	```
</details>

<details>
	<summary>How many callbacks do you see in a single HTTP POST route for a Creation operation?</summary>

	There are usually two. The first one to indicate what we want to do upon a client visiting our route. The second is what we want to do when we've successfully or unsuccessfully saved / inserted the new document.
</details>

<details>
	<summary>How can we validate models now that we can insert data?</summary>

	With minor changes to our schema, we can add validations to indicate that fields are required, must meet a minimum and maximum length and more:

	```javascript

		var UserSchema = new mongoose.Schema({
		    first_name:  { type: String, required: true, minlength: 6},
		    last_name: { type: String, required: true, maxlength: 20 },
		    age: { type: Number, min: 1, max: 150 },
		    email: { type: String, required: true }
		}, {timestamps: true });


	```
</details>

<details>
	<summary>How do we show these errors to user's?</summary>

	Inside of our <code>.save()</code> callback, we now have access to an <code>.errors</code> property. We'll be using it to render the errors onto the context of our <code>.ejs</code> files:

	```javascript

		let user = new User(req.body);

	    user.save(function(err){
	        if(err){
	            res.render('index', {errors: user.errors})
	        }else{
	            res.redirect('/users');
	        }
	    });


	```

	We can then loop these errors on our view:

	```javascript

		<% if(typeof(errors) != 'undefined' ) { %>
			<% for (var x in errors) { %>
				<h3><%= errors[x].message %></h3>
			<% } %>
		<% } %> 

	```
</details>

<details>
	<summary>How about relationships? How can I integrate a One-To-Many?</summary>

	On your schema that contains "Many", make it an Array that holds references to Object Id's. You can then use the "ref" property to refer to another Model.

	On your schema that contains "One" make it a singular value that references an Object Id. You will also use the "ref" property to refer to the above model.

	Refer To:

	http://learn.codingdojo.com/m/4/4726/33910
</details>