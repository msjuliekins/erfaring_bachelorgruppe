import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


@SuppressWarnings("unchecked")
class VeivalgSpiller extends Spiller {
  int formue;
  Bruker bruker;
  Skattekiste ryggsekk;
  Robot robot;
  Gjenstand objekt;
  VeivalgTerreng terreng;
  VeivalgSted sted;
  Scanner scanner;
  ArrayList<VeivalgSted> valgene;

  public VeivalgSpiller(VeivalgSted startsted, Bruker brukeren) {
    super(startsted, brukeren);
    ryggsekk = new Skattekiste();
    formue = 0;
    bruker = brukeren;
    terreng = new VeivalgTerreng();
    sted  = startsted;
    scanner = new Scanner(System.in);
  }

  public void nyttTrekk() {
    sted.skattekiste();
    valgene = terreng.veiskille();
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
    String[] kommandoer2 = new String[3];
    kommandoer2[0] = "0. Hoeyre";
    kommandoer2[1] = "1. Rett fram";
    kommandoer2[2] = "2. Venstre";
    int valgt = bruker.beOmKommando("Hvor oensker du aa gaa videre?", kommandoer2);

    if (valgt == 0) {
      System.out.println("Gaar til hoeyre");
      sted = valgene.get(0);
    }
    if (valgt == 1) {
      System.out.println("Gaar fram");
      sted = valgene.get(1);
    }
    if (valgt == 2) {
      System.out.println("Gaar til venstre");
      sted = valgene.get(2);
    }
  }
}
