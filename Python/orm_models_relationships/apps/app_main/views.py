from __future__ import unicode_literals
from django.shortcuts import render,redirect,reverse
from .models import User,Hobby

def index(request):
	return render(request,"app_main/index.html",{
		'users':User.manager.all(),
		'hobbies':Hobby.objects.all()
	});

def createUser(request):
	User.manager.add(request)
	return redirect("/")

def createHobby(request):
	Hobby.objects.create(
		title=request.POST["title"]
	)

	return redirect("/")

def showComment(request):
	return render(request,"app_main/showComment.html")