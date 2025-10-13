#nullable disable

using Microsoft.EntityFrameworkCore;
using TrumpApi.Models;

namespace TrumpApi.Contexts;

public class TrumpContext : DbContext
{
    public TrumpContext(DbContextOptions<TrumpContext> options):base(options){}

    public DbSet<TrumpMerch> Merch {get; set;}
}