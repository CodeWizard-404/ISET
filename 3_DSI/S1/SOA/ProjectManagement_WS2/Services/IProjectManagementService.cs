using ProjectManagement_WS2.Models;
using System.ServiceModel;

namespace ProjectManagement_WS2.Services
{
    [ServiceContract]
    public interface IProjectManagementService
    {
        [OperationContract]
        string AssignMemberToTeam(int memberId, int teamId);
    }
}
