# Week 1 Day 2

## Python

<img src="https://www.python.org/static/opengraph-icon-200x200.png" alt="Python" width="200px">

### Python Fundamentals

### How can we debug our Python code?

* Google your errors.
* print your variables.
* print your variable types.
* Comment sections of your code.
* Goto the line number and .py file the python interpreter tells us has an error.
* Google your errors.

### How can we declare a function?

```python
def add(num,num2):
    #Function Body.
    return num+num2;
```

### How are lists, tuples and dictionaries different?

<details>
    <summary>Lists</summary>

    Lists are like arrays in that they store
    data or multiple values as indices (numbers) as opposed to key / value pairs.

    <code>
        shoppingList = [];
        shoppingList.append("milk");
        shoppingList.append("bread");
        shoppingList.append("eggs");
    </code>
</details>


<details>
<summary>Dictionaries</summary>
Dictionaries use key / value pairs to map data or values, rather than indices (numbers).
<code>
    customer = {
        "firstName":"John",
        "lastName":"Smith",
        "city":"McLean"
        "state":"VA"
        "address":"123 Bottleneck Dr."
    };
</code>
</details>

<details>
<summary>Tuples</summary>
Tuples operate similarly to a list, except once data has been entered into it, it cannot be changed. This gives us a more secure data structure and may help reduce or prevent errors. 
<code>
    stacks = (
        "Python",
        "MEAN",
        "Java",
        "C#"
    )
</code>
</details>