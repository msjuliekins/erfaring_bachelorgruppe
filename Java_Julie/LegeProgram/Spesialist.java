//oppretter subklassen Spesialist av klassen lege
//implementerer grensesnittet Godkjenningsfritak
class Spesialist extends Lege implements Godkjenningsfritak {

  int kontrollID;
  //oppretter konstruktør
  public Spesialist(String navn, int id) {
    super(navn);
    kontrollID = id;
  }
  //oppretter metode som returnerer kontroll id
  public int hentKontrollID(){
    return kontrollID;
  }
  //endrer toString-metoden
  public String toString(){
    return ("Navn: " + navn + ", Kontroll ID: " + kontrollID);
  }
}
