using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TrumpVerseApi.Models;
using TrumpVerseApi.Contexts;

namespace TrumpVerseApi.Controllers;

[ApiController]
[Route("api/[controller]")]
public class StaffController : ControllerBase
{
    private readonly TrumpVerseContext _trumpVerseContext;
    public StaffController(TrumpVerseContext trumpVerseContext)
    {
        _trumpVerseContext = trumpVerseContext;
    }

    // Hente alle

    [HttpGet]
    public async Task<ActionResult<Staff>> Get()
    {
        try
        {
            List<Staff> staff = await _trumpVerseContext.Staff.ToListAsync();
            return Ok(staff);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    //Finne med id

    // //https://stackoverflow.com/questions/62509285/what-is-name-property-in-the-constructor-for-httpgetattribute

    [HttpGet("{id}")]
    public async Task<ActionResult<Staff?>> Get(int id)
    {
        try
        {
           Staff? staff = await _trumpVerseContext.Staff.FindAsync(id);
           if (staff != null)
           {
            return Ok(staff);
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

    // Finne etter navn

    [HttpGet]
    [Route("[action]/{firstName}")]
    public async Task<ActionResult<Staff>> FindByFirstName(string firstName)
    {
        try
        {
            var staff = await _trumpVerseContext.Staff.FirstOrDefaultAsync(Staff => Staff.FirstName == firstName);
            if (staff != null)
            {
                return Ok(staff);
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

    [HttpGet]
    [Route("[action]/{lastName}")]
    public async Task<ActionResult<Staff>> FindByLastName(string lastName)
    {
        try
        {
            var staff = await _trumpVerseContext.Staff.FirstOrDefaultAsync(Staff => Staff.LastName == lastName);
            if (staff != null)
            {
                return Ok(staff);
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
    public async Task<ActionResult<Staff>> Post(Staff newStaff)
    {
        try
        {
            _trumpVerseContext.Staff.Add(newStaff);
            await _trumpVerseContext.SaveChangesAsync();
            return Ok(newStaff);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Oppdatere

    [HttpPut]
    public async Task<ActionResult<Staff>> Put(Staff updatedStaff)
    {
        try
        {
            _trumpVerseContext.Entry(updatedStaff).State = EntityState.Modified;
            await _trumpVerseContext.SaveChangesAsync();
            return Ok(updatedStaff);
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }

    // Slette

    [HttpDelete("{id}")]
    public async Task<ActionResult<Staff>> Delete(int id)
    {
        try
        {
            Staff? staffToDelete = await _trumpVerseContext.Staff.FindAsync(id);
            if (staffToDelete != null)
            {
                _trumpVerseContext.Staff.Remove(staffToDelete);
                await _trumpVerseContext.SaveChangesAsync();
                return Ok(staffToDelete);
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