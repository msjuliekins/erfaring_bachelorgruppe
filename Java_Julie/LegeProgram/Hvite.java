//oppretter subklassen HVite av klassen resept
class Hvite extends Resept {
  //oppretter konstruktør
  public Hvite(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
    super(legemiddel, utskrivendeLege, pasientId, reit);
  }
  //oppretter metode som returnerer farge
  public String farge() {
    return "Hvit";
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
            ", Reit: " + reit +
            ", Resept ID: " + super.id +
            ", Farge: " + farge());
  }
}
