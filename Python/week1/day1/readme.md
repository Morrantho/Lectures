# Week 1 Day 1

## Python

<img src="https://www.python.org/static/opengraph-icon-200x200.png" alt="Python" width="200px">

### Course Overview:

## Week 1:

* Fundamentals: Day 1
* Fundamentals: Day 2
* OOP: Day 3
* Flask - Routing / Views / Templates / Static: Day 4
* Flask - Session / Form Validation / Hidden Inputs: Day 5

## Week 2:

* MySQL - Workbench / ERD's / Relationships / Datatypes: Day 1
* MySQL - Queries: Day 2
* Flask + MySQL: Day 3
* Django Intro - Views / Templates / Session / Forms: Day 4
* Django - ORM / Models / SQLite: Day 5

## Week 3:

* Django - Relationships / Shell: Day 1 
* Django - Validations / Routes / Forms: Day 2
* Catch up: Day 3
* Catch up: Day 4
* BELT EXAM: Day 5 - Mandatory, else no retakes.

## Week 4 - Project Week:

* Retake 1 + Personal Projects: Day 1 - Monday
* Catch up + Personal Projects: Day 2
* Retake 2 + Personal Projects: Day 3 - Wednesday
* Catch up + Personal Projects: Day 4
* Retake 3 + Personal Projects / Graduation: Day 5 - Friday

### History

* Created by Guido Van Rossum in 1991, Python is a mature language
* Popular with lots of libraries like: NumPy, SciPy, BeautifulSoup, Scrapy, Twisted
* Used for all sorts of things, not just web design
* Easy to learn with a readable syntax

### First Application:

Create a file, name it and save it as a <code>.py</code> extension. You can execute your program from a terminal by running: <code>python yourFile.py</code>

```python
    print("Hello World!")
```

### Variables:

Variables let us store data in a "named container", so we can re-use or redefine what it contains later. We can then act on this data and perform tasks or calculations.

```python
    yourName = "not Tony"; # String
    print("Hello, my name is"+yourName)
    yourName = "Tony"
```

### Comments:

Comments aren't compiled by the Python compiler. They merely exist to let other developers or yourself know what your code does.

```python
    # I'm a comment and I'm not even considered by the compiler, how sad :/
```

### Lists:

Lists are the arrays of Python. They let us store multiple values in one place / variable, using numerical indices to reference each item.

```python
    groceries = [
        "Milk",
        "Bread",
        "Eggs"
    ]

    print(groceries[1]) # Retrieves the 2nd item "bread" in the list and prints it.
```

### Conditionals:

Conditionals let us compare variables with one another and run a portion of code when something does or doesn't happen.

```python
    a = 10
    b = 20

    if a > b:
        print("Yay!")
    elif b > a:
        print("Nay!")
    else:
        print("This should never have happened! Oh no!")
```

### Loops:

Loops allow us to repeat portions of our code, so that we don't have to re-write it for as many times as we need it to run.

Counting to 10 and printing each number:

```python
    a = 10

    for i in range(0,a):
        print(i)
```

Iterating a list's items and printing each one:

```python
    groceries = [
        "Milk",
        "Bread",
        "Eggs"
    ]

    for grocery in groceries:
        print(grocery)
```

### Dictionaries:

Dictionaries store key / value pairs as opposed to numerical indices like arrays / lists.

```python
    instructor = {
        "name":"Tony",
        "stack":"Python",
        "location":"Tyson's Corner"
    }

    # Redefines the "location" key, reassigning it's value to "Chicago".

    instructor["location"] = "Chicago"

    # Printing values from the dictionary by referring to each "key" associated with the value we want to retrieve.

    print(instructor["name"]+" is in "+instructor["location"]+" and you are learning "+instructor["stack"]+" with him. (Hes probably awful at coding.)")
```

### Tuples:

Tuples are immutable data structures in Python. This means that once you've defined the contents it stores, the content cannot be changed, only retrieved. They can store multiple values like arrays / lists. Retrieving contents from a tuple is the same as with an array.

```python
    myGroceriesThatWontChange = (
        "Apples",
        "Bananas",
        "Oranges"
    )

    # We can't change these values, this will break when trying to replace "Bananas" with "NotBananas"!

    myGroceriesThatWontChange[1] = "NotBananas!"
```

### Group Whiteboard:

* Define and name two variables that store two different numbers.

* Write a conditional to determine the larger of the two and output the word "Hello" if the first variable is larger, otherwise print the word "World"

* Write a for loop that starts at the smaller number you created and ends at the larger number you created. Print each number for each iteration of the loop.

* Create a list of strings that contains the names of your group members. Loop this list and print each of your names. <code>.remove()</code> one of your group members from the list.

* Create a dictionary with the following keys pertaining to group member you rudely removed from your list: "name","favoriteMovie","favoriteGenre" and "favoriteLanguage".

* Create a function "loop" that iterates your dictionary, printing each key and value.

* Create a tuple that contains strings of all of your group members favorite sports teams. Iterate your tuple, printing each value. Attempt to re-assign your entire tuple to a different data type. What happens?