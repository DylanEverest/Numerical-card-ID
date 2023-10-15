using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HealthApplication.Models
{
    public class Information
    {
        public string CardId { get; set; }
        public string Name { get; set; }
        public string FirstName { get; set; }
        public DateTime? BirthDate { get; set; }
    }

}