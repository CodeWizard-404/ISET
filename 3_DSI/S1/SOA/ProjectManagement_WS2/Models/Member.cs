using System.ComponentModel.DataAnnotations;

namespace ProjectManagement_WS2.Models
{
    public class Member
    {
        [Key]
        public required int Id { get; set; }
        public required string Name { get; set; }
        public required string Role { get; set; }
    }
}

