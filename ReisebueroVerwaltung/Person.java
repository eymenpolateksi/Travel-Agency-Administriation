public abstract class Person {

  private String id;
  private String name;
  private String nachname;

  public Person(String id) {
    this.id = id;
  }

  public Person(String id, String name, String nachname) {
    this.id = id;
    this.name = name;
    this.nachname = nachname;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  // Objektmethode
  public String getId() {
    // Objektvariable
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }

  public String getNachname() {
    return this.nachname;
  }

  @Override
  public String toString() {
    return id + " " + name + " " + nachname;
  }

  // Klassenmethode
  public static boolean checkIfIdValid(String s) {
    if (s.length() != 7) {
      throw new InvalidIDException("ID muss aus 7 Ziffern bestehen.");
    }
    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if ( Character.isDigit(c) == false ) {
        throw new InvalidIDException("ID muss nur aus Ziffern bestehen.");
         // return false;
      }
      if (i == 0 && c == '0') {
        // return false;
        throw new InvalidIDException("ID darf nicht mit einer 0 anfangen.");
      }
    }
    return true;
  }

  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      Person k = (Person) obj; // type casting
      if (this.getId().equals(k.getId())) {
        return true;
      }
    } 
    return false;
  }
  
}