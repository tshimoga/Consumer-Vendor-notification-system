package eventhandler;

/**
*
* @author  Tarun Shimoga
*/

public enum EventType {

	SUBSCRIBE(0,"SUBSCRIBE"), UNSUBSCRIBE(1,"UNSUBSCRIBE"), PUBLISH(2,"PUBLISH");
	private int type;
	private String eventType;
	
	private EventType(int type, String eventType) {
		this.type = type;
		this.eventType = eventType;
	}
	
	public String getEventType(int type) {
		
		switch(type) {
		case 0 : return "SUBSCRIBE";
		case 1 : return "UNSUBSCRIBE";
		case 2 : return "PUBLISH";
		default : return "";
		}
	}

	

}
