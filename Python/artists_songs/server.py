from flask import Flask,render_template,request,redirect,session,flash
from mysqlconnector import MySQLConnector

app = Flask(__name__)
app.secret_key = "as98d7a089s6gh23jhklfhjdvsd890f7v"

# Pass our flask application as well as our db name we'd like to connect to.
db = MySQLConnector(app,"songs_artists")

@app.route("/")
def index():
	# Get All artists
	artists       = db.query_db("SELECT * FROM artists;")
	# Get All Songs
	songs         = db.query_db("SELECT * FROM songs;")
	# Get all artists and songs from our many to many table.
	artists_songs = db.query_db("SELECT songs.name AS songName,songs.popularity AS popularity,artists.name AS artistName,artists.genre AS genre FROM songs_artists JOIN songs ON songs.id=songs_artists.songs_id JOIN artists ON artists.id=songs_artists.artists_id;");

	return render_template("index.html",songs=songs,artists=artists,artists_songs=artists_songs);

# Create a new song
@app.route("/songs/new",methods=["POST"])
def createSong():
	query = "INSERT INTO songs(name,popularity) VALUES(:name,:popularity)"

	data = {
		"name":request.form["name"],
		"popularity":request.form["popularity"]
	}

	db.query_db(query,data)

	return redirect("/")

# Create a new Artist
@app.route("/artists/new",methods=["POST"])
def createArtist():
	query = "INSERT INTO artists(name,genre) VALUES(:name,:genre)"
	data = {
		"name":request.form["name"],
		"genre":request.form["genre"]
	}

	db.query_db(query,data)

	return redirect("/")

# Assign artist to song or song to artist
@app.route("/assign",methods=["POST"])
def assign():
	# Assign / insert pre-existing artist or song id's into our many to many table.
	query = "INSERT INTO songs_artists(artists_id,songs_id) VALUES(:artistId,:songId);"

	data = {
		"artistId":request.form["artistId"],
		"songId":request.form["songId"]
	}

	db.query_db(query,data);

	return redirect("/")

app.run(debug=True)