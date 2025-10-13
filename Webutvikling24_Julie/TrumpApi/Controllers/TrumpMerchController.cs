using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TrumpApi.Contexts;
using TrumpApi.Models;

namespace TrumpApi.Controllers;

[ApiController]
[Route("api/[controller]")]


//class that uses all forms of crud to get, update, create and delete objects
public class TrumpMerchController : ControllerBase
{
    private readonly TrumpContext _trumpContext;

    public TrumpMerchController(TrumpContext trumpContext)
    {
        _trumpContext = trumpContext;
    }

    [HttpGet]
    public async Task<ActionResult<List<TrumpMerch>>> Get() 
    {
        try
        {
            List<TrumpMerch> merch = await _trumpContext.Merch.ToListAsync();
            return merch;
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<TrumpMerch>> Get(int id)
    {
        Console.WriteLine("searching by id");
        var merch = await _trumpContext.Merch.FindAsync(id);
        if (merch == null)
        {
            return NotFound();
        }
        return Ok(merch);
    }

    [HttpGet("title/{title}")] 
    public async Task<ActionResult<TrumpMerch>> GetByTitle(string title) { 
        Console.WriteLine("searching by title");
#pragma warning disable CS8602 // Dereference of a possibly null reference.
        var merch = await _trumpContext.Merch .FirstOrDefaultAsync(m => m.Title.Contains(title));
#pragma warning restore CS8602 // Dereference of a possibly null reference.
        if (merch == null) { 
            return NotFound(); 
        } 
        return Ok(merch); 
    }

    [HttpPost]
    public async Task<ActionResult<TrumpMerch>> Post(TrumpMerch newMerch)
    {
        try
        {   
            _trumpContext.Merch.Add(newMerch);
            await _trumpContext.SaveChangesAsync();
            return CreatedAtAction(nameof(Get), new { id = newMerch.Id }, newMerch);

        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    [HttpPut("{id}")]
    public async Task<ActionResult<TrumpMerch>> Put(long id, TrumpMerch newMerch)
    {
        if (id != newMerch.Id)
        {
            return StatusCode(StatusCodes.Status400BadRequest);
        }

        _trumpContext.Entry(newMerch).State = EntityState.Modified;

        try
        {
            await _trumpContext.SaveChangesAsync();
            return newMerch;
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    [HttpDelete("{id}")]
    public async Task<ActionResult<TrumpMerch>> Delete(int id)
    {
        try{
            var itemToDelete = await _trumpContext.Merch.FindAsync(id);
            if (itemToDelete == null)
            {
                return StatusCode(StatusCodes.Status404NotFound);
            }

            _trumpContext.Merch.Remove(itemToDelete);
            await _trumpContext.SaveChangesAsync();
            return NoContent();
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
        
    }
}
