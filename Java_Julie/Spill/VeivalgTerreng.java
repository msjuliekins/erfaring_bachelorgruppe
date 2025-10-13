import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


@SuppressWarnings("unchecked")
class VeivalgTerreng extends Terreng{
  VeivalgSted sted;
  ArrayList<VeivalgSted> steder;
  ArrayList<VeivalgSted> random;
  Random rand;

  public VeivalgTerreng() {
    File fil = new File("steder.txt");
  	Scanner scanner = null;
   	try {
    			scanner = new Scanner(fil);
    }
    catch(FileNotFoundException a){
    		System.out.print("Finner ikke filen");
        return;
    }
    steder = new ArrayList<VeivalgSted>();
    sted = new VeivalgSted(scanner.nextLine());
    steder.add(sted);
    while (scanner.hasNextLine()) {
      sted = new VeivalgSted(scanner.nextLine());
      steder.add(sted);
    }
  }

  public VeivalgSted hentStart() {
    return steder.get(0);
  }

  public ArrayList veiskille() {
    rand = new Random();
    random = sted.gaaVidere(steder.get(rand.nextInt(steder.size())).beskrive, steder.get(rand.nextInt(steder.size())).beskrive, steder.get(rand.nextInt(steder.size())).beskrive);
    return random;
  }
}
