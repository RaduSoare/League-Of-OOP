package common;

public class RConstants {
  static final int ROGUE_HP = 600;
  static final int ROGUE_BONUS_HP = 40;
  static final int BACKSTAB_DAMAGE = 200;
  static final int BACKSTAB_DAMAGE_BONUS = 20;
  static final float CRITICAL_BONUS = 1.5f; // doar pe woods
  static final int PARALYSIS_DAMAGE = 40;
  static final int PARALYSIS_DAMAGE_BONUS = 10;
  static final int PARALYSIS_OVERTIME = 3;
  static final float ROGUE_LAND_MODIFIER = 1.15f;

  static final float BACKSTAB_R_MODIFIER = 1.2f;
  static final float BACKSTAB_K_MODIFIER = 0.9f;
  static final float BACKSTAB_P_MODIFIER = 1.25f;
  static final float BACKSTAB_W_MODIFIER = 1.25f;

  static final float PARALYSIS_R_MODIFIER = 0.9f;
  static final float PARALYSIS_K_MODIFIER = 0.8f;
  static final float PARALYSIS_P_MODIFIER = 1.2f;
  static final float PARALYSIS_W_MODIFIER = 1.25f;



  public static float getBackstabRModifier() {
    return BACKSTAB_R_MODIFIER;
  }
  public static float getBackstabKModifier() {
    return BACKSTAB_K_MODIFIER;
  }
  public static float getBackstabPModifier() {
    return BACKSTAB_P_MODIFIER;
  }
  public static float getBackstabWModifier() {
    return BACKSTAB_W_MODIFIER;
  }
  public static float getParalysisRModifier() {
    return PARALYSIS_R_MODIFIER;
  }
  public static float getParalysisKModifier() {
    return PARALYSIS_K_MODIFIER;
  }
  public static float getParalysisPModifier() {
    return PARALYSIS_P_MODIFIER;
  }
  public static float getParalysisWModifier() {
    return PARALYSIS_W_MODIFIER;
  }
  public static int getRogueHp() {
    return ROGUE_HP;
  }
  public static int getRogueBonusHp() {
    return ROGUE_BONUS_HP;
  }
  public static int getBackstabDamage() {
    return BACKSTAB_DAMAGE;
  }
  public static int getBackstabDamageBonus() {
    return BACKSTAB_DAMAGE_BONUS;
  }
  public static float getCriticalBonus() {
    return CRITICAL_BONUS;
  }
  public static int getParalysisDamage() {
    return PARALYSIS_DAMAGE;
  }
  public static int getParalysisDamageBonus() {
    return PARALYSIS_DAMAGE_BONUS;
  }
  public static int getParalysisOvertime() {
    return PARALYSIS_OVERTIME;
  }
  public static float getRogueLandModifier() {
    return ROGUE_LAND_MODIFIER;
  }

}
