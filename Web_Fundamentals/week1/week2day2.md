# Week 2 Day 2
## jQuery
<img src="https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/JQuery_logo.svg/1280px-JQuery_logo.svg.png" alt="jQuery" width="500px">

### JavaScript libraries
<details> 
	<summary>What is a JavaScript library?</summary>
	A JavaScript library is a library of pre-written JavaScript which allows for easier development of JavaScript-based applications, especially for AJAX and other web-centric technologies. -from wikipedia<br>
	Basically a bunch of handy JavaScript methods that someone wrote for us.
</details><br>

<details>
	<summary>Why are they useful?</summary>
	<ul>
		<li>Prevents us writing a lot of repetitious code. <strong>DRY</strong></li>
		<li>Avoid reinventing the wheel</li>
		<li>The code is already optimized</li>
		<li>Works well on many different browsers: Chrome, Firefox, Safari, etc.</li>
		<li></li>
	</ul>
</details>

### The DOM?

<details>
	<summary>What is the <strong>DOM</strong>?</summary>
	The <strong>D</strong>ocument <strong>O</strong>bject <strong>M</strong>odel<br>
	The programming interface for HTML or XML that represents the page so other programs can change the document's content, style, and structure.
	It is a tree of elements all branching off of its root <code>html</code> element.
</details>

### How do I use jQuery?

1. First we must link to it in our html

```html
<!DOCTYPE html>
<html>
<head>
    <title>Examle</title>
    <meta charset="UTF-8">
    <script type="text/javascript" src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
    <!-- or we can download the jquery-3.1.1.min.js script and link to it in our project's /js folder -->
    <script type="text/javascript" src='js/jquery-3.1.1.min.js'></script>
</head>
<!-- and so on -->
```

2. Then we can access jQuery in a script, either use embedded script tags or link to a script.

```javascript
console.log($);
```
jQuery only exposes one variable to us, ```$```. Through this one variable we have access to a function that we can use to do many different things.

### $(document).ready()

```javascript
// inside script.js
$(document).ready(function(){
    console.log("jQuery is ready");
});
```
<details>
	<summary>What does this do? Is it necessary?</summary>
	We use jQuery to wait for the html element <code>document</code> to indicate it is ready (has loaded all of the html).
	When it indicates it is ready it runs an anonymous function that console logs "jQuery is ready".<br>
	It isn't entirely necessary, but it is a good habit to know all the html has loaded before you attempt to use jQuery to manipulate the DOM.
</details>

### Selectors and Events
You can select based on html tags, ids, classes, and/or any combination of the three.
```javascript
$('p').append(" <i>hello</i>");
$("#some_id").text("New text");
$(".some_class").css("background-color", "red");
```
Events, wait for something to happen...
```javascript
$(button).click(function(){
    console.log("the button has been clicked");
});

$(".logo").hover(
    function(){
        $(this).css("width", "200px";
    },
    function(){
        $(this).css("width", "100px";
    }
});
```
and then trigger an anonymous function that we call a callback function.

<details>
	<summary>What are some events you can think of?</summary>
	<ul>
		<li>.click()</li>
		<li>.submit()</li>
		<li>.hover()</li>
		<li>.focus()</li>
		<li>.change()</li>
		<li>and more...</li>
	</ul>
</details>

### getters and setters

```javascript
$("#name").val("Shelly");

$("#registerButton").click(function(){
    var name = $("#name").val();
    console.log(`the name is ${name}`);
});
```
We can use a method like ```.val()``` to both set a value or access the value.
