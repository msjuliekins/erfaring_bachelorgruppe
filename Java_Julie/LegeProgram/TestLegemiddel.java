//oppretter en test av legemiddel klassen
class TestLegemiddel {
  //oppretter metoden main
  //oppretter en instans av alle subklasser og tester disse
  }
  public static void main(String[] args) {
    Narkotisk nar = new Narkotisk("Predizol", 450, 75, 8);
    System.out.println("ID: " + nar.hentId() + " " +
                       "Navn: " + nar.hentNavn()+ " "+
                       "Pris: " + nar.hentPris()+" "+
                       "Virkestoff: " + nar.hentVirkestoff()+ " "+
                       "Narkotisk Stryke: " + nar.hentNarkotiskStyrke());
    nar.settNyPris(460);
    System.out.println("Ny pris: " + nar.hentPris());
    System.out.println("");
    Vanedannende vane = new Vanedannende("Paralgin", 65, 400, 5);
    System.out.println("ID: " + vane.hentId()+ " " +
                       "Navn: " + vane.hentNavn()+ " "+
                       "Pris: " + vane.hentPris()+" "+
                       "Virkestoff: " + vane.hentVirkestoff()+" "+
                       "Vanedannende Styrke: " + vane.hentVanedannendeStyrke());
    vane.settNyPris(410);
    System.out.println("Ny pris: " + vane.hentPris());
    System.out.println("");
    Vanlig vanlig = new Vanlig("Ibux", 240, 200);
    System.out.println("ID: " + vanlig.hentId()+" "+
                       "Navn: " + vanlig.hentNavn()+" "+
                       "Pris: " + vanlig.hentPris()+" "+
                       "Virkestoff: " + vanlig.hentVirkestoff());
    vanlig.settNyPris(250);
    System.out.println("Ny pris: " + vanlig.hentPris());
  }
}
