using System;
using Microsoft.AspNetCore.Mvc;
using System.Data;
using HealthApplication.Repository;
using HealthApplication.Models;
namespace HealthApplication.Controllers
{
    [ApiController]
    [Route("[controller]")]
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
                Information info = _infoRepository.GetInfoByCardId(cardId);

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
