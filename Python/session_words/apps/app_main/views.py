from __future__ import unicode_literals
from django.shortcuts import render,redirect
from datetime import datetime

def index(request):
	if not "words" in request.session:
		request.session["words"] = [];

	return render(request,"app_main/index.html");

def create(request):
	if not 'word' in request.POST:
		word = "Default";
	else:
		word = request.POST["word"]

	if not 'color' in request.POST:
		color = "black"
	else:
		color = request.POST["color"]

	if 'font' not in request.POST:
		font = "small"
	else:
		font = "large"

	words = request.session["words"]

	words.append({
		'word':word,
		'color':color,
		'font':font,
		'createdAt':datetime.now().strftime("%H:%m:%s%p, %d %m %y")
	})

	request.session["words"] = words

	return redirect("/");

def clear(request):
	request.session.clear();
	return redirect("/")