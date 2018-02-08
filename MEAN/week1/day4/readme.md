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

* <details>
	<summary>How do we install / download Express?</summary>

	Using NPM! Once we have a package.json file by running: <code>npm init -y</code>, we can start installing modules! To install express, we just need to run: <code>npm install express --save</code>.
</details>

* <details>
	<summary>Why would we not install Globally?</summary>

	Version control: If we installed everything globally, what would happen if we required an older version of express to support an older project we worked on, but we currently have the latest version installed globally?

	Naming conflicts, errors and a cluttered global namespace would happen.

	Another reason: We may not want to use Express. Maybe we want a different framework to handle our routing. In this case, we just don't npm install express and instead install something else.
</details>

* <details>
	<summary>What should be in package.json?</summary>

	Our package.json should contain details about our project like its name, version, description, author and required dependencies.
</details>

* <details>
	<summary>What are the req and res objects within an Express route?</summary>

	The request object gives us details about the route a client has visited, the HTTP method accessed, POST / form data, route parameters and much more.

	The response object lets us send data such as .html, .css, .json back to the client, redirect them to a different route and much more.

	<code>console.log()</code> these objects to find out more about what kind've data they contain.
</details>

* <details>
	<summary>What does require mean?</summary>

	We're copying all of the contents of the file we're requiring into our own code, pasting / storing as a variable.
</details>

* <details>
	<summary>How do callbacks fit into this?</summary>

	We'll be using callbacks for all of our routing rules. We might say <code>app.get("/")</code> as our first argument and a callback as the second as to say: "After a client has visited this route, we will execute the following code."
</details>
