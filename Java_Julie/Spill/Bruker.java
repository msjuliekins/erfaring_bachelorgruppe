import java.util.Random;

abstract class Bruker implements Brukergrensesnitt{

  public Bruker() {

  }

  public void giStatus(String status) {
    status = status;
    System.out.println(status);
  }

  public int beOmKommando(String spoersmaal, String[] alternativer) {
    System.out.println(spoersmaal);
    for (int i = 0; i < alternativer.length; i++) {
      System.out.println(alternativer[i]);
    }
    Random random = new Random();
    int valgt = random.nextInt(alternativer.length);
    return valgt;
  }
}
