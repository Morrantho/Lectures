// Variables:

// Numbers:
var myPosition   = 2;
var yourPosition = 3;
var chance       = 0;

// Strings:
var greeting = "Hello!";
var response = "How's it going?";

// Booleans:
var hasGreeted = false;

// Printing:
// console.log("Hello World ",hasGreeted);

// Conditionals:

if(myPosition == yourPosition){
	console.log("We're in the same spot!");
}else{
	console.log("We're not in the same spot!");		
}

// Loops:

// For Loop:

// for(var i = 0;i < yourPosition; i++){
// 	console.log("Taking a step forward...");
// 	myPosition++;
// }

// While loop
// while( !hasGreeted ){
// 	if( myPosition != yourPosition ){
// 		console.log("Taking a step backward...");
// 		myPosition--;
// 	}else{
// 		console.log("Me:"+greeting);
// 		console.log("You:"+response);
// 		console.log("Me: Should I go grocery shopping?");
		
// 		hasGreeted = true;
		
// 		// Generate a number between 1-10
// 		chance = 1+Math.random()*10;
// 		// Round it down.
// 		chance = Math.floor(chance);

// 		// If its 1-5, call shop().
// 		if(chance >= 1 && chance <= 5){
// 			console.log("You: Yes!");
// 			console.log("Me: Okay!");
// 			console.log("Me: Here's what I bought:");
			
// 			let groceries = [
// 				"Milk",
// 				"Bread",
// 				"Eggs"
// 			];

// 			let items = shop(groceries);

// 			for(let i=0; i < items.length; i++){
// 				console.log(items[i]);
// 			}
// 		}else{
// 			console.log("You: No!");
// 			console.log("Me: Alright, I can go tomorrow.");
// 		}
// 	}
// }

// Arrays & Functions

// function shop(groceryList){
// 	var cart = [];

// 	var isFull = cart.length == groceryList.length;
// 	var count = 0;

// 	while( !isFull  ){
// 		var item = groceryList[count];
// 		cart.push(item);
// 		count++;
// 		isFull = cart.length == groceryList.length;
// 	}

// 	return cart;
// }