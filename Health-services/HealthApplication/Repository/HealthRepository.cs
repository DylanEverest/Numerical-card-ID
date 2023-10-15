using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HealthApplication.Repository
{
    public class HealthRepository
    {
        private readonly IDbConnection _connection;

        public HealthRepository(IDbConnection connection)
        {
            _connection = connection;
        }

        public HealthInf GetHealthByCardId(string cardId)
        {
            return _connection.QueryFirstOrDefault<HealthInf>(
                "SELECT * FROM health WHERE card_id = @CardId",
                new { CardId = cardId }
            );
        }

    }
}