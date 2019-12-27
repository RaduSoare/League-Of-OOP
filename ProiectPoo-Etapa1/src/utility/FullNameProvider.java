package utility;

public class FullNameProvider {

  public static String getFullName(String type) {
    switch(type) {
      case "P": return "Pyromancer";
      case "K": return "Knight";
      case "W": return "Wizard";
      case "R": return "Rogue";
      default: return null;
    }
  }
}
