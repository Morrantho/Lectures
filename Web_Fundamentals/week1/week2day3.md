# Week 2 Day 3
## jQuery Part II
<img src="https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/JQuery_logo.svg/1280px-JQuery_logo.svg.png" alt="jQuery" width="500px">

### Callbacks revisited
A callback is just a function that we pass as a variable into another function. The function we pass it into can call the callback function. This can be a handy way to to pass data from one function to another function as well.

<details>
  <summary>Why is a callback function called a callback function?</summary>
  Because the function into which it is being passed as an argument calls it... back.
</details><br>

```javascript
function acceptsCallback(callback){
  return callback();
}

console.log(acceptsCallback(function(){
  return "I'm being called by the function acceptsCallback";
}));

// this will print "I am coming from your callback function!"


function acceptsCallback2(callback){
  return callback("It's dangerous to go alone, take this data!");
}

console.log(acceptsCallback2(function(data){
  return data;
}));

// this will print "It's dangerous to go alone, take this data!"
```

### The DOM review

<details>
  <summary>Is the DOM exactly equal to our HTML code?</summary>
  No. But it is generated from our HTML code.
</details><br>

```html
<table border=1>
	<tr><th>Test</th></tr>
	<tr><td>Data</td></tr>
</table>
```
<details>
  <summary>Does the above table have <code>&lt;tbody&gt;</code> tags?</summary>
	Yes. The browser will automatically generate a <code>&lt;tbody&gt;</code> for us even if we didn't write it. You can style it with CSS and everything.
</details><br>

<details>
  <summary>How else could the DOM differ from out HTML? (Hint: what have we been learning this week)</summary>
  It can contain HTML generated from JavaScript.
</details>

### Static vs Dynamic

<details>
  <summary>What is Static content? How does it differ from Dynamic content?</summary>
    Static content doesn't change.
    Dynamic content is generated dynamically, or changed.
</details><br>

### What is ```$(this)``` ?

```this``` is whatever object you currently have selected! If you open your browser's console and type ```this``` it returns ```Window {stop: ƒ, open: ƒ, alert: ƒ, confirm: ƒ, prompt: ƒ, …}```. 

```html
<!-- in our html -->
<div>
	I am Gabriel the div
</div>
<div>
	I am Josephine the div
</div>
```
```javascript
// in our javascript
$("div").click(function(){
	console.log($(this).text());
});
```
<details>
  <summary>What is console logged when I click on the first div?</summary>
    <code>I am Gabriel the div</code>
</details><br>

### Why would we use ```.on()``` ?
```html
<button>Click Me</button>
<div id="target"></div>

<script type="text/javascript">
    $(document).ready(function(){
        $("button").click(function(){
            $("#target").append("<h1>I am an appended element!</h1>");
	});

	$("h1").click(function(){
	    console.log("You have clicked an h1 tag! Good job!");
	});
		
	$(document).on("click", "h1", function(){
	    console.log("using '.on()' this time");
	})
    })
</script>
```
<details>
  <summary>If we click on the button a few times, then click on any of the appended <code>&lt;h1&gt;</code> tags what gets console logged? Why?</summary>
	  <code>"using '.on()' this time"</code><br>
	  The <code>.click()</code> event is attached to any <code>&lt;h1&gt;</code> tags right after the document ready. Because the event isn't attached to the dynamically generated <code>&lt;h1&gt;</code> tags it won't console log <code>"You have clicked an h1 tag! Good job!"</code>. The <code>.on()</code> method is a way around this.
</details><br>

### Debugging

<details>
  <summary>How do we debug our code? (hint: someone wrote it on the window)</summary>
  Console log everything.<br>
  If you ask me to debug your code and you don't even have your console open, I might just walk away after reminding you to open your console.
</details>
