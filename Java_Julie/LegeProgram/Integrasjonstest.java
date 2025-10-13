//oppretter integrasjonstesten
class Integrasjonstest {
  //oppretter main-medoten
  //oppretter og tester instanser av alle klasser
  public static void main(String[] args) {
    System.out.println("Info Lege:");
    Lege lege = new Lege("Dr. House");
      System.out.println(lege.toString());
      System.out.println("");
      System.out.println("Info Spesialist:");
    Spesialist spes = new Spesialist("Dr. Cox", 1);
      System.out.println(spes.toString());
      System.out.println("");
      System.out.println("Info Narkotisk Legemiddel:");
    Narkotisk nar = new Narkotisk("Predizol", 450, 75, 8);
      System.out.println(nar.toString());
      System.out.println("");
      System.out.println("Info Hvit Resept:");
    Hvite hvit = new Hvite(nar, spes, 0, 1);
      System.out.println(hvit.toString());
      System.out.println("");
      System.out.println("Info Vanlig Legemiddel:");
    Vanlig vanlig = new Vanlig("Ibux", 240, 200);
      System.out.println(vanlig.toString());
      System.out.println("");
      System.out.println("Info Militaer Resept:");
    Militaer mil = new Militaer(vanlig, lege, 1, 1);
      System.out.println(mil.toString());
      System.out.println("");
      System.out.println("Info Vanlig Legemiddel 2:");
    Vanlig vanlig2 = new Vanlig("Cerazette", 185, 75);
      System.out.println(vanlig2.toString());
      System.out.println("");
      System.out.println("Info P-Resept:");
    PResept pr = new PResept(vanlig2, lege, 2);
      System.out.println(pr.toString());
      System.out.println("");
      System.out.println("Info Vanedannende Legemiddel:");
    Vanedannende van = new Vanedannende("Paralgin Forte", 65, 400, 5);
      System.out.println(van.toString());
      System.out.println("");
      System.out.println("Info Blaa Resept:");
    Blaa blaa = new Blaa(van, lege, 3, 1);
      System.out.println(blaa.toString());

  }
}
