using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;

namespace TrumpApi.Controllers;

[ApiController]
[Route("api/[controller]")]


//this class is responsible for allowing the project to use and upload images via the database
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
            string webRootPath = _webHostEnvironment.WebRootPath;
            string absolutePath = Path.Combine(webRootPath, "images", file.FileName);

            using(var fileStream = new FileStream(absolutePath, FileMode.Create))
            {
                await file.CopyToAsync(fileStream);
            }

        return Created();
        }
        catch
        {
            return StatusCode(StatusCodes.Status500InternalServerError);
        }
    }
}