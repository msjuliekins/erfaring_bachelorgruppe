import java.util.Scanner;

class Terminal extends Bruker{
  Scanner scanner;
  String status;

  public Terminal() {
    scanner = new Scanner(System.in);
  }

  @Override
  public int beOmKommando(String spoersmaal, String[] alternativer) {
    System.out.println(spoersmaal);
    System.out.println("Vennligst velg ved hjelp av indeks");
    for (int i = 0; i < alternativer.length; i++) {
      System.out.println(alternativer[i]);
    }
    int valgt = scanner.nextInt();
    return valgt;
  }
}
