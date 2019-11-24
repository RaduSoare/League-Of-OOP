package common;

public class WConstants {

  static final int WIZARD_HP = 400;
  static final int WIZARD_BONUS_HP = 30;
  static final float DRAIN_PERCENT = 0.2f;
  static final float DRAIN_PERCENT_BONUS = 0.05f;
  static final float DEFLECT_PERCENT = 0.35f;
  static final float DEFLECT_PERCENT_BONUS = 0.02f;
  static final float MAX_DEFLECT = 0.7f;
  static final float WIZARD_LAND_MODIFIER = 1.1f;

  static final float DRAIN_R_MODIFIER = 0.8f;
  static final float DRAIN_K_MODIFIER = 1.2f;
  static final float DRAIN_P_MODIFIER = 0.9f;
  static final float DRAIN_W_MODIFIER = 1.05f;

  static final float DEFLECT_R_MODIFIER = 1.2f;
  static final float DEFLECT_K_MODIFIER = 1.4f;
  static final float DEFLECT_P_MODIFIER = 1.3f;
  static final float DEFLECT_W_MODIFIER = 0f;


  public static float getDeflectPercent() {
    return DEFLECT_PERCENT;
  }
  public static float getDeflectPercentBonus() {
    return DEFLECT_PERCENT_BONUS;
  }
  public static float getMaxDeflect() {
    return MAX_DEFLECT;
  }
  public static float getWizardLandModifier() {
    return WIZARD_LAND_MODIFIER;
  }
  public static float getDrainRModifier() {
    return DRAIN_R_MODIFIER;
  }
  public static float getDrainKModifier() {
    return DRAIN_K_MODIFIER;
  }
  public static float getDrainPModifier() {
    return DRAIN_P_MODIFIER;
  }
  public static float getDrainWModifier() {
    return DRAIN_W_MODIFIER;
  }
  public static float getDeflectRModifier() {
    return DEFLECT_R_MODIFIER;
  }
  public static float getDeflectKModifier() {
    return DEFLECT_K_MODIFIER;
  }
  public static float getDeflectPModifier() {
    return DEFLECT_P_MODIFIER;
  }
  public static float getDeflectWModifier() {
    return DEFLECT_W_MODIFIER;
  }
  public static float getDrainPercent() {
    return DRAIN_PERCENT;
  }
  public static float getDrainPercentBonus() {
    return DRAIN_PERCENT_BONUS;
  }
  public static int getWizardHp() {
    return WIZARD_HP;
  }
  public static int getWizardBonusHp() {
    return WIZARD_BONUS_HP;
  }


}
