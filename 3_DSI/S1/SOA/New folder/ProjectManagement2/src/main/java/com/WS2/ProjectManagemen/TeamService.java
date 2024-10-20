package com.WS2.ProjectManagemen;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TeamService {

    @WebMethod
    public String affectMemberToTeam(String memberId, String teamId);
}
