public class Member
{
    public int Id { get; set; }
    public string Name { get; set; }
    public int TeamId { get; set; } // Foreign Key to Team
    public Team Team { get; set; }  // Navigation property for the Team
}
