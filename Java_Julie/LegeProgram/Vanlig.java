//oppretter subklassen vanlig av klassen legemiddel
class Vanlig extends Legemiddel {
  //oppretter konstruktør
  public Vanlig(String navn, double pris, double virkestoff) {
    super(navn, pris, virkestoff);
  }
  //endrer toString-metoden
  public String toString() {
    return ("Navn: " + navn +
            ", Pris: " + pris +
            ", Virkestoff: " + virkestoff +
            ", ID: " + super.id);
  }
}
