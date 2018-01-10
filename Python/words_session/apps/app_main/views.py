from __future__ import unicode_literals
from django.shortcuts import render,redirect
from datetime import datetime

def index(request):
	if not 'words' in request.session:
		request.session["words"] = []

	return render(request,"app_main/index.html")

def create(request):
	if len(request.POST["word"]) < 1:
		word = "default"
	else:
		word = request.POST["word"]

	if not 'color' in request.POST:
		color = "black"
	else:
		color = request.POST["color"]

	if not 'font' in request.POST:
		font = "off"
	else:
		font = "on"

	createdAt = datetime.now();
	createdAt = createdAt.strftime("")

	data = {
		'word':word,
		'color':color,
		'font':font,
		'createdAt':createdAt
	}

	words = request.session["words"]
	words.append(data)
	request.session["words"] = words

	return redirect("/")

def clear(request):
	request.session.clear()
	return redirect("/")
