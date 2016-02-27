package eventhandler;

/**
*
* @author  Tarun Shimoga
*/


import publisher.Product;
import publisher.Publisher;

public class PublishEvent extends Event {

	private Product product;

	public PublishEvent(Product product) {
		super(EventType.PUBLISH);
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
