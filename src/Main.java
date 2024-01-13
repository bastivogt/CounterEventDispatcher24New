import sevo.events.Event;
import sevo.events.IEvent;
import sevo.events.IListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Counter counter = new Counter();


        // with anonymous class
        counter.addListener(CounterEvent.COUNTER_START, new IListener() {
            @Override
            public void handle(Event event) {
                var counterEvent = (CounterEvent) event;
                var c = (Counter) counterEvent.getSender();
                System.out.println(counterEvent.getType() + " count: " + c.getCount() + " name: " + counterEvent.getName());
            }
        });

        // with lambda expression
        counter.addListener(CounterEvent.COUNTER_CHANGE, (Event event) -> {
            var counterEvent = (CounterEvent) event;
            var c = (Counter) counterEvent.getSender();
            System.out.println(counterEvent.getType() + " count: " + c.getCount() + " name: " + counterEvent.getName());
        });

        // with lambda expression
        counter.addListener(CounterEvent.COUNTER_FINISH, (Event event) -> {
            var counterEvent = (CounterEvent) event;
            var c = (Counter) counterEvent.getSender();
            System.out.println(counterEvent.getType() + " count: " + c.getCount() + " name: " + counterEvent.getName());
        });




        counter.run();
    }
}