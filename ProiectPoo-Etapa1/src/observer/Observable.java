package observer;

public interface Observable {

  void attach(Observer observer);
  void detach(Observer observer);
  void notifyUpdate(Observer observer, String message);
}
