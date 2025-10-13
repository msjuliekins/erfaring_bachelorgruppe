//oppretter subklassen blaa av klassen Resept
class Blaa extends Resept {
  //oppretter konstruktør og endrer pris
  public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    legemiddel.settNyPris(legemiddel.hentPris()/100 * 25);
  }
  //oppretter metode som returnerer farge
  public String farge() {
    return "Blaa";
  }
  //oppretter metode som returnerer pris å betale
  public double prisAaBetale() {
    return legemiddel.hentPris();
  }
  //endrer toString-metoden
  public String toString() {
    return ("Legemiddel: (" + legemiddel +
            "), Utskrivende Lege: " + utskrivendeLege +
            ", Pasient ID: " + pasientId +
            " Reit: " + reit +
            ", Resept ID: " + super.id +
            ", Farge: " + farge());
  }
}
