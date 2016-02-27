package subscriber;

/**
*
* @author  Tarun Shimoga
*/


import java.io.FileNotFoundException;

import publisher.Product;
import publisher.Vendor;
import eventhandler.Event;
import eventhandler.EventService;
import eventhandler.EventServiceImpl;
import eventhandler.SubscriptionEvent;
import eventhandler.UnsubscribeEvent;

public class Consumer implements Subscriber {

	private String name;
	
	


	public Consumer(String name) {
		super();
		this.name = name;
	}
	
	private EventService getEventService() {
		return EventServiceImpl.getInstance();
	}


	/**
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 * @see Subscriber#subscribe(Event)
	 */
	public void subscribe(Product product) throws FileNotFoundException, Exception {
		
		Subscription subscription = new Subscription(this, product);
		getEventService().subscribe(subscription);

	}


	/**
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 * @see Subscriber#unsubscribe(Event)
	 */
	public void unsubscribe(Product product) throws FileNotFoundException, Exception {
		Subscription subscription = new Subscription(this, product);
		getEventService().unsubscribe(subscription);
	}
	
	public void notify(Product product) {
		Vendor v = (Vendor) product.getPublisher();
		System.out.println(this.getName().toLowerCase() + " notified of " + product.getBrandName().toLowerCase() + " from " + v.getName().toLowerCase());
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
