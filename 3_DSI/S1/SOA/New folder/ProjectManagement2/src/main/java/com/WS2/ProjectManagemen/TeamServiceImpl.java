package com.WS2.ProjectManagemen;
 
import javax.jws.WebService;

@WebService(endpointInterface = "com.example.soapservice.TeamService")
public class TeamServiceImpl implements TeamService {

    @Override
    public String affectMemberToTeam(String memberId, String teamId) {
        return "Member with ID: " + memberId + " has been successfully assigned to Team: " + teamId;
    }
}
