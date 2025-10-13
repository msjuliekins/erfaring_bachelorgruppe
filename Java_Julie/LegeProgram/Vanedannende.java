//oppretter subklassen Vanedannende av klassen legemiddel
class Vanedannende extends Legemiddel {
  int styrke;

  //oppretter konstruktør
  public Vanedannende(String navn, double pris, double virkestoff, int s) {
    super(navn, pris, virkestoff);
    styrke = s;
  }

  //oppretter metode som returnerer Vanedannende styrke
  public int hentVanedannendeStyrke() {
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
