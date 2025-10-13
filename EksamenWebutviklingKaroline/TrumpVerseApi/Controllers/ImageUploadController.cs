using Microsoft.AspNetCore.Mvc;

namespace TrumpVerseApi.Controllers;

[ApiController]
[Route("api/[controller]")]

public class ImageUploadController : ControllerBase
{
    private readonly IWebHostEnvironment _webHostEnvironment;

    public ImageUploadController(IWebHostEnvironment webHostEnvironment)
    {
        _webHostEnvironment = webHostEnvironment;
    }

    [HttpPost]
    public async Task<IActionResult> Post(IFormFile file)
    {
        try
        {
            // Lager filstien før selve lagringen skjer
            string webRootPath = _webHostEnvironment.WebRootPath;

            // Kombinert med stedet bildene skal lagres - objekter i wwwroot
            string absolutePath = Path.Combine(webRootPath, "images", file.FileName);

            using(var fileStream = new FileStream(absolutePath, FileMode.Create))
            {
                await file.CopyToAsync(fileStream); // Selve lagringen
            }
        
            return Created(); // IActionResult
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
        
    }
}