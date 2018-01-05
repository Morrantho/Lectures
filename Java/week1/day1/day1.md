# Week 1 Day 1

## Java

<img src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png" alt="Python" width="200px">

### Course Overview

* Fundamentals
* OOP
* On The Web
* Spring

### Useful Plugins:

#### VSCode:

* Java Extension Pack - Microsoft
* Language Support for Java - Redhat
* Java Imports Snippets - Taiwo Kareem
* Spring Boot Support - ecmel

#### Sublime:

* EJS
* JavaIME
* JavaImports
* Javatar

### Java Intro

* Created By James Gosling in 1995 and inherited by Oracle Corporation.
* Strong and Static Typing
* Compiled language
* Object Oriented
* Widely Used
* Ecosystem
* Java's API

### Compiled vs Interpreted:

### Compiled - Pros:
* Speed
* Type Checking
* Verbose Errors

### Compiled - Cons:
* Compile Time
* Strict Syntax

### Interpreted - Pros:
* Portability
* Easy to read

### Interpreted - Cons:
* Slow performance

### A Java Program's LifeCycle

<img src="http://www.eeng.dcu.ie/~ee553/ee402notes/html/figures/JavaLifeCycle.gif" alt="req-res">

.java ->
javac ->
.class ->
JVM ->
class loader ->
library loader ->
bytecode verifier ->
interpreter

### First Application
```java
	public class Hello{
		public static void main(String[] args){
			System.out.println("Hello, World!");
		}
	}
```

### Classes

Every <code>.java</code> file MUST be a class.
Each java application MUST also have one <code>public static void main(String[] args)</code> method.
Classes allow us to create blueprints for objects
that we can instantiate and perform actions on. This allows us to create multiple instances of objects, each with their own actions and attributes. Without classes, we would need to re-write massive portions of our code each time we wanted to perform such tasks.

### Main

As stated above, every java program requires a main method.
This is the beginning of every java program and the first thing that gets executed. You only need one main method per java program.

### Data Types

Data types tell us what a piece of data can and does contain. They exist not only to organize what data we're storing in our variables, but they allocate a specific amount of space in RAM, as opposed to non statically-typed languages. This specific allocation of RAM speeds up runtime of our program.

### Primitive Data Types

* int     - whole numbers. Range: -2147483648-2147483647
* long    - larger integers. Range: 2^63, or around 2 quintillion.
* boolean - true and false values.
* double  - Much bigger decimals. More precise than floats
* float   - decimals.
* char    - a single character.

### Object Data Types

* Integer    - Same as int, except has built in methods since its a class.
* String     - multiple characters.
* BigInteger - Any size integer
* ArrayList  - Resizable array
* HashMap    - Key Value pairs

### Primitive vs Object Data Types

Primitive data types are types built directly into the language itself. There are no methods you can call on them or other attributes that can exist on them.

Object data types are types that are classes themselves. Each primitive data type also has an Object data type. For example, we have int, but we also have Integer. The capital Integer type lets us still create a number, but it also has methods built into its class that allow for manipulating Integers, such as converting a String to an Integer (Integer.parseInt()).

### Static

Static lets us use a variable or method on a class
without having to instantiate an object out of it.
We can access the variable or method directly from the class. This can
save us time if we simply just want to store some data or perform a task without having to create an object out of a class.

```java
	public class Example{
		static int myNumber = 123; // Simply set a number on the class rather than an object instance.
		int myOtherNumber = 456; // This will error, since java expects this variable to be set on an instance of an object or by using the 'this' keyword.

		public static void main(String[] args){

		}
	}

	public class AnotherExample{
		public AnotherExample(){
			// Accessing our static variable 'myNumber' from class 'Example'
			System.out.println(Example.myNumber);

			// This will not work, because we are trying to access a variable that only exists on instances of our Example class.
			System.out.println(Example.myOtherNumber);
		}
	}
```

### Void

Void means we dont want anything returned or given back to us after the execution of a method. It will simply perform a task and stop as opposed to giving us the result back from where the method was called.

```java
	public class Example{
		public void myMethod(){
			System.out.println("This is my method!");
		}

		public static void main(String[] args){
			System.out.println(myMethod()); // We will get nothing in return once we print the result of calling 'myMethod' because we've stated we dont want anything back in 'myMethod's signature.
		}
	}
```

### Arrays

Arrays in java are declared just like a variable except you surround the data type with square brackets. Arrays have a fixed size in java. Once you've initialized an array, you cannot change the amount of elements that it can store. You can only change the values within the array.

```java
	int[] myNumbers = {5,10,15,20};

	for(int i=0; i < myNumbers.length(); i++){
		System.out.println( myNumbers[i] );
	}

	myNumbers[2] = "Hello"; // Error, we can only store int's in our int array. 
	myNumbers[3] = 25;
	myNumbers[4] = 567; // Errors, since we've already declared the array with 4 numbers, a 5th index doesnt exist. Once an array is declared, you cannot add or remove indices, only change their values. This is where arraylists will come into play.
```

### ArrayLists

Arraylists are resizable arrays. We can add and remove elements as we choose as opposed to having a fixed size like standard arrays have. They are an object data type, so they have built in methods we can use to manipulate data.

```java
	import java.util.ArrayList; // lets us use arraylists
	
	ArrayList<String> shoppingList = new ArrayList<String>();
	// We add elements using the add() method on the arraylist.
	shoppingList.add("Milk");
	shoppingList.add("Bread");
	shoppingList.add("Eggs");
	shoppingList.add("Beef");
	shoppingList.add("Chicken");

	//  ArrayLists dont have a length, but rather a size() method. This is because we can resize our arraylist by adding or removing elements. We can use this to iterate our arraylist.

	for(int i=0; i < shoppingList.size(); i++){
		// Also notice that we cannot treat arraylists like an array to access its values. We must call the get() method on our list followed by the index we wish to access to retrieve its value. 
		System.out.println( shoppingList.get(i) );
	}

	// We can also use the enhanced for loop, which lets us access the values without the need to refer to an index. This is useful in the case that we dont care about the index and just want the value. If you do need the index however, use a regular for loop like we've done above.
	for(String item: shoppingList){
		System.out.println(item);
	}
```