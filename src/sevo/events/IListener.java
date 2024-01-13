package sevo.events;
@FunctionalInterface
public interface IListener {

    public void handle(Event event);
}
