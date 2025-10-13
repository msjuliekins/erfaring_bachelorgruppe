//klassen Lenkeliste<T> som implementerer Liste<T>:
import java.util.Iterator;
class Lenkeliste <T> implements Liste <T>{
  Node start;
  Node slutt;

  public class Node {
    public T innholdet;
    Node neste = null;

    Node (T innholdet){
      this.innholdet = innholdet;
    }
  }
  private class LenkelisteIterator implements Iterator<T> {
    Node ny = start;
    @Override
    public boolean hasNext() {
      return ny != null;
    }
    @Override
    public T next() {
      Node midlertidig = ny;
      ny = ny.neste;
      return midlertidig.innholdet;
    }
  }
//metode stoerrelse:
  public int stoerrelse(){
    int str = 0;
    for (Node n = start; n != null; n = n.neste){
      str ++ ;
    }

    return str;
  }

//erTom:
  public boolean erTom(){
    if(start == null){
      return true;
    }
    return false;
  }

  @Override
//skal legge inn et nytt element i listen og skyve neste element ett hakk lenger bak:
  public void leggTil(int pos, T x){
    Node p = start;
    Node nyNode = new Node(x);

    if(erTom() && pos == 0){
      start = nyNode;
      slutt = nyNode;
      return;
    }
    else if (pos == stoerrelse()){
      slutt.neste = nyNode;
      slutt = nyNode;
      return;
    }
    else if(pos == 0 && !erTom()){
      Node tmp = start;
      start = nyNode;
      start.neste = tmp;
      return;
    }
    else if (pos > stoerrelse() || pos < 0){
      throw new UgyldigListeIndeks(pos);
    }
    else {
      for (int i = 0; i < pos -1; i++){
        p = p.neste;
      }
    Node tmp = p.neste;
    nyNode.neste = tmp;
    p.neste = nyNode;
    }
  }

//skal sette inn et element på slutten av listen:
  public void leggTil(T x){
    Node nyNode = new Node (x);
    if (erTom()){
      start = nyNode;
      slutt = nyNode;
    } else {
      slutt.neste = nyNode;
      slutt = nyNode;
    }
  }

  @Override
//skal sette inn elementet på en gitt posisjon og overskrive det som var der fra før av:
  public void sett(int pos, T x){
    Node p = start;
    // || betyr OR
    if (pos < 0 || pos >= stoerrelse() || erTom()){
      throw new UgyldigListeIndeks(pos);
    }

    if (pos == stoerrelse() - 1){
      slutt.innholdet = x;
      return;
    }

    for (int i = 0; i < pos; i ++){
      p = p.neste;
    }

    p.innholdet = x;
  }

//henter ut et element (uten å fjerne det fra lista)
  public T hent(int pos){
    Node p = start;
    if (pos < 0 || pos >= stoerrelse() || erTom()){
      throw new UgyldigListeIndeks(pos);
    }

    else if (pos == 0 && !erTom()){
      return p.innholdet;
    }
    else {
      for (int i = 0; i < pos; i ++){
        p = p.neste;
      }
    return p.innholdet;
    }
  }

  @Override
// skal fjerne på gitt indeks i listen:
  public T fjern(int pos){
    Node p = start;
    if (pos >= stoerrelse() || pos < 0){
      throw new UgyldigListeIndeks(-1);
    }

    if (pos == 0){
      start = p.neste;
      return p.innholdet;
    }

    if(pos == stoerrelse() - 1){
      for (int i = 0; i < pos -1; i ++){
        p = p.neste;
      }

      T verdi = p.neste.innholdet;
      slutt = p;
      slutt.neste = null;
      return verdi;
    }

    for (int i = 0; i < pos -1; i ++){
      p = p.neste;
    }

    Node n = p.neste;
    if (n != null){
      p.neste = n.neste;
      return n.innholdet;
    }

    return null;
  }

//fjerne og retunere elementet på starten av listen:
  public T fjern(){
    if (erTom()){
      throw new UgyldigListeIndeks(0);
    }

    Node retur = start;
    start = start.neste;
    return retur.innholdet;
    }

  public Iterator<T> iterator() {
    return new LenkelisteIterator();
  }
}
