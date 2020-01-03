package angels;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;
import player.Knight;
import player.Pyromancer;
import player.Rogue;
import player.Wizard;

public abstract class Angel implements Observable {
  private int xCoordinate;
  private int yCoordinate;
  private String type;

  private ArrayList<Observer> observers = new ArrayList<>();

  public Angel(final int xCoordinate, final int yCoordinate, final String type) {
    super();
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.type = type;
  }

  public final int getxCoordinate() {
    return xCoordinate;
  }

  public final void setxCoordinate(final int xCoordinate) {
    this.xCoordinate = xCoordinate;
  }

  public final int getyCoordinate() {
    return yCoordinate;
  }

  public final void setyCoordinate(final int yCoordinate) {
    this.yCoordinate = yCoordinate;
  }

  public final String getType() {
    return type;
  }

  public final void setType(final String type) {
    this.type = type;
  }

  public abstract void buff(Pyromancer pyromancer);
  public abstract void buff(Knight knight);
  public abstract void buff(Wizard wizard);
  public abstract void buff(Rogue rogue);

  @Override
  public final void notifyUpdate(final Observer observer, final String message) {
    observer.update(message);
  }
  @Override
  public final void attach(final Observer observer) {
    observers.add(observer);
  }
  @Override
  public final void detach(final Observer observer) {
    observers.remove(observer);
  }

}
