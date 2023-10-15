using Dapper;
using Microsoft.Extensions.Configuration;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using HealthApplication.Models;
using Npgsql;
namespace HealthApplication.Repository
{
    public class HealthRepository
    {
        private readonly IConfiguration _config;
        private IDbConnection _connection;

        public HealthRepository(IConfiguration config)
        {
            _config = config;
            _connection = new NpgsqlConnection(_config.GetConnectionString("DefaultConnection"));
        }

        public IEnumerable<HealthInf> GetHealthByCardId(string cardId)
        {
            _connection.Open();
            var query = "SELECT * FROM health WHERE card_id = @CardId and date_end is not null" ;
            return _connection.Query<HealthInf>(query, new { CardId = cardId });
        }

        public HealthInf GetHealthById(int healthId)
        {
            _connection.Open();
            var query = "SELECT * FROM health WHERE health_id = @HealthId";
            return _connection.QueryFirstOrDefault<HealthInf>(query, new { HealthId = healthId });
        }

        public void CreateHealth(HealthInf health)
        {
            _connection.Open();
            var query = "INSERT INTO health (card_id, diseases, date_begin, date_end) " +
                        "VALUES (@CardId, @Diseases, @DateBegin, @DateEnd)";
            _connection.Execute(query, health);
        }

        public void UpdateHealth(HealthInf health)
        {
            _connection.Open();
            var query = "UPDATE health " +
                        "SET card_id = @CardId, diseases = @Diseases, date_begin = @DateBegin, date_end = @DateEnd " +
                        "WHERE health_id = @HealthId";
            _connection.Execute(query, health);
        }

        public void DeleteHealth(int healthId)
        {
            _connection.Open();
            var query = "DELETE FROM health WHERE health_id = @HealthId";
            _connection.Execute(query, new { HealthId = healthId });
        }
    }
}
