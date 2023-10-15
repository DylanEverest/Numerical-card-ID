using System;
using Microsoft.AspNetCore.Mvc;
using System.Data;

namespace HealthApplication.Controllers
{
    [ApiController]
    [Route("api/info")]
    public class InfoController : ControllerBase
    {
        private readonly InfoRepository _infoRepository;

        public InfoController(InfoRepository infoRepository)
        {
            _infoRepository = infoRepository;
        }

        [HttpGet("{cardId}")]
        public IActionResult GetInfoByCardId(string cardId)
        {
            try
            {
                Info info = _infoRepository.GetInfoByCardId(cardId);

                if (info != null)
                {
                    return Ok(info);
                }
                else
                {
                    return NotFound();
                }
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }

    }
}
