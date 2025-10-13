using TrumpVerseApi.Interfaces;

namespace TrumpVerseApi.Models;

public class Staff : IStaff
{
    public int Id {get; set;}
    public string? FirstName {get; set;}
    public string? LastName {get; set;}
    public string? Image {get; set;}
    public string? PhoneNumber {get; set;}
    public string? Position {get; set;}
}