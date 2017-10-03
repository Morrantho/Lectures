# Week 1 Day 2

## Python

<img src="https://www.python.org/static/opengraph-icon-200x200.png" alt="Python" width="200px">

### Python Fundamentals

* Debugging
* Functions
* Data Types

### How can we debug our Python code?

* Google your errors.
* Print your variables.
* Print your variable types.
* Comment sections of your code until there is no longer an error.
* Goto the line number and <code>.py</code> file the interpreter tells us to.
* Google your errors.

### Functions

Functions let us run a certain portion of our code any number of
times throughout the lifetime of our application. This allows us
to reuse code, reducing clutter. We can execute this function (call) by referring to it by its name and invoking it with parenthesis.

Functions can take many or zero arguments, which let us act upon or manipulate the data we've passed into it. They can also give us
back a result (return), in which we can use elsewhere in our application.

```python
# Defining a function:
def add(num,num2):
    # Function Body.
    return num+num2; # Returning / giving us back a value.

# Calling a function:
print add(5,10);

# Output:
# 15:
```

### How are lists, tuples and dictionaries different?

### Lists

Lists are like arrays in that they store
data or multiple values as indices (numbers) as opposed to key / value pairs (dictionaries).

```python
shoppingList = [
    "milk",
    "bread",
    "eggs"
];
```

### Q!A:

#### What happens when you try to access a non-existent index?

#### What happens when you try to access a key within a list?

### Dictionaries

Dictionaries use key / value pairs to map data or values, rather than indices (numbers).

```python
customer = {
    "firstName":"John",
    "lastName":"Smith",
    "city":"McLean"
    "state":"VA"
    "address":"123 Bottleneck Dr."
};
```

### Q!A:

#### What happens when you try to access a numerical index in a dictionary?

#### What happens when you try to access a key that doesnt exist?

#### How do we insert a new key into a dictionary after its already been defined?

### Tuples

Tuples operate similarly to a list in that they are numerically indexed, except once data has been entered into it, it cannot be changed (immutable). This gives us a more secure data structure to protect sensitive information and may help reduce or prevent errors. 

```python
stacks = (
    "Python",
    "MEAN",
    "Java",
    "C#"
)
```

#### What happens when you try to change the type of a tuple?

#### What happens when you try to change a value in a tuple?

### Which one should I use? A list, dictionary or tuple?

If you simply want to store data, but dont
necessarily care about what that data should be named,
a list is an ideal candidate.

If you are handling sensitive information such as a user's name,
email or password, consider a tuple to prevent this information from getting into the wrong hands or being replaced by something else.

If you want to categorize data by naming individual fields, consider a dictionary.