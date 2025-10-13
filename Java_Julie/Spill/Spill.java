import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Spill {
  static String resultat;
  static Spiller spiller;
  static VeivalgSpiller spilleren;
  static ArrayList<Spiller> spillere = new ArrayList<Spiller>();
  static ArrayList<VeivalgSpiller> veivalgSpillere = new ArrayList<VeivalgSpiller>();

  public static void main(String[] args) {
     int trekk = 0;
     int ant_fysLaget = 0;
     int ant_robLaget = 0;
     //Terminal terminal = new Terminal();
     Scanner scanner = new Scanner(System.in);
     System.out.println("Hvor mange fysiske spillere oensker du?");
     int ant_fys = scanner.nextInt();
     System.out.println("Hvor mange roboter oensker du aa spille mot?");
     int ant_rob = scanner.nextInt();
     System.out.println("Oensker du enkel vei eller veivalg?");
     System.out.println("0. Enkel vei");
     System.out.println("1. Veivalg");
     System.out.println("Vennligst bruk indeks");
     int valgt = scanner.nextInt();
     if (valgt == 0) {
       Terreng terreng = new Terreng();
       Sted sted = terreng.hentStart();
       while (ant_fysLaget < ant_fys) {
         System.out.println("Spiller " + ant_fysLaget + " utfoerer handling");
         Terminal terminal = new Terminal();
         Spiller fys = new Spiller(sted, terminal);
         fys.nyttTrekk();
         ant_fysLaget++;
         System.out.println("Spiller: " + ant_robLaget + ", Formue: " + fys.formue);
         System.out.println();
         System.out.println();
       }
       while (ant_robLaget < ant_rob){
         System.out.println("Robot " + ant_robLaget + " utfoerer handling");
         Robot robot = new Robot();
         Spiller rob = new Spiller(sted, robot);
         rob.nyttTrekk();
         ant_robLaget++;
         System.out.println("Robot: " + ant_robLaget + ", Formue: " + rob.formue);
         System.out.println();
         System.out.println();
       }
     }
     else {
       VeivalgTerreng terrenget = new VeivalgTerreng();
       VeivalgSted stedet = terrenget.hentStart();
       while (ant_fysLaget < ant_fys) {
         System.out.println("Spiller " + ant_fysLaget + " utfoerer handling");
         Terminal terminal = new Terminal();
         VeivalgSpiller fys = new VeivalgSpiller(stedet, terminal);
         fys.nyttTrekk();
         ant_fysLaget++;
         System.out.println("Spiller: " + ant_robLaget + ", Formue: " + fys.formue);
         System.out.println();
         System.out.println();
       }
       while (ant_robLaget < ant_rob){
         System.out.println("Robot " + ant_robLaget + " utfoerer handling");
         Robot robot = new Robot();
         VeivalgSpiller rob = new VeivalgSpiller(stedet, robot);
         rob.nyttTrekk();
         ant_robLaget++;
         System.out.println("Robot: " + ant_robLaget + ", Formue: " + rob.formue);
         System.out.println();
         System.out.println();
       }
       //resultat = "Spiller: " + navn + ", Formue: " + spilleren.formue;
     }
  }
}
