from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index,name="root"),
    url(r'^1/post/3/comments/1$',views.showComment,name="show"),
]
