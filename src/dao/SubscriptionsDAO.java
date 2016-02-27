/**
*
* @author  Tarun Shimoga
*/


package dao;

import java.io.IOException;
import java.util.List;

import publisher.Product;
import subscriber.Subscriber;
import subscriber.Subscription;


public interface SubscriptionsDAO {
	
	public abstract void subscribe(Subscription sub) throws Exception;
	
	public abstract void unsubscribe(Subscription sub) throws Exception;

	public abstract List<Subscriber> getSubscribers(Product product) throws IOException;
	
	
	
}
