from django.http import HttpResponse
from .soap_service import add_member_to_team

def soap_add_member(request):
    # Extract member details from the request (you'll need to parse the SOAP body)
    # For simplicity, let's assume you have the values in the query parameters for testing
    first_name = request.GET.get('first_name')
    last_name = request.GET.get('last_name')
    email = request.GET.get('email')

    response_message = add_member_to_team(first_name, last_name, email)
    return HttpResponse(response_message)