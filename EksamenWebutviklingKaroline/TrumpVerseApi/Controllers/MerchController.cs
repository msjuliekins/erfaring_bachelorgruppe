using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TrumpVerseApi.Contexts;
using TrumpVerseApi.Models;

namespace TrumpVerseApi.Controllers;

[ApiController]
[Route("api/[controller]")]

public class MerchController : ControllerBase
{
    private readonly TrumpVerseContext _trumpVerseContext;
    public MerchController(TrumpVerseContext trumpVerseContext)
    {
        _trumpVerseContext = trumpVerseContext;
    }

    // Hente alle

    [HttpGet]
    public async Task<ActionResult<Merch>> Get()
    {
        try
        {
            List<Merch> merch = await _trumpVerseContext.Merch.ToListAsync();
            return Ok(merch);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    //Finne med id

    // //https://stackoverflow.com/questions/62509285/what-is-name-property-in-the-constructor-for-httpgetattribute

    [HttpGet("{id}")]
    public async Task<ActionResult<Merch?>> Get(int id)
    {
        try
        {
            Merch? merch = await _trumpVerseContext.Merch.FindAsync(id);
            return Ok(merch);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Finne etter tittel

    [HttpGet]
    [Route("[action]/{name}")]
    public async Task<ActionResult<Merch>> FindByName(string name)
    {
        try
        {
            var merch = await _trumpVerseContext.Merch.FirstOrDefaultAsync(Merch => Merch.Name == name);
            if (merch != null)
            {
                return Ok(merch);
            }
            else
            {
                return NotFound();
            }
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Legge til ny

    [HttpPost]
    public async Task<ActionResult<Merch>> Post(Merch newMerch)
    {
        try
        {
            _trumpVerseContext.Merch.Add(newMerch);
            await _trumpVerseContext.SaveChangesAsync();
            return Ok(newMerch);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Oppdatere

    [HttpPut]
    public async Task<ActionResult<Merch>> Put(Merch updatedMerch)
    {
        try
        {
            _trumpVerseContext.Entry(updatedMerch).State = EntityState.Modified;
            await _trumpVerseContext.SaveChangesAsync();
            return Ok(updatedMerch);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Slette

    [HttpDelete("{id}")]
    public async Task<ActionResult<Merch>> Delete(int id)
    {
        try
        {
           Merch? merchToDelete = await _trumpVerseContext.Merch.FindAsync(id);
            if (merchToDelete != null)
            {
                _trumpVerseContext.Merch.Remove(merchToDelete);
                await _trumpVerseContext.SaveChangesAsync();
                return Ok(merchToDelete);
            }
            else
            {
                return NotFound();
            }
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }
}