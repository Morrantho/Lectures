# Week 1 Day 4

## Python

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Flask_logo.svg/1200px-Flask_logo.svg.png" alt="Python" width="200px">

### Flask

* Virtual Environments
* Installation
* Routing
* Views
* Templates
* Static

<details>
<summary><strong>What is flask?</strong></summary>    
Flask is a light-weight Web-Framework that enables us to easily create web applications. Being light-weight, Flask
uses few system resources and doesnt overwhelm us with a plethora of features that we may not necessarily need that other frameworks might contain.
</details>
<br>
<details>
<summary><strong>Why should we use a framework?</strong></summary>
A framework allows us to have a core foundation or functionality that we can alter to meet our individual needs. This gives us great flexibility, allowing us to quickly build an application, rather than having to build this core functionality from scratch.
</details>
<br>
<details>
<summary><strong>What are routes and how do we use them in Flask?</strong></summary>
Routing is the process of instructing our server to perform a given task based on the URL a client has visited. Generally, most frameworks will use an annotation or decorator to indicate what route you intend to go. Underneath this annotation, we must specify a function or callback, which is the logic that gets run once a client visits our route.
</details>

### Virtual Environments

<details>
<summary><strong>What is a virtual environment and why should we use them?</strong></summary>

A Virtual Environment is a way for us to handle having multiple versions of the same module, script or framework installed on our computer. It also lets us maintain and use only dependencies that we need. We can for example have many projects that all use different versions of Flask.

Without a virtual environment, its possible to have a full-scale, working web application. However, if we had many web applications that we wanted to host, all with their own dependencies and specific versions of these dependencies, we would run into issues.
</details>


### Installation

Before installing Flask, its advised to install virtualenv and activate our virtual environment. Then we just need to pip install flask.

<code>
~ $ source yourEnv/bin/activate
</code>
<code>
(yourEnv) ~ $ pip install flask
</code>

### Routing

```python
from flask import Flask,render_template

app = Flask(__name__)

# The @ symbol is noted as a decorator in python / flask.
@app.route('/')
# This function is what will be executed, when users visit localhost:5000/
def hello_world():
    # Tells our server to send index.html back to the client.
    return render_template("index.html")
# Tells our server to run
app.run(debug=True)
```

#### What happens when you place app.run() at the top of your .py file?