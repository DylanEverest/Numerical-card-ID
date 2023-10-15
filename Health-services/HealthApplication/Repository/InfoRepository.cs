using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HealthApplication.Repository
{
    public class InfoRepository
    {
        private readonly IDbConnection _connection;

        public InfoRepository(IDbConnection connection)
        {
            _connection = connection;
        }

        public Info GetInfoByCardId(string cardId)
        {
            return _connection.QueryFirstOrDefault<Info>(
                "SELECT * FROM infos WHERE card_id = @CardId",
                new { CardId = cardId }
            );
        }
    }
}