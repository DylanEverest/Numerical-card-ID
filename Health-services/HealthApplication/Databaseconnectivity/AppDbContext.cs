using Microsoft.EntityFrameworkCore;
using HealthApplication.Models ;
public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

    public DbSet<HealthInf> HealthInf { get; set; }

}
