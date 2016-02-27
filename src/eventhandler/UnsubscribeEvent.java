package eventhandler;

/**
*
* @author  Tarun Shimoga
*/


import subscriber.Subscription;

public class UnsubscribeEvent extends Event {

	private Subscription subscription;

	public UnsubscribeEvent(Subscription subscription) {
		super(EventType.UNSUBSCRIBE);
		this.subscription = subscription;
	}	
	
	
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}


}
