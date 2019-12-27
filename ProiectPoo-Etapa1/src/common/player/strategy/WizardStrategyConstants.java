package common.player.strategy;

public class WizardStrategyConstants {
  // damage strategy constants DS - DamageStrategy
  public static final float DS_LOW_HP_LIMIT = 1/4f;
  public static final float DS_HIGH_HP_LIMIT = 1/2f;
  public static final float DS_HP_MODIFIER = 1 - 1/10f;
  public static final float DS_DMG_MODIFIER = 0.6f;
  // hp strategy constants HS - HpStrategy
  public static final float HS_HIGH_HP_LIMIT = 1/4f;
  public static final float HS_HP_MODIFIER = 1 + 1/5f;
  public static final float HS_DAMAGE_MODIFIER = -0.2f;
}
