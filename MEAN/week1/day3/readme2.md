# Week 1 - Day 3 - Afternoon

## NodeJS

<img src="https://nodejs.org/static/images/logos/nodejs-new-pantone-black.png" alt="NodeJS Logo" width="200px">

### Discussion:

* Installation
* NPM + Node Modules
* FS & HTTP
* Basic Server

### NodeJS:

NodeJS is a Javascript interpreter. We can run javascript directly from a terminal, without relying on our browser. It was built with the intention of supporting thousands of connections simultaneously. In other words, it was built for speed. We'll be using it to host our WebServer.

### Installation:

* <details>
	<summary>How do I install NodeJS?</summary>

	Visit: https://nodejs.org/en/
</details>

### NPM + Node Modules:

* <details>
	<summary>What is NPM and what are Node Modules?</summary>

	NPM is the package manager for Node. It comes bundled with it. It stands for Node Package Manager. We can use it to gain access to thousands of other user-created plugins / packages / scripts that we want to use / have access to in our code. Think back to Python. NPM is the "pip" of MEAN.

	Node Modules are the modules / plugins / scripts themselves that we've installed using NPM either globally or for a certain project. They are organized in a node_modules folder within our current project or in a global node_modules folder wherever you installed Node on your PC.
</details>

### FS and HTTP:

* <details>
	<summary>What does FS stand for?</summary>

	Filesystem!

	We can use it to read or write files on our PC. We'll be using it initially to read file contents, sending it to a client via HTTP!

	Example:

	```javascript
		let fs = require("fs"); // Import fs, so we can read / write files.

		// Reading a file and printing its content:

		fs.readFile("index.html","utf8",function(errs,content){
			console.log(content);
		})
	```
</details>

* <details>
	<summary>How can we host a server with HTTP and FS?</summary>

	First, import http and call http.createServer(), passing it a callback that gets run when our server is ready. This callback lets us access a request and response object.

	We can access the url a client visited with request.url. With this, we can serve different files based on the location a client visited. We then state the type of data we intend to send back as html and write the file contents into the response:

	```javascript
		var http = require('http');
		var fs = require('fs');

		var server = http.createServer(function (request, response){
		    if(request.url === '/') {
		        fs.readFile('index.html', 'utf8', function (errors, contents){
		            response.writeHead(200, {'Content-Type': 'text/html'});
		            response.write(contents);  //  send response body
		            response.end(); // finished!
		        });
		    }
		    // request didn't match anything:
		    else {
		        response.writeHead(404);
		        response.end('File not found!!!');
		    }
		});
		// tell your server which port to run on
		server.listen(6789);
	```
</details>