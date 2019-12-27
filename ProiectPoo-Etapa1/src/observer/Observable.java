package observer;

public interface Observable {

  public void attach(Observer observer);
  public void detach(Observer observer);
  public void notifyUpdate(Observer observer, String message);
}
