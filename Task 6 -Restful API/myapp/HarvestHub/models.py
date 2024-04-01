from django.db import models

# Create your models here.

class Myapp(models.Model):
    username = models.CharField(max_length=50)
    phn_number = models.BigIntegerField(unique=True)
    email = models.EmailField(unique=True)
    password = models.CharField(max_length=50)
    