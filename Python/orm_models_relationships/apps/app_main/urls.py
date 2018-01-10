from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    # url(r'^users/new$',views.createUser,name="newUser"),
    # url(r'^hobby/new$',views.createHobby,name="newHobby"),
    url(r'^users/1/post/3/comments/1$',views.showComment,name="showComment"),


    # url(r'^students/', include('apps.students.urls', namespace='students')),
    # url(r'^courses/', include('apps.courses.urls', namespace='courses')),

]
