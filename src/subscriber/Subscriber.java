package subscriber;

/**
*
* @author  Tarun Shimoga
*/


import java.io.FileNotFoundException;

import publisher.Product;

public interface Subscriber {

	public abstract void subscribe(Product product) throws FileNotFoundException, Exception;

	public abstract void unsubscribe(Product product) throws FileNotFoundException, Exception;
	
	public abstract void notify(Product product);

}
