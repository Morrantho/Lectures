# Week 1 Day 2

## JavaScript

<img src="https://cdn-images-1.medium.com/max/785/0*Co9Hk-VtMLfM08KH.png" alt="JavaScript Logo" width="200px">

### O.O.P. Overview:

* Object Constructors ( ES5 )
* .prototype
* .this
* Class Constructors ( ES6 )
* Inheritance
* ES6 getters & setters

### Function Constructors / ES5

* <details>
	<summary>How do we create an instance of an object from an object constructor using ES5?</summary>

	By using the new keyword, we can create new instances from object constructors. We can also choose not to do this, creating an object within a function and returning it at the end of the function:

	Using the new keyword:

	<code>
		function Rectangle(x,y,w,h){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

		var square = new Rectangle(8,8,32,32);

		console.log(square);
	</code>

	Without using the new keyword:

	<code>
		function Rectangle(x,y,w,h){
			let obj = {};
			obj.x = x;
			obj.y = y;
			obj.w = w;
			obj.h = h;

			return obj;
		}

		var square = Rectangle(16,16,32,32);
	
		console.log(square);
	</code>
</details>


### .prototype

* <details>
	<summary>What does the prototype keyword do and why should we care?</summary>

	The prototype keyword lets us add attributes / members or methods to a pre-existing class or object constructor. The benefit of using prototype as opposed to creating a method on an object is that it does not create the method for every object we create from an instance. It merely is a pointer that references where the function is stored, vastly reducing the amount of memory we consume.

	Non-Prototype Example:

	<code>
		function Rectangle(x,y,w,h){
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;

			// This function will be created for every instance of a Rectangle we create.

			this.setSize = function(newW,newH){
				this.w=newW;
				this.h=newH;
			}
		}
	</code>

	Prototype Example:

	<code>
		function Rectangle(x,y,w,h){
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
		}

		// Every Rectangle we create will merely point to this function rather than re-create it on the object.

		Rectangle.prototype.setSize = function(w,h){
			this.w=w;
			this.h=h;
		}
	</code>
</details>

### .this

* <details>
	<summary>What does the .this keyword do / mean?</summary>

	The this keyword refers to an instance of an object that is created from a function constructor or class that we can manipulate inside of the function constructor or class.

	<details>
		<summary>Ok, well why does it not work sometimes?</summary>

		You may have noticed at some point that when you try to refer to the this keyword, you get an unexpected output like "Window" or some other bizarre thing. This happens when the scope of this is changed.

		Consider that have a private method on our rectangle called setPosition() that gets called whenever we resize a rectangle, setting its x and y.
		
		Problem:

		<code>
			function Rectangle(x,y,w,h){
				this.x=x;
				this.y=y;
				this.w=w;
				this.h=h;

				var setPosition = function(x,y){
					// We've created a new scope because of this function, so what happens when we try to set these variables?

					this.x=x;
					this.y=y;
				}

				this.setSize = function(w,h){
					this.w=w;
					this.h=h;

					setPosition(w*2,h*2);
				}
			}
		</code>

		Solution:

		<code>
			function Rectangle(x,y,w,h){
				// Store a reference to this, so we can refer to it within our private method.
				let self = this;

				this.x=x;
				this.y=y;
				this.w=w;
				this.h=h;

				var setPosition(x,y){
					self.x=x;
					self.y=y;
				}

				this.setSize = function(w,h){
					this.w=w;
					this.h=h;

					setPosition(w*2,h*2);
				}
			}
		</code>
	</details>
</details>

### ES6 Classes / Constructors:

* <details>
	<summary>How do we create classes using ES6 and create and instance of one?</summary>

	By using the class keyword, we can create classes. By using the "constructor" keyword, we are emulating function constructors.

	<code>
		class Student{
			constructor(name,email,dojo,stacks){
				this.name   = name;
				this.email  = email;
				this.dojo   = dojo;
				this.stacks = stacks;
			}

			showStacks(){
				console.log(this.stacks);
			}
		}
	</code>

	This "Student" class is identical to:

	<code>
		function Student(name,email,dojo,stacks){
			let self = this;

			this.name=name;
			this.email=email;
			this.dojo=dojo;
			this.stacks=stacks;

			this.showStacks = function(){
				console.log(self.stacks);
			}
		}
	</code>
</details>

### Inheritance:

* <details>
	<summary>How do we inherit from other classes via ES6?</summary>

	We can use the extends keyword, followed by the class we want to extend:

	<code>
		class Animal{
			constructor(name,species,legs){
				this.name=name;
				this.species=species;
				this.legs=legs;
			}
		}

		class Dog extends Animal{
			constructor(name,species,legs,sound){
				super(name,species,legs);
				this.sound=sound;
			}

			bark(){
				console.log(this.name + " says: "+ this.sound);
			}
		}

		let oldYeller = new Dog("Old Yeller","Mut",4,"Ruff");
	</code>
</details>

### Setters and Getters:

<details>
	<summary>How do we keep our data private within a class, yet still have access to it via methods?</summary>

	Enter setters and getters!

	A good naming convention to prevent users from accessing things things they aren't supposed to is to prefix member's with an underscore. This still doesn't hide your data if someone prints an instance of your object though:

	<code>
		class Student{
			constructor(name,email){
				this._name=name;
				this._email=email;
			}

			set name(name){
				this._name=name;
			}

			get name(){
				return this._name;
			}

			set email(email){
				this._email=email;
			}

			get email(){
				return this._email;
			}
		}
	</code>

	Okay, well whats the point of creating getters and setters if someone can print an instance of my class still see the names of my underscore prefixed variables they shouldn't? Now they can just print those.

	Great question, heres an answer for true data privacy using ES5:

	<code>
		function Student(name,email){
			let name = name;
			let email = email;

			this.setName = function(newName){
				name = newName;
			}
			this.getName = function(){
				return name;
			}

			this.setEmail = function(newEmail){
				email = newEmail;
			}
			this.getEmail = function(){
				return email;
			}
		}
	</code>

	You'll notice this is in ES5. The reason is because there is no way to avoid initializing variables in the "constructor" function in ES6. There's still a way to make it work, but it will require more effort, defeating the purpose of ES6. With this solution, your member variables are private and you have methods for setting and getting each one of them.
</details>