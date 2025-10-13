namespace TrumpApi.Interfaces.ITrumpMerch;

public interface ITrumpMerch
{
    int Id {get; set;}

    string? Title {get; set;}

    string? Image {get; set;}

    string? Size {get; set;}

    string? MainColour {get; set;}
}