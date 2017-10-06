# Week 1 Day 5

## Flask

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Flask_logo.svg/1200px-Flask_logo.svg.png" alt="Python" width="200px">

* Session
* Hidden Inputs
* Form Validation
* Flash Messages

#### How do we keep track of our variables across HTTP requests?

<details>
<summary><strong>What is session? How is it different from any other variable?</strong>
</summary>
Session allows us to persist data or variables across HTTP requests. This allows us to access data we may have previously stored, or store that data for future use. A practical example of this is keeping track of a user's cart they may have added products into. If we didnt do this, each time they refreshed the page or navigated elsewhere, their cart items would vanish!
</details>

### Using Session:

```python
from flask import Flask,request,redirect,flash,session
app = Flask(__name__)
app.secret_key = "hideme"

@app.route("/")
def index():
        return render_template("index.html");

@app.route("/process",methods=["POST"])
def process():        
        if len(request.form["name"]) < 1:
                flash("Name must be at least 1 character in length!")
        else:
                flash("Thanks for signing up,{}".format(request.form["name"))

        return redirect("/")

app.run(debug=True)
```

#### What happens if we store a large amount of data in session?

#### What data should we be storing in session?

<details>
<summary><strong>What are hidden inputs? How can we use them to our advantage?</strong>
</summary>
Hidden inputs are hidden from the user whom is viewing that <code>.html</code> file. We can take advantage of that and store data such as that particular user's name or id as attributes that we can access on our server via a form submission.
</details>