from django.shortcuts import render

# Create your views here.

from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from django.http.response import JsonResponse
from HarvestHub.serializers import MyappSerializer
from HarvestHub.models import Myapp

@csrf_exempt
def harvest_hub_api(request,id=0):
    if request.method=='GET':
        app = Myapp.objects.all()
        app_serializer=MyappSerializer(app,many=True)
        return JsonResponse(app_serializer.data,safe=False)
    
    elif request.method=='POST':
        app_data=JSONParser().parse(request)
        print(app_data)
        app_serializer=MyappSerializer(data=app_data)
        print(app_serializer.is_valid())
        if app_serializer.is_valid():
            app_serializer.save()
            return JsonResponse("Added Successfully",safe=False)
        else:
            print(app_serializer.errors)
            return JsonResponse("Failed to Add", safe=False)
        return JsonResponse("Failed to Add",safe=False)
    
    elif request.method=='PUT':
        app_data=JSONParser().parse(request)
        app=Myapp.objects.get(id=id)
        app_serializer=MyappSerializer(app,data=app_data)
        if app_serializer.is_valid():
            app_serializer.save()
            return JsonResponse("Updated Successfully",safe=False)
        return JsonResponse("Failed to Update")
    
    elif request.method=='DELETE':
        app=Myapp.objects.get(id=id)
        app.delete()
        return JsonResponse("Deleted Successfully",safe=False)