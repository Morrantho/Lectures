# Week 2 Day 1

## JavaScript
<img src="https://upload.wikimedia.org/wikipedia/commons/6/6a/JavaScript-logo.png" alt="JavaScript" width="250px">

### Introductory questions

1. <details> 
	<summary>Where does javascript run?</summary>
	In our browsers... 
</details>

2. <details>
	<summary>If you could provide js code directly to a cpu would it run?</summary>
	<p>No... we must first convert it into machine code / bytecode before it runs, this is done by the javascript engine</p>
	<p><strong>Examples of JS engines</strong></p>
	<ul>
		<li>JavaScriptCore</li>
		<li>V8</li>
		<li>Chakra</li>
		<li>Spider Monkey</li>
		<li>Squirrel Fish</li>
	</ul>
	<br><p>They are written in C/C++ and have the goal of translating our js code into something a cpu can actually run.<br>In other words: JavaScript must be parsed before it can be run.</p>
</details>

### How do we declare variables?
```javascript
function hasParameter(w){
	console.log(w);
}
hasParameter(6);

var x = 3;

console.log(x);

function test(){
	var y = 4;
}

console.log(y);

if(false){
	var z = 5;
}

console.log(z);

for(var i = 0; i < 5; i++){
}

console.log(i);

```

3. Can we access w, x, y, z and/or i?
<details> 
	<summary>w</summary>
	Yes. <code>console.log(w);</code> will print out 6 when the function hasParameter is run passing it the argument 6.
</details>
<details> 
	<summary>x</summary>
	Yes. <code>console.log(x);</code> will print out 3.
</details>
<details> 
	<summary>y</summary>
	No. <code>console.log(y);</code> will throw a <code>ReferenceError: y is not defined</code>
</details>
<details> 
	<summary>z</summary>
	Yes. <code>console.log(z);</code> will print out <code>undefined</code>
</details>
<details> 
	<summary>i</summary>
	Yes. <code>console.log(i);</code> will print out 5. 
</details>
<details> 
	<summary>Why?</summary>
	Variables in JavaScript are "function scoped", we cannot access a variable declared inside a function from outside of that function. We can access variables that are inside of a conditional (if) or a loop (for).
</details>

### Loops

4. <details>
	<summary>What types are there?</summary> 
	<ul>
		<li>for</li>
		<li>while</li>
		<li>for/in</li>
		<li>for/of</li>
		<li>do/while</li>
		<li>.forEach() // method of array</li>
	</ul>
	<br><p>Don't worry about those last four, we'll talk about them in the future</p>
</details>

#### How does a for loop work?	

```javascript
for (var i = 0; i < 5; i++){	
}
```
<details>
	<summary>var i = 0</summary>
	declares a variable i and sets it to some number
</details>

<details>
	<summary>i < 5</summary>
	continues running as long as this condition
</details>

<details>
	<summary>i++</summary>
	on each iteration do this <br><code>i++ is shorthand for i = i + 1</code>
</details>

<details>
	<summary>T-Diagram</summary>
	<table>
		<br><tr><th>Iteration</th><th>var i</th><th>i < 5</th></tr>
		<tr><td>1</td><td>0</td><td>true</td></tr>
		<tr><td>2</td><td>1</td><td>true</td></tr>
		<tr><td>3</td><td>2</td><td>true</td></tr>
		<tr><td>4</td><td>3</td><td>true</td></tr>
		<tr><td>5</td><td>4</td><td>true</td></tr>
		<tr><td>6</td><td>5</td><td>false</td></tr>
	</table>
</details>
		
### How do functions work?

```javascript
function test(){
	// do something
}

var test2 = function(){
	// do something else
}
```

### What does return do?

```javascript
function test(){
	return "this";
	return "that";
}
```

5. <details>
	<summary>What does this return?</summary>
	<br>It only returns <code>"this"</code>, return ends the function. 
</details>

### return vs console.log() vs alert()

```javascript
function returnSomething(){
	return "Something";
}

function returnNothing(){
}

console.log(returnSomething());
console.log(returnNothing());

// What does alert do?

alert("hello");
```	

6. What do these console log and why?

<details>
	<summary><code>console.log(returnSomething());</code></summary>
	<code>"Something"</code>Console log prints the returned string "Something"
</details>

<details>
	<summary><code>console.log(returnNothing());</code></summary>
	<code>undefined</code>If there is no return statement a function in javascript still return something, <code>undefined</code> 
</details>
