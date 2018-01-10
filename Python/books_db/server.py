from flask import Flask,render_template,redirect,session,request,flash
from mysqlconnection import MySQLConnector

app = Flask(__name__)
app.secret_key = "kadjsdlahskldahjskldajhsd"
db = MySQLConnector(app,"books_db")

@app.route("/")
def index():
	books = db.query("SELECT * FROM books;")
	return render_template("index.html",books=books)

@app.route("/add")
def add():
	return render_template("add.html")

@app.route("/books/new",methods=["POST"])
def create():
	query = "INSERT INTO books(title,author,createdAt,updatedAt) VALUES(:title,:author,NOW(),NOW());"

	data = {
		"author":request.form["author"],
		"title":request.form["title"]
	}

	db.query(query,data)

	return redirect("/")

@app.route("/books/delete/<id>")
def delete(id):
	query = "SELECT * FROM books WHERE id = "+id
	book  = db.query(query)[0]

	return render_template("delete.html",book=book)

@app.route("/books/destroy/<id>")
def destroy(id):
	query = "DELETE FROM books WHERE id = "+id;
	db.query(query)
	return redirect("/")
app.run(debug=True)