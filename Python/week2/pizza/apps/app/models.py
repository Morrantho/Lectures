from __future__ import unicode_literals
from django.db import models

class PizzaManager(models.Manager):
	def validate(self,size,slices):
		errors = []

		if int(size) < 1 or int(size) > 18:
			errors.append("Size must be between 1 and 18.")
		if int(slices) < 1 or int(slices) > 18:
			errors.append("Size must be between 1 and 18.")			

		if len(errors) == 0:
			print("CREATING A PIZZA!")

			pizza = Pizza.objects.create(
				size = size,
				slices = slices
			)

			return pizza			
		else:
			return errors

class Pizza(models.Model):
	size     = models.IntegerField()
	slices   = models.IntegerField()
	objects  = PizzaManager()

class Topping(models.Model):
	name = models.CharField(max_length=255)
	pizza = models.ForeignKey(Pizza,related_name="toppings")