
class Gjenstand {
  String navn;
  int verdi;

  public Gjenstand(String navnet, int verdien) {
    navn = navnet;
    verdi = verdien;
  }

  public String navn() {
    return navn;
  }

  public int verdi() {
    return verdi;
  }
}
