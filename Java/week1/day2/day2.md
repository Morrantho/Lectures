# Week 1 Day 2

## Java

<img src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png" alt="Java Logo" width="200px">

### OOP

* Encapsulation
* Inheritance
* Members
* Methods
* Constructors
* Method Overloading

### The 4 Pillars Of OOP

* Encapsulation
* Inheritance
* Abstraction
* Polymorphism

### Encapsulation

Encapsulation is the act of storing data (member variables)
and actions (methods) together in such a way that prevents
the outside world from accessing the data directly
unless specified. This is also known as data privacy.

### Inheritance

Inheritance is the act of acquiring all properties (members and methods) of one class into another class in a hierarchal fashion. The class that is inherting this data is a child of  the class that it is inherting from (parent, superclass or base class).

### Members

Members are simply variables or properties that belong to a class, such as name, age or birth country.

### Methods

Methods are functions or actions that belong to a class such as
run(), jump(), swim(), accelerate(), decelerate(), fly().

### Contructors

Constructors are special functions that get executed when creating a new instance or object from a class. They are what create objects and let us pass information such as what values should be set for an object by default.

### Overloading

Method overloading is the act of having one method defined several times in a class, with each definition containing its own signature, argument types and amount of arguments. Overloading requires a different number of arguments or different data types passed to a former or new declaration of the same method it in order to be valid. This is a form of polymorphism, due to allowing a method to act in several different ways.

### Access Modifiers (Visibility)

* Public
* Private
* Protected

### Public

The public keyword states that any class, interface, method or attribute made public can be accessed from anywhere in our application.

### Private

The private keyword states that any member or method can only be accessed within the class that it belongs to. Classes and Interfaces cannot be made private. This allows for keeping data encapsulated, preventing the outside world from tampering with it. To access member variables that are made private, there needs to be public setter and getter methods for the specific member in its class declaration. 

### Protected

The protected keyword states that any member or method can only be accessed within the same package and subclasses of the class. Classes and Interfaces cannot be declared protected. This can help us use a parent class' method in a subclass, preventing unrelated classes from accessing or invoking it.

### Demo

Create an Animal superclass, followed by a child class that
inherits / extends the Animal class. Create members and methods, overloading some of them as well as making some private and public. Make a third class to show off how protected works.