# Week 1 - Day 3 - Morning

## JavaScript

<img src="https://cdn-images-1.medium.com/max/785/0*Co9Hk-VtMLfM08KH.png" alt="JavaScript Logo" width="200px">

## Advanced JavaScript:

* Callbacks
* Async

### Anonymous / Arrow / Immediate Functions:

* <details>
	<summary>How do you write an anonymous function?</summary>

	There are a few ways:

	Arrow Functions:

	```javascript
		()=>{
			console.log("My Arrow Function!");
		}();
	```

	Anonymous Functions:

	```javascript
		function(){
			console.log("Im a function without a name!");
		}();
	```

	Immediate Functions:

	```javascript
		(function(){
			console.log("Im a function without a name!, except any variables within definitions are only accessible within my scope.");
		})();
	```

</details>

### Callbacks / Async:

* <details>
	<summary>What is a callback?</summary>

	A callback is a function that is passed to another function that gets called at some point in the parent function.
</details>

* <details>
	<summary>What happens if you pass an anonymous function into another function?</summary>

	Its passed like a normal function, which you probably intend to call at some point. You can then decide to pass data back to it, so the parent function has access to this data.

	```javascript
		function getGroceries(){
			let groceries = ["milk", "bread", "eggs"];

			console.log(groceries);

			callFriend("will", (data)=>{
				for (let i = 0; i < data.length; i++){
					groceries.push(data[i]);
				}

				console.log(groceries);
			});

			console.log("I need groceries");
		}

		function callFriend(phone, cb){
			let friends = {
				"will":["bacon", "tomato", "lettuce"],
				"rob":["apple pie", "vanilla ice cream", "cake"]
			}

			let buddy = friends[phone];

			window.setTimeout(()=>{
				cb(buddy);
			},2000);
		}

		getGroceries()

	```
</details>

* <details>
	<summary>How would you call that function?</summary>

	You would call this function in the function that is being invoked in the parent.

	This is what's calling the callback, passing it data back to the parent / caller:

	```javascript
		cb(buddy);
	```
</details>

### Events:

* <details>
	<summary>How do implement events in JavaScript?</summary>


		```javascript
			$("someElement").click(function(){
				// This code gets executed when your element is clicked, but its not run just because we defined it here. Other things can run, while we wait for this event to trigger.

				console.log("You clicked me!");
			})
		```
</details>
