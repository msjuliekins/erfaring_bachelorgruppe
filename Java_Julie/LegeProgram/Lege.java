//oppretter klassen lege
class Lege {

String navn;
  //oppretter konstruktør
  public Lege(String n){
    navn = n;
  }
  //endrer toString-metoden
  public String toString() {
    return ("Navn: " + navn);
  }
}
