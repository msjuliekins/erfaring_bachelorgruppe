using TrumpVerseApi.Interfaces;

namespace TrumpVerseApi.Models;

public class  Thought : IThought
{
    public int Id {get; set;}
    public string? Title {get; set;}
    public string? Content {get; set;}
}