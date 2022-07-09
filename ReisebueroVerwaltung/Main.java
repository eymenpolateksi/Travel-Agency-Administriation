import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Character;
import java.util.Date;

public class Main {

  public static void main(String[] args) {

    Reisebuero rb = new Reisebuero();
 
    Scanner sc = new Scanner(System.in);

    int operation = 0;
    String id, name, nn;
    while (operation != 100) {

      System.out.println("Welche Operation moechten Sie durchfuehren?");
      System.out.println("  1- Mitarbeiter hinzufuegen");
      System.out.println("  2- Mitarbeiter auflisten");

      System.out.println("  3- Kunde hinzufuegen");
      System.out.println("  4- Kunden auflisten");
      System.out.println("  10- Kunde loeschen");
      
      System.out.println("  5- Reisepaket hinzufuegen");
      System.out.println("  6- Reisepakete auflisten");
      System.out.println("  9- Aktuelle Reisepakete auflisten");
      
      System.out.println("  7- Reisepaket an Kunde verkaufen");
      System.out.println("  8- Reisepakete von Kunde auflisten");
      
      System.out.println("  100 - Programm beenden");

      operation = sc.nextInt();
      switch (operation) {
        case 1:
          System.out.println("Geben Sie die ID des Mitarbeiters ein");
          id = sc.next();
          try {
            Person.checkIfIdValid(id);
            System.out.println("Geben Sie den Namen ein");
            name = sc.next();
            System.out.println("Geben Sie den Nachnamen ein");
            nn = sc.next();
            System.out.println("Geben Sie den Gehalt ein");
            double g = sc.nextDouble();

            Mitarbeiter m = new Mitarbeiter(id,name,nn);
            m.setGehalt(g);
            rb.addMitarbeiter(m);
          } catch (InvalidIDException e) {
            System.out.println(e.getMessage());
          }
          break;
        case 2:
          rb.printMitarbeiter();
          break;
        case 3:
          System.out.println("Geben Sie die ID des Kunden ein");
          id = sc.next();
          try {
            Person.checkIfIdValid(id);
            System.out.println("Geben Sie den Namen ein");
            name = sc.next();
            System.out.println("Geben Sie den Nachnamen ein");
            nn = sc.next();
            rb.addKunde(new Kunde(id, name,nn));
          } catch (InvalidIDException e) {
            System.out.println(e.getMessage());
          }
          break;
        case 4:
          rb.printKunden();
          break;
        case 5:
          System.out.println("Geben Sie eine Destination ein");
          String d = sc.next();
          System.out.println("Geben Sie einen Startdatum ein (dd.mm.yyyy)");
          String sd = sc.next();
          System.out.println("Geben Sie einen Enddatum ein (dd.mm.yyyy)");
          String ed = sc.next();

          if (sd.length() == 10 && ed.length() == 10) {
            try {
              int tag = Integer.parseInt(sd.substring(0, 2));
              int monat = Integer.parseInt(sd.substring(3, 5)) - 1;
              int jahr = Integer.parseInt(sd.substring(6, 10)) - 1900;
              Date startdatum = new Date(jahr, monat, tag);

              tag = Integer.parseInt(ed.substring(0, 2));
              monat = Integer.parseInt(ed.substring(3, 5)) - 1;
              jahr = Integer.parseInt(ed.substring(6, 10)) - 1900;
              Date enddatum = new Date(jahr, monat, tag);

              Reisepaket rp = new Reisepaket(d, startdatum, enddatum);
              rb.addReisepaket(rp);
            } catch (NumberFormatException e) {
              System.out.println("Geben Sie gueltige Daten ein!");
            }
          } else {
            System.out.println("Geben Sie die Daten im angegeben Format ein.");
          }
          break;
        case 6:
          rb.printAlleReisepakete();
          break;
        case 7:
          System.out.println("Geben Sie eine Kunde-ID ein:");
          String kid = sc.next();
          System.out.println("Geben Sie eine Reisepaket-ID ein:");
          String rpid = sc.next();
          
          Kunde k = rb.getKunde(kid);
          if (k == null) {
            System.out.println("Kunde mit dieser ID existiert nicht.");
          }

          Reisepaket rp = rb.getReisepaket(Integer.parseInt(rpid));
          if (rp == null) {
            System.out.println("Reisepaket mit dieser ID existiert nicht.");
          }

          if (k != null && rp != null) {
            rb.verkaufeReisepaket(kid, Integer.parseInt(rpid));
          }
          break;
        case 8:
          System.out.println("Geben Sie eine Kunde-ID ein:");
          String kid2 = sc.next();

          Kunde k2 = rb.getKunde(kid2);
          if (k2 == null) {
            System.out.println("Kunde mit dieser ID existiert nicht.");
          } else {
            k2.printReisepakete();
          }
          break;
        case 9:
          rb.printAktuelleReisepakete();
          break;
        case 10:
          System.out.println("Geben Sie eine Kunde-ID ein:");
          String kid3 = sc.next();

          Kunde k3 = rb.getKunde(kid3);
          if (k3 == null) {
            System.out.println("Kunde mit dieser ID existiert nicht.");
          } else {
            rb.deleteKunde(kid3);
          }
          break;
      }

    }

  }

}