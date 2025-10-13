using TrumpVerseApi.Interfaces;

namespace TrumpVerseApi.Models;

public class Merch : IMerch
{
    public int Id {get; set;}
    public string? Name {get; set;}
    public string? Image {get; set;}
    public double? Price {get; set;}
    public int? Quantity {get; set;}
}