import java.util.ArrayList;

class VeivalgSted extends Sted {
  ArrayList<VeivalgSted> liste;
  String beskrive;

  public VeivalgSted(String beskrivelse){ 
    super(beskrivelse);
    this.beskrive = beskrivelse;
  }

  public void skattekiste() {
    this.skatt = new Skattekiste();
  }
  @Override
  public Skattekiste kista() {
    return skatt;
  }

  public ArrayList gaaVidere(String beskrivelse, String beskrivelse2, String beskrivelse3) {
    this.liste = new ArrayList<VeivalgSted>();
    VeivalgSted hoeyre = new VeivalgSted(beskrivelse);
    VeivalgSted fram = new VeivalgSted(beskrivelse2);
    VeivalgSted venstre = new VeivalgSted(beskrivelse3);
    liste.add(hoeyre);
    liste.add(fram);
    liste.add(venstre);
    return liste;
  }
}
