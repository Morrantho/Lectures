# Week 2 Day 4
## APIs and AJAX: revenge of the Acronyms
<img src="https://upload.wikimedia.org/wikipedia/commons/a/a1/AJAX_logo_by_gengns.svg" alt="AJAX" width="500px">

### What is an API, why do we use them?

<details>
  <summary>What is an API?</summary>
  <strong>A</strong>plication <strong>P</strong>rogramming <strong>I</strong>nterface<br>
  "it is a set of clearly defined methods of communication between various software components" -wikipedia<br>
  A way for one program to communicate with another.
</details><br>

<details>
  <summary>What is an API call?</summary>
  An http request to a server either expecting to receive data, or sendiong data. Sometimes they require a key to be sent along to verify the data is being sent to the correct user/not being abused.
</details><br>

Try going to ```http://pokeapi.co/api/v2/pokemon/1/``` in your browser. What is getting returned?

### Who is JSON?

<details>
  <summary>What is a JSON Object?</summary>
  JSON stands for Javascript Object Notation.<br>
  "It is a syntax for storing and exchanging data." -w3schools<br>
  Basically it is data that JavaScript, and other languages, can easily read/parse.
</details><br>

### What is AJAX?

<details>
  <summary>What is AJAX?</summary>
  <strong>A</strong>synchronous <strong>J</strong>avaScript <strong>A</strong>nd <strong>X</strong>ML<br>
  AJAX allows us to update data or submit data on a webpage without needing to refresh the page or redirect the user to another page. 
</details>

### How is AJAX different from tradition req/res cycle?

<img src="https://mdn.mozillademos.org/files/14456/MVC%20Express.png" alt="req/res cycle">

The traditional request / response cycle involves a user on a webbrowser making a request to a server, and that server using control logic to determine what information to fetch from the database and render into a HTML response.

<details>
  <summary>How is the traditional req/res cycle different than AJAX?</summary>
  For one, the traditional req/res cycle will give us a HTML response, not a JSON response. Another difference is that the traditional req/res cycle is a rigid 1:1 relationship between a user initiating a request and a server giving a response. With AJAX the server can provide the HTML/CSS/JS initially and then AJAX requests can handle reteiving data and rendering it using JS on the user's computer. The user can also send form data or other data to the server asynchronously without leaving the currently rendered HTML page. When you learn more about full-stack-development this will make more sense.
</details>

### $.ajax() vs $.get()

Which should you use?

```javascript
$.get("url to your api call", function(data){
	console,log(data);
}, "json");
```

Remember to replace the ```"url to your api call"``` with the correct url for your API call.
