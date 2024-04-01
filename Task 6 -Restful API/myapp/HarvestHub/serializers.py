from rest_framework import serializers
from HarvestHub.models import Myapp

class MyappSerializer(serializers.ModelSerializer):
    class Meta:
        model = Myapp
        fields = '__all__'