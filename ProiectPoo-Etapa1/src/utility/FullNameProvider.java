package utility;

public final class FullNameProvider {

  private FullNameProvider() {

  }
  /*
   * Returneaza numele clasei din care face parte un erou pentru notificarea Marelui Magician.
   */
  public static String getFullName(final String type) {
    switch (type) {
      case "P": return "Pyromancer";
      case "K": return "Knight";
      case "W": return "Wizard";
      case "R": return "Rogue";
      default: return null;
    }
  }
}
