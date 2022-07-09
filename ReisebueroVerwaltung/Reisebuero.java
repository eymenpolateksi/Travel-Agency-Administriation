import java.util.ArrayList;
import java.util.Date;

public class Reisebuero implements ReisebueroSchnittstelle {

  private ArrayList<Mitarbeiter> mitarbeiter = new ArrayList();
  private ArrayList<Kunde> kunden = new ArrayList();
  private ArrayList<Reisepaket> reisepakete = new ArrayList();
  private int rp_counter = 0;
  
  public void addKunde(Kunde k) {
    kunden.add(k);
  }

  public void addMitarbeiter(Mitarbeiter m) {
    mitarbeiter.add(m);
  }
  
  public void addReisepaket(Reisepaket rp) {
    rp.setId(rp_counter + 1);
    rp_counter++;
    reisepakete.add(rp);
  }

  public void deleteKunde(String id) {
    int i = kunden.indexOf(new Kunde(id));
    if (i != -1) {
      kunden.remove(i);
    }
  }

  public void deleteKunde(Kunde k) {
    kunden.remove(k);
  }
  
  public Kunde getKunde(String id) {
    int i = kunden.indexOf(new Kunde(id));
    if (i == -1) {
      return null;
    } else {
      return kunden.get(i);
    }
  }
  
  public Mitarbeiter getMitarbeiter(String id) {
    int i = mitarbeiter.indexOf(new Mitarbeiter(id));
    if (i == -1) {
      return null;
    } else {
      return mitarbeiter.get(i);
    }
  }
  
  public Reisepaket getReisepaket(int id) {
    int i = reisepakete.indexOf(new Reisepaket(id));
    if (i == -1) {
      return null;
    } else {
      return reisepakete.get(i);
    }
  }

  public void printKunden() {
    for (int i = 0; i < kunden.size(); i++) {
      System.out.println(kunden.get(i));
    }
  }

  public void printMitarbeiter() {
    for (int i = 0; i < mitarbeiter.size(); i++) {
      System.out.println(mitarbeiter.get(i));
    }
  }
  
  public void printAlleReisepakete() {
    for (int i = 0; i < reisepakete.size(); i++) {
      System.out.println(reisepakete.get(i));
    }
  }

  public void printAktuelleReisepakete() {
    Date bugun = new Date();
    for (int i = 0; i < reisepakete.size(); i++) {
      Reisepaket k2 = reisepakete.get(i); 
      if (bugun.before(k2.getStartdatum()) == true) {
        System.out.println(k2);
      } 
    }
  }

  public void verkaufeReisepaket(String kunde_id, int rp_id) {
    int ii = kunden.indexOf(new Kunde(kunde_id));
    if (ii != -1) {
        int jj = reisepakete.indexOf(new Reisepaket(rp_id));
        if (jj != -1) {
            kunden.get(ii).addReisepaket(reisepakete.get(jj));
        } 
    } 
  }
}