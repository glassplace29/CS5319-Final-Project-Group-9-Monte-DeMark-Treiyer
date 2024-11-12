import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public void registerEvent(String eventType, EventListener listener) {
        // Logic to register an event listener
    }

    public void triggerEvent(String eventType, Object eventData) {
        // Logic to trigger an event
    }

    private void dispatchToHandler(String eventType, Object eventData) {
        // Logic to dispatch event data to the correct handler
    }
    
}
