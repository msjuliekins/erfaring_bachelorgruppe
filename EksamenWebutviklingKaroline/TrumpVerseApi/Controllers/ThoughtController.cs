using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TrumpVerseApi.Models;
using TrumpVerseApi.Contexts;


namespace TrumpVerseApi.Controllers;

[ApiController]
[Route("api/[controller]")]
public class ThoughtController : ControllerBase
{
    private readonly TrumpVerseContext _trumpVerseContext;
    public ThoughtController(TrumpVerseContext trumpVerseContext)
    {
        _trumpVerseContext = trumpVerseContext;
    }

    // Hente alle

    [HttpGet]
    public async Task<ActionResult<Thought>> Get()
    {
        try
        {
            List<Thought> thoughts = await _trumpVerseContext.Thoughts.ToListAsync();
            return Ok(thoughts);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    //Finne med id

    // //https://stackoverflow.com/questions/62509285/what-is-name-property-in-the-constructor-for-httpgetattribute

    [HttpGet("{id}")]
    public async Task<ActionResult<Thought?>> Get(int id)
    {
        try
        {
            Thought? thought = await _trumpVerseContext.Thoughts.FindAsync(id);
            return Ok(thought);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Finne etter tittel

    [HttpGet]
    [Route("[action]/{title}")]
    public async Task<ActionResult<Thought>> FindByTitle(string title)
    {
        try
        {
            var thought = await _trumpVerseContext.Thoughts.FirstOrDefaultAsync(Thought => Thought.Title == title);
            if (thought != null)
            {
                return thought;
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
    public async Task<ActionResult<Thought>> Post(Thought newThought)
    {
        try
        {
            _trumpVerseContext.Thoughts.Add(newThought);
            await _trumpVerseContext.SaveChangesAsync();
            return newThought;
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Oppdatere

    [HttpPut]
    public async Task<ActionResult<Thought>> Put(Thought updatedThought)
    {
        try
        {
            _trumpVerseContext.Entry(updatedThought).State = EntityState.Modified;
            await _trumpVerseContext.SaveChangesAsync();
            return updatedThought;
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Slette

    [HttpDelete("{id}")]
    public async Task<ActionResult<Thought>> Delete(int id)
    {
        try
        {
            Thought? thoughtToDelete = await _trumpVerseContext.Thoughts.FindAsync(id);
            if (thoughtToDelete != null)
            {
                _trumpVerseContext.Thoughts.Remove(thoughtToDelete);
                await _trumpVerseContext.SaveChangesAsync();
                return thoughtToDelete;
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