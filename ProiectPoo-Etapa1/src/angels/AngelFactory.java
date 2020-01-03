package angels;

import angels.types.DamageAngel;
import angels.types.DarkAngel;
import angels.types.Dracula;
import angels.types.GoodBoy;
import angels.types.LevelUpAngel;
import angels.types.LifeGiver;
import angels.types.SmallAngel;
import angels.types.Spawner;
import angels.types.TheDoomer;
import angels.types.XPAngel;

public final class AngelFactory {

  private static AngelFactory instance = null;

  private AngelFactory() { }

  public static AngelFactory getInstance() {
    if (instance == null) {
      instance = new AngelFactory();
    }
    return instance;
  }

  public Angel createAngel(final int x, final int y, final String type) {
    switch (type) {
      case "DamageAngel" : return new DamageAngel(x, y, type);
      case "DarkAngel" : return new DarkAngel(x, y, type);
      case "Dracula" : return new Dracula(x, y, type);
      case "GoodBoy" : return new GoodBoy(x, y, type);
      case "LevelUpAngel" : return new LevelUpAngel(x, y, type);
      case "LifeGiver" : return new LifeGiver(x, y, type);
      case "SmallAngel" : return new SmallAngel(x, y, type);
      case "Spawner" : return new Spawner(x, y, type);
      case "TheDoomer" : return new TheDoomer(x, y, type);
      case "XPAngel" : return new XPAngel(x, y, type);
      default: return null;
    }
  }



}
