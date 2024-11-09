using Microsoft.EntityFrameworkCore;

public class MemberService : IMemberService
{
    private readonly ProjectManagementDbContext _context;

    public MemberService(ProjectManagementDbContext context)
    {
        _context = context;
    }

    public string AssignMemberToTeam(int memberId, int teamId)
    {
        // Retrieve the member and the team from the database
        var member = _context.Members.FirstOrDefault(m => m.Id == memberId);
        var team = _context.Teams.FirstOrDefault(t => t.Id == teamId);

        // If member or team not found, return a message
        if (member == null || team == null)
        {
            return "Member or Team not found.";
        }

        // Assign the team to the member
        member.TeamId = teamId;
        _context.SaveChanges();

        return $"Member {memberId} has been assigned to Team {teamId}.";
    }
}
