from zeep import Client
from zeep import xsd

def add_member_to_team(member_first_name, member_last_name, member_email):
    # Logic to add the member to the database
    try:
        if TeamMember.objects.filter(email=member_email).exists():
            return f"Error: A member with email {member_email} already exists."
        
        member = TeamMember(
            first_name=member_first_name,
            last_name=member_last_name,
            email=member_email,
        )
        member.save()
        
        return f"Member {member.first_name} {member.last_name} added."
    except Exception as e:
        return str(e)
