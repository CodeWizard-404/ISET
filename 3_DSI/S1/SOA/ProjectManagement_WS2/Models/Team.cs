using System.ComponentModel.DataAnnotations;

namespace ProjectManagement_WS2.Models
{
    public class Team
    {
        [Key]
        public required int Id { get; set; }
        public required string Name { get; set; }
    }
}

