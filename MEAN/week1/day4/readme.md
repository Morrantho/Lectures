# Week 1 - Day 4

## Express.js

<img src="https://camo.githubusercontent.com/fc61dcbdb7a6e49d3adecc12194b24ab20dfa25b/68747470733a2f2f692e636c6f756475702e636f6d2f7a6659366c4c376546612d3330303078333030302e706e67" alt="JavaScript Logo" width="200px">

### Overview:

* Installation
* Express HTTP Methods
* package.json
* Static Content
* EJS + Views

### Discussion Questions:

<details><summary>How do we install/download Express?</summary>

Since Express is a Node module, we install it using NPM!

Once we have a package.json file by running:

	$ npm init -y

We can start installing modules. To install Express, we just need to run:

	$ npm install express --save

This installs the Express module (and all of the modules that Express is dependent on) in your project folder.

**Note:** This command should be run through the terminal from inside of the project directory. (If you are on a Mac you may need to run this command as sudo.)

</details>

<details><summary>Why would we not install Express globally?</summary>

Version control: If we installed everything globally, what would happen if we required an older version of Express to support an older project we worked on, but we currently have the latest version installed globally?

Naming conflicts, errors and a cluttered global namespace would happen.

Another reason: We may not want to use Express. Maybe we want a different framework to handle our routing. In this case, we just don't npm install express and instead install something else.
</details>

<details><summary>What should be in package.json?</summary>

Our package.json should contain details about our project like its name, version, description, author and required dependencies.

If you delete your node modules folder, you can recreate it using your package.json.

</details>

<details><summary>What are the req and res objects within an Express route?</summary>

The **request** object gives us details about the route a client has visited, the HTTP method accessed, POST / form data, route parameters and much more.

The **response** object lets us send data such as .html, .css, .json back to the client, redirect them to a different route and much more.

**Pro tip:** console.log() these objects to find out more about what kind of data they contain. :)
	
	
</details>

<details><summary>What does "require" mean?</summary>

We're copying all of the contents of the file we're requiring into our own code, pasting/storing it as a variable.

</details>

<details><summary>How do callbacks fit into this?</summary>

We'll be using callbacks for all of our routing rules.

We might say app.get() with "/" as our first argument and a callback as the second, as if to say: "After a client has visited this route, we will execute the following code."

Example:

```javascript
app.get("/",(request,response)=>{
	response.render("index");
})
```
	
</details>
