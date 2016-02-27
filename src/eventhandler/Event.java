package eventhandler;

/**
*
* @author  Tarun Shimoga
*/

public class Event {

	private EventType eventType;
	
	public Event(EventType eventType) {
		super();
		this.eventType = eventType;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
	

}
