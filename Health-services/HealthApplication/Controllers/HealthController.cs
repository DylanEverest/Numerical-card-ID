using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using HealthApplication.Models;
using HealthApplication.Repository;

namespace HealthApplication.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class HealthController : ControllerBase
    {
        private readonly HealthRepository _repository;

        public HealthController(HealthRepository repository)
        {
            _repository = repository;
        }

        [HttpGet("{cardId}")]
        public IActionResult GetHealthByCardId(string cardId)
        {
            try
            {
                IEnumerable<HealthInf> health = _repository.GetHealthByCardId(cardId);
                return Ok(health);
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }

        [HttpGet("byId/{healthId}")]
        public IActionResult GetHealthById(int healthId)
        {
            try
            {
                HealthInf health = _repository.GetHealthById(healthId);
                    
                return Ok(health);
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPost]
        public IActionResult CreateHealth([FromBody] HealthInf health)
        {
            try
            {
                _repository.CreateHealth(health);
                return CreatedAtAction(nameof(GetHealthById), new { healthId = health.health_id }, health);
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }

        [HttpPut("{healthId}")]
        public IActionResult UpdateHealth(int healthId, [FromBody] HealthInf updatedHealth)
        {
            try
            {
                HealthInf existingHealth = _repository.GetHealthById(healthId);
                    return NotFound("Santé introuvable.");
                

                existingHealth.card_id = updatedHealth.card_id;
                existingHealth.deseases = updatedHealth.deseases;
                existingHealth.date_begin = updatedHealth.date_begin;
                existingHealth.date_end = updatedHealth.date_end;

                _repository.UpdateHealth(existingHealth);
                return NoContent();
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }

        [HttpDelete("{healthId}")]
        public IActionResult DeleteHealth(int healthId)
        {
            try
            {
                HealthInf existingHealth = _repository.GetHealthById(healthId);
                if (existingHealth == null)
                {
                    return NotFound("Santé introuvable.");
                }

                _repository.DeleteHealth(healthId);
                return Ok("Santé supprimée.");
            }
            catch (Exception ex)
            {
                return StatusCode(500, ex.Message);
            }
        }
    }
}
