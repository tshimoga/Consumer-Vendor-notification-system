package eventhandler;

/**
*
* @author  Tarun Shimoga
*/


import java.util.List;

import dao.SubscriptionsDAO;
import dao.SubscriptionsDAOImpl;
import publisher.Product;
import subscriber.Subscriber;
import subscriber.Subscription;

public class EventServiceImpl implements EventService {

	
	private static EventService eventService;

	private EventServiceImpl() {

	}

	public static EventService getInstance() {
		if (eventService == null) {
			eventService = new EventServiceImpl();
		}
		return eventService;
	}

	/**
	 * @throws Exception 
	 * @see EventService#subscribe(Subscription)
	 */
	@Override
	public void subscribe(Subscription subscription) throws Exception {
		SubscriptionsDAO dao = SubscriptionsDAOImpl.getInstance();
		dao.subscribe(subscription);
	}

	/**
	 * @throws Exception 
	 * @see EventService#unsubscribe(Subscription)
	 */
	@Override
	public void unsubscribe(Subscription subscription) throws Exception {
//@begin
		SubscriptionsDAO dao = SubscriptionsDAOImpl.getInstance();
		dao.unsubscribe(subscription);
//@end
	}

	/**
	 * @throws Exception 
	 * @see EventService#publish(Product)
	 */
	@Override
	public void publish(Product product) throws Exception {
//@begin
		SubscriptionsDAO dao = SubscriptionsDAOImpl.getInstance();
		List<Subscriber> subscribers = dao.getSubscribers(product);
		notifySubscribers(subscribers,product);
		

		
	}

	/**
	 * @throws Exception 
	 * @see EventService#handleEvent(Event)
	 */
	
	private void notifySubscribers(List<Subscriber> subscribers, Product product) {
			for(Subscriber s : subscribers) {
				s.notify(product);
			}
		}
//@end
}
