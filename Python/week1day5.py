from flask import Flask,request,redirect,flash,session,render_template

app = Flask(__name__)
app.secret_key = "hideme"

@app.route("/")
def index():
        return render_template("index.html")

@app.route("/process",methods=["POST"])
def process():
        if len(request.form["firstName"]) < 1:
                flash("First name must be at least 1 character in length!")
                return redirect("/")

        session["name"] = request.form["firstName"]
        return redirect("/welcome")        

@app.route("/welcome")
def welcome():
        if not "name" in session:
                return redirect("/");
        return render_template("welcome.html");

app.run(debug=True)
