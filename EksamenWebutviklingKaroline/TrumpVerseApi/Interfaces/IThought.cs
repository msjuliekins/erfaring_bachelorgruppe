namespace TrumpVerseApi.Interfaces;

interface IThought 
{
    int Id {get; set;}
    string? Title {get; set;}
    string? Content {get; set;}
}