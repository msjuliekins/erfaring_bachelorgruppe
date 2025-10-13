//oppretter subklassen Militaer av klassen Resept
class Militaer extends Hvite {
  //oppretter konstruktør og endrer pris
  public Militaer(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
    legemiddel.settNyPris(0);
  }
  //endrer toString-metoden
  public String toString() {
    return ("Legemiddel: (" + legemiddel +
            "), Utskrivende Lege: " + utskrivendeLege +
            ", Pasient ID: " + pasientId +
            ", Reit: " + reit +
            ", Resept ID: " + super.id +
            ", Farge: " + super.farge());
  }
}
