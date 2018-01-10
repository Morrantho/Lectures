from flask import Flask,render_template,request,redirect,flash
from mysqlconnection import MySQLConnector

app = Flask(__name__)
app.secret_key = "hskdlfjslefuy2o3i7ylzdvnjkbrnbjeiw2738947"

db = MySQLConnector(app,'mydb')

@app.route("/")
def index():
	owners = db.query_db("SELECT * FROM owners;");

	return render_template("index.html",owners=owners)

@app.route("/owners/new",methods=["post"])
def create():
	errs = []

	if len(request.form['name']) < 1:
		errs.append("Name cannot be blank.")
	if len(request.form['email']) < 1:
		errs.append("Email cannot be blank.")
	if len(errs) > 0:
		for err in errs:
			flash(err)
		return redirect("/")

	query = "INSERT INTO owners(name,email,createdAt,updatedAt) VALUES(:name,:email,NOW(),NOW());"
	
	data  = {
		'name':request.form['name'],
		'email':request.form['email']
	}
	
	db.query_db(query,data)

	return redirect("/")

app.run(debug=True)