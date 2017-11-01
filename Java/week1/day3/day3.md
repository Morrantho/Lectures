# Week 1 Day 3

## Java

<img src="https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png" alt="Java Logo" width="200px">

### Advanced OOP

* Polymorphism
* Abstraction
* Interfaces
* Abstract Classes

### Polymorphism

Polymorphism states that objects can be treated like their super or parent class. We can instantiate an instance of a child class and store it in a variable of its parent type. Polymorphism only works when travelling up the inheritance chain, not down.The object will be treated like its parent unless we cast it to the desired child class.

### Abstraction

Abstraction is the act of hiding the details about how things work from a user and only providing them with the functionality. This yields the end-user with a functioning object that performs operations without informing them about how it performs those operations. We can achieve this sort've abstraction by using interfaces and abstract classes.

* Its like when your boss asks you to do something, he/she doesnt care HOW you completed the task, they only care that the job is complete and the product does what its supposed to.

* We probably dont care about how our cell phones call people, we just want to call our friends!

### Interfaces

Interfaces define what actions / methods a class should have. They contain blank method definitions only (abstract methods). We're required to make all methods from the interface in the class we're creating. Its up to us to make our own versions of these methods in our class. Interfaces cannot be instantiated, because there are voids in their structure that need to be filled. It wouldnt make sense to be able to create something that is missing details would it? Can you bake a cake without ingredients? Have fun with it.

As you may have noticed, you cannot extend a class more than once in Java. However, a class can implement as many interfaces as needed. Interfaces can help us avoid the issue of multiple inheritance, by allowing us to specifically indicate which classes should implement or require certain methods or actions.

### Abstract Classes

Abstract classes are just classes with some or no blank / abstract methods. We typically use them as a base / parent class and any class that inherits / extends it must implement any of its abstract methods. Abstract classes also cannot be instantiated, due to the fact that they may contain abstract methods. Abstract classes can contain their own attributes and methods as well as abstract methods, making them a very powerful way to implement many features in one class.

### POJOS (Plain Old Java Objects)
POJO's are instantiations of Java Objects. Up to this point, anytime you used the 'new' keyword, followed by the name of the class your making an object from, you create a POJO.


### Java Beans (Nearly A POJO, with a few changes)
There are 3 minor differences between a POJO and Java Bean.
Most of these you've already been doing.

* Members must be private and require setter and getter methods for each.
* A blank constructor. (You can have overloaded contructor's too.)
* Must implement serializable interface (Until we get to Spring).

### Demo
Make CanFly and CanRun interfaces. Build on our Bird class, do stuff, then then turn Animal base class into an abstract.