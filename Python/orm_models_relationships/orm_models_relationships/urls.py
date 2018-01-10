from django.conf.urls import url,include

urlpatterns = [
    url(r'^',include("apps.app_main.urls")),
    url(r'^courses',include("apps.courses.urls",namespace="courses")),
    url(r'^students',include("apps.students.urls",namespace="students")),
]
