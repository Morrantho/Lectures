from __future__ import unicode_literals
from django.shortcuts import render

def index(request):
	return render(request,"courses/index.html")


def showComment(request):
	return render(request,"courses/index.html");