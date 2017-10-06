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

#### What happens if we store a large amount of data in session?

#### What data should we be storing in session?

<details>
<summary><strong>What are hidden inputs? How can we use them to our advantage?</strong>
</summary>
Hidden inputs are hidden from the user whom is viewing that <code>.html</code> file. We can take advantage of that and store data such as that particular user's name or id as attributes that we can access on our server via a form submission.
</details>

<details>
<summary><strong>What is Flash and what are Flash Messages?</strong></summary>
Flash messages are messages we can display to users based off of conditions in our views such as if they forgot to input something into a form we've created. Flash messages use session to do this and only last for one Request and Response cycle. We can then display these messages on any of our templates, checking for their existance.
</details>

### Session, POST and Flash:

```python
# We're going to need these modules.
from flask import Flask,request,redirect,flash,session,render_template

app = Flask(__name__)
# We need to set a secret key in order to use session
app.secret_key = "hideme"

# Defining a route
@app.route("/")
# index() gets run when we visit "/"
def index():
        return render_template("index.html")

# Tell Flask we want "/process" to be a POST request
@app.route("/process",methods=["POST"])
# process() gets run when we visit "/process"
def process():
        # if the length of firstName is less than 1, flash a message saying they need to input something and redirect them to "/".
        if len(request.form["firstName"]) < 1:
                flash("First name must be at least 1 character in length!")
                return redirect("/")
        #Otherwise, store the firstName they supplied us, so we can use it later. Then redirect them to the welcome page, since they passed our validation.
        session["name"] = request.form["firstName"]
        return redirect("/welcome")

@app.route("/welcome")
def welcome():
        # If we dont have a name key in our session, dont let them visit this welcome page by redirecting to "/".
        if not "name" in session:
                return redirect("/");
        # Otherwise, proceed with rending our welcome page!
        return render_template("welcome.html");

app.run(debug=True)
```
