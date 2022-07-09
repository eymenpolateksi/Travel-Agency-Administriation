public class Mitarbeiter extends Person {

  private int mitarbeiter_id;
  private double gehalt;

  public Mitarbeiter(String id) {
    super(id);
  }

  public Mitarbeiter(String id, String name, String nachname) {
    super(id,name,nachname);
  }
  
  public void setMitarbeiterId(int mitarbeiter_id) {
    this.mitarbeiter_id = mitarbeiter_id;
  }

  public void setGehalt(double gehalt) {
    this.gehalt = gehalt;
  }

  public double getGehalt() {
    return this.gehalt;
  }

  
}