
class Sted {
  Skattekiste skatt;
  Sted nytt;
  String beskriv;


  public Sted(String beskrivelse) {
    this.beskriv = beskrivelse;
  }

  public void skattekiste() {
    this.skatt = new Skattekiste();
  }

  public Skattekiste kista() {
    return skatt;
  }

  public Sted gaaVidere(String beskrivelse) {
    nytt = new Sted(beskrivelse);
    return nytt;
  }

}
