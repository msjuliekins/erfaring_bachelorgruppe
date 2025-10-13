//oppretter subklassen PResept av klassen Hvite
class PResept extends Hvite {
  //oppretter konstruktør og endrer pris
  public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {
    super(legemiddel, utskrivendeLege, pasientId, 3);
    if (legemiddel.hentPris() > 108) {
      legemiddel.settNyPris(legemiddel.hentPris() - 108);
    }
    else if (legemiddel.hentPris() <= 108) {
      legemiddel.settNyPris(0);
    }
  }
  //endrer toString-metoden
  public String toString() {
    return ("Legemiddel: (" + legemiddel +
            "), Utskrivende Lege: " + utskrivendeLege +
            ", Pasient ID: " + pasientId +
            ", Resept ID: " + super.id +
            ", Farge: " + super.farge());
  }
}
