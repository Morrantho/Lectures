from __future__ import unicode_literals
from django.shortcuts import render,redirect
from django.contrib import messages
from .models import Pizza,Topping

def index(request):
	pizzas = Pizza.objects.all()

	myStuff = {
		"pizzas":pizzas
	}
	return render(request,"app/index.html",myStuff)

def create(request):
	# global pizzas
	if request.method == "POST":
		errors = Pizza.objects.validate(request.POST["size"],request.POST["slices"])

		if isinstance(errors,list):
			for error in errors:
				messages.add_message(request,messages.ERROR,error)

		return redirect("/")
	else:
		return redirect("/")

def createTopping(request):
	name = request.POST["name"]
	pizza = request.POST["pizza"]

	Topping.objects.create(
		name=name,
		pizza_id=pizza
	)

	return redirect("/")