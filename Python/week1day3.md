# Week 1 Day 3

## Python

<img src="https://www.python.org/static/opengraph-icon-200x200.png" alt="Python" width="200px">

### Python OOP

* Use cases / Benefits
* Class Structure
* Attributes / Methods
* Chaining Methods
* Modules & Packages
* Super
* Varargs / KWargs

### What are the benefits of OOP?

* Code Organization.
* Code Reuse.
* Less repeating yourself.
* Sticking to a convention, which will prevent errors.
* Encapsulation / Privacy (Hiding data from users so they can tamper with it)
* Ease of use in large-scale applications

### OOP

OOP (Object Orientated Programming) is a paradigm in which we organize data into objects as opposed to running actions and logic. 
OOP allows us to create our own data types (classes), letting us specify
exactly what it is that we need for a certain situation. 

Consider a class Shoe. Each shoe has its own distinctions about it, such as it's color, size, brand, style, lace color, patterns, etc. These would be known as the shoe's members or attributes. We could also say that each shoe could perform an action when acted upon
such as wear, unwear, tie, untie, display. These would be known as the shoe's
methods, which are just functions belonging to only a shoe.

### Defining a class

```python
    # Defining a class:
    class Shoe(object):
        # Constructor:
        def __init__(self,brand,model,color,size):
            # Members / Attributes
            self.brand  = brand
            self.model  = model
            self.color  = color
            self.size   = size
            self.tied   = False
            self.steps  = 0

        # Methods:
        def tie(self):
            self.tied = True
            print "{} {}'s laces are now tied, phew!".format(self.brand,self.model)

        def untie(self):
            self.tied = False
            print "{} {}'s laces have been untied! Watch your step!".format(self.brand,self.model)

        def run(self):
            if not self.tied:
                print "{} {}'s must be tied in order to run!".format(self.brand,self.model)
                return

            self.steps += 1
            print "{} {}'s are somehow running! {} steps have been taken so far!".format(self.brand,self.model,self.steps)

            return self

        def display(self):
            print "Brand: {}\n Model:{}\n Color:{}\n Size:{}\nLaces Tied:{}".format(
                self.brand,
                self.model,
                self.color,
                self.size,
                self.tied
            )
```

### Instantiating an object from a class:

```python
Jordan = Shoe(
    "Jordan",
    "Air",
    "Blue",
    11
)
```

### Calling our methods on our Shoe Object:

```python
Jordan.display();
Jordan.run();
Jordan.tie();
```

### Self / Chaining Methods:

Self in python refers to the particular object that you are creating or will eventually create.
This lets us refer to the object within our class, so we can access its INDIVIDUAL member variables
and methods. Without this, we would have no frame of reference to set or update the object's variables, or call it's methods.

We can chain methods together in the case that we need to execute something multiple times.
To do this, we must return self so that we may reference the object that we are calling the method
on. 

```python
Jordan.run().run().run();
```

### Q!A

#### What happens when you try to chain methods without returning self?

#### What happens when you return self in your class' constructor?

### Modules & Packages

Any <code>.py</code> file can be a python module. Simply use import followed by your module name
to import it into your project. This copies the contents the your module into the file you imported
it into. You can also import certain parts of a module, such as one function or class in particular. This prevents us from importing a large portion of code that we may never need or use.

We can also create packages, which are just multiple modules or <code>.py</code> files within a folder. We must also provide a __init__.py inside our package folder to let python know it's a valid package. It can be a blank file, or you can override the __all__
magic method to export specific files within your package.

#### Importing a module

```python
import random

print random.randint(0,10);
```

#### Importing only our Shoe class from our module

```python
from week1day3 import Shoe

myShoe = Shoe(
    "Timberland",
    "Classic",
    "Brown",
    11
)
```

#### Package structure / Importing from a package

myPackage
    __init__.py
    myFirstModule.py
    mySecondModule.py
    myThirdModule.py

```python
import myPackage.myFirstModule
# Or:
# from myPackage import myFirstModule
# Both of these do the same thing.

print myFirstModule.sayHello()
```

### Q!A:

#### What happens when you try to import a module that doesnt exist?

#### What happens when you try to import a method or class that doesnt exist within a module?

### Inheritance / Super

Inheritance is the process of obtaining all member variables and methods from a class. We can alter these members or methods or even create new ones. This prevents us from having to repeat ourselves. There is no limit to how many subclasses you can have.

Super lets us access a parent class' ORIGINAL members or methods within a child of the parent class. This prevents us from having to rewrite this method in our child class if we just want to set some default values. We could also overwrite that method to give our sub-class it own unique twist of the original implementation.

```python
class Dog(object):
    def __init__(self,name,breed,sound):
        self.name  = name
        self.breed = breed
        self.sound = sound

    def bark(self):
        print "{} says {}".format(self.name,self.sound)

# Notice we no longer use object as the first argument in our class declaration.
# We now substitute "object" with the parent class we intend to inherit from "Dog".
# This inherits all properties, member variables and methods from our Dog class.
class Chihuahua(Dog):
    def __init__(self,name,breed,sound):
        # Calling Dog's Constructor, passing it the name, breed and sound
        # of our Chihuahua. 
        super(Chihuahua,self).__init__(name,breed,sound);

    # Overriding Dog's bark method
    def bark(self):
        print self.name+" says "+self.sound.lower();

class Mastiff(Dog):
    def __init__(self,name,breed,sound):
        super(Mastiff,self).__init__(name,breed,sound);

    def bark(self):
        print self.name+" says "+self.sound.upper();
```

### Q!A:

#### What happens when you dont pass arguments to a parent class' method that requires arguments?

### Varargs / KWargs

Varargs are a variable amount of arguments that we can pass to a function as a single argument. This can keep our function declaration shorter. We can also pass in a few arguments and then allow for variable arguments after.

KWargs are also a variable amount of arguments that we can specify as key / value pairs like a dictionary. This way we can have variable arguments, but also have the benefit of being able to expect certain keys within a function.

```python
# The * symbol before our parameter's name indicates that it should allow for variable arguments
def myVarArgs(*args):
    # Loop through our arguments and print each of their values.
    for i in args:
        print i

# Two ** symbols indicate we want to accept Multiple named arguments or KWargs.
def myKwargs(**args):
    for i in args:
        if i == "firstName":
            print "First Name: "+args[i]
        elif i == "lastName":
            print "Last Name: "+args[i]        
        elif i == "address":
            print "Address: "+args[i]

myVarArgs(20,30,40)

myKwargs(
    firstName="John",
    lastName="Smith",
    address="123 Dojo Ave."
)
```