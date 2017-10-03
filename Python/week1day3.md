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

Consider a class Shoe. Each shoe has its own distinctions about it, such as it's color, size, brand, style, lace color, patterns, etc. These would be known as the shoe's members or attributes. (Please call them members) We could also say that each shoe could perform an action when acted upon
such as wear, unwear, tie, untie, display. These would be known as the shoe's
methods, which are just functions belonging to only a shoe.

```python
    # Defining a class:

    class Shoe(object):
        def __init__(self,brand,model,color,size):
            self.brand  = brand
            self.model  = model
            self.color  = color
            self.size   = size
            self.isWorn = False
            self.tied   = False
            self.steps  = 0

        def wear(self):
            self.isWorn = True
            print "{} {} is now being worn".format(self.brand,self.model)

        def unwear(self):
            self.isWorn = False
            print "{} {} is no longer being worn".format(self.brand,self.model)

        def tie(self):
            self.tied = True
            print "{} {}'s laces are now tied, phew!".format(self.brand,self.model)

        def untie(self):
            self.tied = False
            print "{} {}'s laces have been untied! Watch your step!".format(self.brand,self.model)

        def run(self):
            self.steps += 1
            print "{} {}'s are somehow running! {} steps have been taken so far!".format(self.brand,self.model,self.steps)

        def display(self):
            print "Brand: {}\n Model:{}\n Color:{}\n Size:{}\n Is Being Worn: {}\n Laces Tied:{}".format(
                self.brand,
                self.model,
                self.color,
                self.size,
                self.isWorn,
                self.lacesTied
            )
```

More coming soon...