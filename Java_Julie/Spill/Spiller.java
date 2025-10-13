import java.util.Random;

class Spiller {
  int formue;
  Bruker bruker;
  Skattekiste ryggsekk;
  Robot robot;
  Gjenstand objekt;
  Terreng terreng;
  Sted sted;

;
  public Spiller(Sted startsted, Bruker brukeren) {
    ryggsekk = new Skattekiste();
    formue = 0;
    bruker = brukeren;
    terreng = new Terreng();
    sted  = startsted;
  }


  public void nyttTrekk() {
    sted.skattekiste();
    Random random = new Random();
    String[] kommandoer = new String[2];
    kommandoer[0] = "0. Ja";
    kommandoer[1] = "1. Nei";
    bruker.giStatus(sted.beskriv);
    int valg = bruker.beOmKommando("Oensker du aa selge en gjenstand?", kommandoer);
    if (valg == 0) {
      objekt = ryggsekk.taUt();
      sted.kista().leggInn(objekt);
      int verdi = sted.kista().leggInn(objekt);
      formue += verdi;
      bruker.giStatus("Selger gjenstand");
      System.out.println("-" + objekt.navn());
    }

    valg = bruker.beOmKommando("Oensker du aa plukke opp ny gjenstand?", kommandoer);
    if (valg == 0) {
      objekt = sted.kista().taUt();
      ryggsekk.leggInn(objekt);
      bruker.giStatus("Plukker opp gjenstand");
      System.out.println("+" + objekt.navn());
    }
    for (int i = 0; i < terreng.steder.size(); i++) {
      sted = sted.gaaVidere(terreng.steder.get(i).beskriv);
      terreng.steder.remove(i);
    }
  }
}
