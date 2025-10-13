using TrumpApi.Interfaces.ITrumpMerch;

namespace TrumpApi.Models;

public class TrumpMerch : ITrumpMerch
{
    public int Id {get; set;}

    public string? Title {get; set;}

    public string? Image {get; set;}

    public string? Size {get; set;}

    public string? MainColour {get; set;}
}