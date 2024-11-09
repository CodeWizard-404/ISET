using Microsoft.EntityFrameworkCore;

public class ProjectManagementDbContext : DbContext
{
    public ProjectManagementDbContext(DbContextOptions<ProjectManagementDbContext> options)
        : base(options) { }

    public DbSet<Member> Members { get; set; }
    public DbSet<Team> Teams { get; set; }
}
