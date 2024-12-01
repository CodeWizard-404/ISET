using System;
using System.Configuration;
using MySql.Data.MySqlClient;
using ProjectManagement_WS2.Models;

namespace ProjectManagement_WS2.Services
{
    public class MemberService : IMemberService
    {
        private string connectionString = "server=localhost;database=projectmanagement;uid=root;";

        public string AssignMemberToTeam(int memberId, int teamId)
        {
            using (var connection = new MySqlConnection(connectionString))
            {
                connection.Open();

                // Check if the team exists
                string teamCheckQuery = "SELECT COUNT(*) FROM Team WHERE Id = @teamId";
                using (var teamCmd = new MySqlCommand(teamCheckQuery, connection))
                {
                    teamCmd.Parameters.AddWithValue("@teamId", teamId);
                    int teamExists = Convert.ToInt32(teamCmd.ExecuteScalar());

                    if (teamExists == 0)
                        return "Team does not exist.";
                }

                // Update the member's team
                string updateQuery = "UPDATE Member SET TeamId = @teamId WHERE Id = @memberId";
                using (var cmd = new MySqlCommand(updateQuery, connection))
                {
                    cmd.Parameters.AddWithValue("@teamId", teamId);
                    cmd.Parameters.AddWithValue("@memberId", memberId);
                    int rowsAffected = cmd.ExecuteNonQuery();

                    return rowsAffected > 0 ? "Member assigned to team successfully." : "Member not found.";
                }
            }
        }
    }
}
