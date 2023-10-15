using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace HealthApplication.Models
{
    [Table("health")] // Spécifie le nom de la table dans la base de données
    public class HealthInf
    {
        [Key]
        [Column("health_id")] // Spécifie le nom de la colonne dans la table
        public int health_id { get; set; }

        [Column("card_id")]
        public string card_id { get; set; }

        [Column("deseases")]
        public string deseases { get; set; }

        [Column("date_begin")]
        [Required] // Indique que la colonne ne peut pas être nulle
        public DateTime date_begin { get; set; }

        [Column("date_end")]
        public DateTime? date_end { get; set; }
    }
}
