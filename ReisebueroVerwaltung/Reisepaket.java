import java.util.Date;

public class Reisepaket {

  private int id;
  private Date startdatum;
  private Date enddatum;
  private int anzahl_tage;
  private String destination;
  private Kunde verkauft_an = null;

  public Reisepaket(int id) {
    this.id = id;
  }
  
  public Reisepaket(String destination, Date startdatum, Date enddatum) {
    this.destination = destination;
    this.startdatum = startdatum;
    this.enddatum = enddatum;
  }

  public Reisepaket(int id, String destination, Date startdatum, Date enddatum) {
    this.id = id;
    this.destination = destination;

    this.startdatum = startdatum;
    this.enddatum = enddatum;
  }
  
  public String toString() {
    return id + ":" + destination + ", " + startdatum.getDate() +"."+ (startdatum.getMonth()+1)
      +"." + (startdatum.getYear()+1900) + "-" + enddatum.getDate() +"."+ (enddatum.getMonth()+1)
      +"." + (enddatum.getYear()+1900);
  }

  public Date getStartdatum() {
    return startdatum;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getIdAsString() {
    return "" + id;
  }

  public boolean equals(Object obj) {
    if (obj instanceof Reisepaket) {
      Reisepaket rp = (Reisepaket) obj; // type casting
      if (id == rp.getId()) {
        return true;
      }
    } 
    return false;
  }
}