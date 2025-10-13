// Hovedprogram-klassen:
class Hovedprogram{
  public static void main(String[] args) {

// Lager en objekt av alle klassene
    Spesialist sp = new Spesialist("Dr.Kaja", 2);
    Leger lege1 = new Leger ("Dr. Wilson");
    Leger lege2 = new Leger ("Dr.Jhon");
    Vanlig c = new Vanlig ("Paracet",200, 20);
    Vanedannende b = new Vanedannende("Voltarol",300,4,5);
    Narkotisk a = new Narkotisk("Ibux", 19, 30, 4);
    BlaaResepter blaa = new BlaaResepter(a,lege1,2,4);
    HviteResepter hvit = new HviteResepter(b,sp, 4,7);
    MiliterResepter mil = new MiliterResepter(c,lege1, 3,3);
    PResepter pre = new PResepter(a,lege1, 4);
    MiliterResepter mil1 = new MiliterResepter(c,sp, 8,0);

//Printer ut Spesialist ut til terminalen:
    System.out.println(sp);
//Printer Narkotisk:
    System.out.println(a);
//med styrken til Narkotisk:
    System.out.println("Styrke : " + a.hentNarkotiskStyrke());
//Printer Vanedannende:
    System.out.println(b);
//Printer Vanlig:
    System.out.println(c);
//har denne med to ganger for å teste om man fortsatt får samme id nummer:
    System.out.println(a);
    System.out.println("Styrke : " + a.hentNarkotiskStyrke());
    System.out.println(b);
//med styrken til Vanedannende:
    System.out.println("Styrke : " + b.hentVanedannedeStyrke());
//printer BlaaResepter:
    System.out.println(blaa.toString());
//printer HviteResepter:
    System.out.println(hvit.toString());
//printer MiliterResepter:
    System.out.println(mil.toString());
//printer PResepter:
    System.out.println(pre.toString());
//Printer MiliterResepter:
    System.out.println(mil1);
  }
}
