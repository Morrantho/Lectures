# Day 3

## React

<img src="https://eternitech.com/wp-content/uploads/2016/12/ReactJS.png" alt="Java Logo" width="200px">

### POST / GET | Promises | Hooks

* Hooks
* Axios
* Promises
* Get Requests
* Post Requests

### Hooks:

The term hook when used in programming refers to a predefined event that triggers at some point. Its called a hook because we can latch onto this event and run custom code we've defined when this event occurs. Just like in jQuery if you we're to say:

<code>
(".someDiv").click(function(){
	// Your custom code that shold run when "someDiv" is clicked.
});
</code>

### Axios:

Axios is an HTTP library that lets us make post and get requests asynchronously. It uses the concept of promises to handle whether we did or did not recieve data. This is a more efficient way to handle errors as opposed to just a callback, like you would use in a jQuery <code>$.get()</code>

### Promises:

Promises let us define what what happens with data recieved or failed to recieve from a request. They are similar to callbacks except they have two methods / functions we must define: <code>.then()</code> and <code>.catch()</code>. the then() method is where we define what should happen when we successfully recieve data. The .catch() method is where we define what happens when we fail to recieve data.

### GET Requests:

Here's an example of how we can define a get request inside of a component when we click a button:

<code>
	class MyComponent extends React.Component{
		myClick(){

			axios.get( "pokeapi.co/pokemon/2" )
			.then(
				function(data){
					// We've successfully recieved data
					console.log(data);
				}
			)
			.catch(
				function(){
					// We've failed to retrieve data. Do something about it here.

				}
			);
		}

		render(){
			<div>
				<button onClick={ ()=>{ this.myClick(); } }>Get Some Data!</button>
			</div>
		}
	} 

</code>