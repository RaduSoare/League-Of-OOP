package common.player.strategy;

public final class RogueStrategyConstants {
  private RogueStrategyConstants() {

  }
  // damage strategy constants DS - DamageStrategy
  public static final float DS_LOW_HP_LIMIT = 1 / 7f;
  public static final float DS_HIGH_HP_LIMIT = 1 / 5f;
  public static final float DS_HP_MODIFIER = 1 - 1 / 7f;
  public static final float DS_DMG_MODIFIER = 0.4f;
  // hp strategy constants HS - HpStrategy
  public static final float HS_HIGH_HP_LIMIT = 1 / 7f;
  public static final float HS_HP_MODIFIER = 1 + 1 / 2f;
  public static final float HS_DAMAGE_MODIFIER = -0.1f;
}
