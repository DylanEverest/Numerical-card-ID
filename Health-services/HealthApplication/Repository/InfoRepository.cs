using Dapper;
using Microsoft.Extensions.Configuration;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using HealthApplication.Models ;
using Npgsql;
namespace HealthApplication.Repository
{
    public class InfoRepository
    {
        private readonly IConfiguration _config;
        private IDbConnection _connection;

        public InfoRepository(IConfiguration config)
        {
            _config = config;
            _connection = new NpgsqlConnection(_config.GetConnectionString("DefaultConnection"));
        }

        public Information GetInfoByCardId(string cardId)
        {
            _connection.Open();
            var query = "SELECT * FROM infos WHERE card_id = @CardId";
            return _connection.QueryFirstOrDefault<Information>(query, new { CardId = cardId });
        }

        // Autres méthodes CRUD ici
    }
}
