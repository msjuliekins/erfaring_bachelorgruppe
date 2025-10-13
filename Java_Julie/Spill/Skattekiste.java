import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class Skattekiste {
  Lenkeliste<Gjenstand> gjenstander = new Lenkeliste<Gjenstand>();
  Random random;

  public Skattekiste() {
    File fil = new File("gjenstander.txt");
  	Scanner scanner = null;
   	try {
    			scanner = new Scanner(fil);
    }
    catch(FileNotFoundException a){
    		System.out.print("Finner ikke filen");
        return;
    }
    ArrayList<String> fyll = new ArrayList<String>();
    while (scanner.hasNextLine()) {
      fyll.add(scanner.nextLine());
    }
    scanner.close();
    random = new Random();
    for (int i = 0; i < 5; i++) {
      String linje = fyll.get(random.nextInt(fyll.size()));
      String[] innlest = linje.split(" ");
      Gjenstand gjenstand = new Gjenstand(innlest[0], Integer.parseInt(innlest[1]));
      gjenstander.leggTil(gjenstand);
    }
  }

  public Gjenstand taUt() {
    Gjenstand tattUt = null;
    for (int i = 0; i < 10; i++) {
      if (gjenstander.stoerrelse() > 0) {
        tattUt = gjenstander.fjern(random.nextInt(gjenstander.stoerrelse()));
        return tattUt;
      }
    }
    return tattUt;
  }

  public int leggInn(Gjenstand objekt) {
    int verdi = 0;
    if (gjenstander.stoerrelse() == 10) {
      System.out.println("Ryggsekken er full");
    }
    else {
      gjenstander.leggTil(objekt);
      if (objekt.verdi()%4 == 0) {
        verdi = objekt.verdi() + random.nextInt(5);
      }
      else {
        verdi = objekt.verdi() - random.nextInt(5);
      }
    }
    return verdi;
  }
}
