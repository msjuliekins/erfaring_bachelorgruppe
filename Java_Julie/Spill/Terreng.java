import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Terreng {
  ArrayList<Sted> steder;
  Sted sted;

  public Terreng() {
    File fil = new File("steder.txt");
  	Scanner scanner = null;
   	try {
    			scanner = new Scanner(fil);
    }
    catch(FileNotFoundException a){
    		System.out.print("Finner ikke filen");
        return;
    }
    steder = new ArrayList<Sted>();
    sted = new Sted(scanner.nextLine());
    steder.add(sted);
    while (scanner.hasNextLine()) {
      sted = sted.gaaVidere(scanner.nextLine());
      steder.add(sted);
    }
    scanner.close();
  }

  public Sted hentStart() {
    return steder.get(0);
  }
}
