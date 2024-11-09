using ProjectManagement_WS2.Data;
using ProjectManagement_WS2.Models;
using System.ServiceModel;

namespace ProjectManagement_WS2.Services
{
    public class ProjectManagementService : IProjectManagementService
    {
        private readonly ProjectManagementDbContext _dbContext;

        public ProjectManagementService(ProjectManagementDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public string AssignMemberToTeam(int memberId, int teamId)
        {
            var member = _dbContext.Members.FirstOrDefault(m => m.Id == memberId);
            var team = _dbContext.Teams.FirstOrDefault(t => t.Id == teamId);

            if (member == null)
            {
                return "Member not found!";
            }

            if (team == null)
            {
                return "Team not found!";
            }

            // Logic to assign member to team (can be extended with more logic like saving relationships)
            return $"Member {member.Name} has been assigned to team {team.Name}.";
        }
    }
}
