using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace TrumpApi.Migrations
{
    /// <inheritdoc />
    public partial class UpdateTrumpSchema : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Staffmember");

            migrationBuilder.DropTable(
                name: "Thoughts");

            migrationBuilder.AddColumn<string>(
                name: "MainColour",
                table: "Merch",
                type: "TEXT",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "Size",
                table: "Merch",
                type: "TEXT",
                nullable: true);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "MainColour",
                table: "Merch");

            migrationBuilder.DropColumn(
                name: "Size",
                table: "Merch");

            migrationBuilder.CreateTable(
                name: "Staffmember",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    Image = table.Column<string>(type: "TEXT", nullable: true),
                    Name = table.Column<string>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Staffmember", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Thoughts",
                columns: table => new
                {
                    Id = table.Column<int>(type: "INTEGER", nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    Date = table.Column<string>(type: "TEXT", nullable: true),
                    Thought = table.Column<string>(type: "TEXT", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Thoughts", x => x.Id);
                });
        }
    }
}
