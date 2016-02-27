package eventhandler;

/**
*
* @author  Tarun Shimoga
*/



import publisher.Product;
import subscriber.Subscription;

public interface EventService {

	
	
	public void publish(Product product) throws Exception;
	
	public void subscribe(Subscription subscription) throws Exception;
	
	public void unsubscribe(Subscription subscription) throws Exception;

}
