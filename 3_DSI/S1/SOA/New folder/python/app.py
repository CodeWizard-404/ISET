from flask import Flask, request
from zeep import Client
from zeep.exceptions import Fault

app = Flask(__name__)

# In-memory storage for teams and members
teams = {
    1: {"name": "Team A", "members": []},
    2: {"name": "Team B", "members": []},
}

@app.route('/soap', methods=['POST'])
def affect_member():
    try:
        request_data = request.data
        # Example: <soapenv:Body><affectMember><teamId>1</teamId><memberId>101</memberId></affectMember></soapenv:Body>
        team_id = request_data.find(b'<teamId>') + 8
        team_id_end = request_data.find(b'</teamId>')
        member_id = request_data.find(b'<memberId>') + 10
        member_id_end = request_data.find(b'</memberId>')

        # Extract teamId and memberId
        team_id = int(request_data[team_id:team_id_end].decode('utf-8'))
        member_id = int(request_data[member_id:member_id_end].decode('utf-8'))

        # Check if the team exists
        if team_id not in teams:
            return f"<soapenv:Fault><faultcode>soapenv:Server</faultcode><faultstring>Team not found</faultstring></soapenv:Fault>", 404

        # Add the member to the team
        teams[team_id]["members"].append(member_id)
        return f"<soapenv:Envelope><soapenv:Body><response>Member {member_id} added to Team {team_id}</response></soapenv:Body></soapenv:Envelope>", 200

    except Exception as e:
        return f"<soapenv:Fault><faultcode>soapenv:Server</faultcode><faultstring>{str(e)}</faultstring></soapenv:Fault>", 500

if __name__ == '__main__':
    app.run(debug=True, port=5000)
