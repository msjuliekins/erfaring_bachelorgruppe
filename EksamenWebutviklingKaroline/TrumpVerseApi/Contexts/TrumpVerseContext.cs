#nullable disable
using Microsoft.EntityFrameworkCore;
using TrumpVerseApi.Models;

namespace TrumpVerseApi.Contexts;

public class TrumpVerseContext : DbContext
{
    public TrumpVerseContext(DbContextOptions<TrumpVerseContext>options):base(options){}

    public DbSet<Thought> Thoughts {get; set;}
    public DbSet<Merch> Merch {get; set;}
    public DbSet<Staff> Staff {get; set;}
}