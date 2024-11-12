class EventManager {
  private HashMap<String, ArrayList<EventListener>> listeners = new HashMap<>();

  void registerEvent(String eventType, EventListener listener) {
    listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
  }

  void triggerEvent(String eventType, Object data) {
    ArrayList<EventListener> eventListeners = listeners.get(eventType);
    if (eventListeners != null) {
      for (EventListener listener : eventListeners) {
        listener.onEvent(eventType, data);
      }
    }
  }
}

interface EventListener {
  void onEvent(String eventType, Object data);
}
