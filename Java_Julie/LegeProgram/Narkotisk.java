//oppretter subklasse Narkotisk av klassen Legemiddel
class Narkotisk extends Legemiddel {
  int styrke;

  //oppretter konstruktør
  public Narkotisk(String navn, double pris, double virkestoff, int s) {
    super(navn, pris, virkestoff);
    styrke = s;
  }
  //oppretter metode som returnerer Narkotisk styrke
  public int hentNarkotiskStyrke() {
    return styrke;
  }
  //endrer toString-metoden
  public String toString() {
    return ("Navn: " + navn +
            ", Pris: " + pris +
            ", Virkestoff: " + virkestoff +
            ", Styrke: " + styrke +
            ", ID: " + super.id);
  }
}
