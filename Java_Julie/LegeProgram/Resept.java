//oppretter abstrakt klasse Resept
abstract class Resept {
  Legemiddel legemiddel;
  Lege utskrivendeLege;
  int pasientId;
  int reit;
  static int id = -1;

  //oppretter konstruktør
  public Resept(Legemiddel l, Lege u, int p, int r) {
    legemiddel = l;
    utskrivendeLege = u;
    pasientId = p;
    reit = r;
    id++;
  }
  //oppretter metode som returnerer id
  public int hentId() {
    return id;
  }
  //oppretter metode som returnerer et legemiddel
  public Legemiddel hentLegemiddel() {
    return legemiddel;
  }
  //oppretter en metode som returnerer Utskrivende lege
  public Lege hentLege() {
    return utskrivendeLege;
  }
  //oppretter metode som returnerer pasient id
  public int hentPasientId() {
    return pasientId;
  }
  //oppretter metode som returnerer antall reit
  public int hentReit() {
    return reit;
  }
  //oppretter metode som simulerer bruk av resepten basert på antall reit
  public boolean bruk() {
    if (reit > 0) {
      reit -= 1;
      return true;
    }
    return false;
  }
  //oppretter abstrakt metode farge
  abstract public String farge();
  //oppretter abstrakt metode
  abstract public double prisAaBetale();
}
