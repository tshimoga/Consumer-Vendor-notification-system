package eventhandler;

/**
*
* @author  Tarun Shimoga
*/


import subscriber.Subscription;

public class SubscriptionEvent extends Event {

	private Subscription subscription;

	public SubscriptionEvent(Subscription subscription) {
		super(EventType.SUBSCRIBE);
		this.subscription = subscription;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	
	
	

}
