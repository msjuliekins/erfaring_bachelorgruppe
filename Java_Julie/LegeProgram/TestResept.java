//oppretter test av klassen resept
class TestResept {
  //oppretter metoden main
  //oppretter en instans av alle relevante subklasser og tester disse
  public static void main(String[] args) {
    Narkotisk nar = new Narkotisk("Predizol", 450, 75, 8);
    Lege lege = new Lege();
    Hvite hvit = new Hvite(nar, lege, 0, 0);
    System.out.println("Resept ID: " + hvit.hentId() +
                       ", Legemiddel: (" + hvit.hentLegemiddel() +
                       "), Utskrivende Lege: " + hvit.hentLege() +
                       ", Pasient ID: " + hvit.hentPasientId() +
                       ", Reit: " + hvit.hentReit() +
                       " Farge: " + hvit.farge() +
                       ", Pris: " + hvit.prisAaBetale());
    System.out.println("");
    System.out.println("");
    PResept p = new PResept(nar, lege, 1);
    System.out.println("Resept ID: " + p.hentId() +
                       ", Legemiddel: (" + p.hentLegemiddel() +
                       "), Utskrivende Lege: " + p.hentLege() +
                       ", Pasient ID: " + p.hentPasientId() +
                       " Farge: " + p.farge() +
                       ", Pris: " + p.prisAaBetale());
    System.out.println("");
    System.out.println("");
    Militaer mil = new Militaer(nar, lege, 2, 2);
    System.out.println("Resept ID: " + mil.hentId() +
                       ", Legemiddel: (" + mil.hentLegemiddel() +
                       "), Utskrivende Lege: " + mil.hentLege() +
                       ", Pasient ID: " + mil.hentPasientId() +
                       ", Reit: " + mil.hentReit() +
                       " Farge: " + mil.farge() +
                       ", Pris: " + mil.prisAaBetale());
    System.out.println("");
    System.out.println("");
    Blaa blaa = new Blaa(nar, lege, 3, 3);
    System.out.println("Resept ID: " + blaa.hentId() +
                       ", Legemiddel: (" + blaa.hentLegemiddel() +
                       "), Utskrivende Lege: " + blaa.hentLege() +
                       ", Pasient ID: " + blaa.hentPasientId() +
                       ", Reit: " + hvit.hentReit() +
                       ", Farge: " + blaa.farge() +
                       ", Pris: " + blaa.prisAaBetale());
  }
}
