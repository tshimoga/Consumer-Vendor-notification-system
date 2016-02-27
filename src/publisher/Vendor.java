package publisher;

/**
*
* @author  Tarun Shimoga
*/

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eventhandler.Event;
import eventhandler.EventService;
import eventhandler.EventServiceImpl;
import eventhandler.PublishEvent;

public class Vendor implements Publisher {

	private String name;

	private List<Product> products = new ArrayList<Product>();


	public Vendor(String name) {
		super();
		this.name = name;
	}
	

	public Vendor(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 * @see Publisher#publish(Event)
	 */
	@Override
	public void publish(Product product) throws FileNotFoundException, Exception {
		EventServiceImpl.getInstance().publish(product);
	}


	@Override
	public List<Product> getProducts() {
//@begin
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
//@end
}
