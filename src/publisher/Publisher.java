package publisher;

/**
*
* @author  Tarun Shimoga
*/


import java.io.FileNotFoundException;
import java.util.List;

import eventhandler.Event;

public interface Publisher {

	
	public abstract void publish(Product product) throws FileNotFoundException, Exception;
	public abstract List<Product> getProducts();

}
