from django.contrib import admin
from django.urls import path
from team.views import soap_add_member  # Make sure this is correct too

urlpatterns = [
    path('admin/', admin.site.urls),
    path('add_member/', soap_add_member, name='add_member'),  # Your SOAP endpoint
]
