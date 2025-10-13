namespace TrumpVerseApi.Interfaces;

interface IStaff
{
    int Id {get; set;}
    string? FirstName {get; set;}
    string? LastName {get; set;}
    string? Image {get; set;}
    string? PhoneNumber {get; set;}
    string? Position {get; set;}
}