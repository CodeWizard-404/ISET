using Microsoft.EntityFrameworkCore;
using ProjectManagement_WS2.Models;

namespace ProjectManagement_WS2.Data
{
    public class ProjectManagementDbContext : DbContext
    {
        public ProjectManagementDbContext(DbContextOptions<ProjectManagementDbContext> options)
            : base(options) { }

        public DbSet<Member> Members { get; set; }
        public DbSet<Team> Teams { get; set; }
    }
}

