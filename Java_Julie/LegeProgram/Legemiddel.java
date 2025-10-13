//oppretter abstrakt klasse Legemiddel
abstract class Legemiddel {
  String navn;
  double pris;
  double virkestoff;
  static int id = -1;

  //oppretter kontruktør
  public Legemiddel(String n, double p, double v) {
    navn = n;
    pris = p;
    virkestoff = v;
    id ++;

  }
  //oppretter metode som returnerer id
  public int hentId() {
    return id;
  }
  //oppretter metode som returnerer navn
  public String hentNavn() {
    return navn;
  }
  //oppretter metode som returnerer pris
  public double hentPris() {
    return pris;
  }
  //oppretter metode som returnerer virkestoff
  public double hentVirkestoff() {
    return virkestoff;
  }
  //oppretter metode som endrer pris
  public void settNyPris(double nyPris) {
    pris = nyPris;
  }
}
