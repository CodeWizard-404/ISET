using System.ServiceModel;

[ServiceContract]
public interface IMemberService
{
    [OperationContract]
    string AssignMemberToTeam(int memberId, int teamId);
}
