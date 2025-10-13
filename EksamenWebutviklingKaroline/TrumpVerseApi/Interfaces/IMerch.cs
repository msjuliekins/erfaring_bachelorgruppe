namespace TrumpVerseApi.Interfaces;

interface IMerch
{
    int Id {get; set;}
    string? Name {get; set;}
    string? Image {get; set;}
    double? Price {get; set;}
    int? Quantity {get; set;}
}