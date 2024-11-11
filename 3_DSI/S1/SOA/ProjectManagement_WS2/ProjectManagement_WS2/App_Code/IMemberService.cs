using System.ServiceModel;
using ProjectManagement_WS2.Models;

namespace ProjectManagement_WS2.Services
{
    [ServiceContract]
    public interface IMemberService
    {
        [OperationContract]
        string AssignMemberToTeam(int memberId, int teamId);
    }
}

