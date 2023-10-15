using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using  HealthApplication.Repository ;
var builder = WebApplication.CreateBuilder(args);

// Configuration de l'application
builder.Configuration.AddJsonFile("appsettings.json", optional: false);

// Récupérez la configuration
var configuration = builder.Configuration;

// Configuration de la base de données
var connectionString = configuration.GetConnectionString("DefaultConnection");

// Ajoutez les services à la configuration
builder.Services.AddDbContext<AppDbContext>(options => options.UseNpgsql(connectionString));



    // Register Your service BankAccountRepository
builder.Services.AddScoped<HealthRepository>();
    
builder.Services.AddScoped<InfoRepository>();





builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configurez le pipeline de requête HTTP
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();
app.MapControllers();

app.Run();
