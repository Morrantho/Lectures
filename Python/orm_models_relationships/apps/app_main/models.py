from __future__ import unicode_literals
from django.db import models
from django.contrib import messages

class UserManager(models.Manager):
	def add(self,request):
		errs = []

		if len(request.POST["firstName"]) < 1:
			errs.append("Your first name cannot be blank!")
		
		if len(request.POST["lastName"]) < 1:
			errs.append("Your last name cannot be blank!")


		if len(errs) <= 1:
			self.create(
				firstName=request.POST["firstName"],
				lastName = request.POST["lastName"]
			)
			messages.add_message(request,messages.SUCCESS,"User created successfully!");
		else:
			for err in errs:
				messages.add_message(request,messages.ERROR,err);

class User(models.Model):
	firstName = models.CharField(max_length=255)
	lastName  = models.CharField(max_length=255)
	createdAt = models.DateTimeField(auto_now_add=True)
	updatedAt = models.DateTimeField(auto_now=True)
	manager   = UserManager()

	def __repr__(self):
		return "{}".format(self.firstName)

class Hobby(models.Model):
	title         = models.CharField(max_length=255)
	createdAt     = models.DateTimeField(auto_now_add=True)
	updatedAt     = models.DateTimeField(auto_now=True)
	practitioners = models.ManyToManyField(User,related_name="users_hobbies")

	def __repr__(self):
		return "{}".format(self.title)