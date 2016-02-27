package subscriber;

/**
*
* @author  Tarun Shimoga
*/


import publisher.Product;

public class Subscription {

	private Subscriber subscriber;

	private Product product;
	

	public Subscription(Subscriber subscriber, Product product) {
//@begin
		super();
		this.subscriber = subscriber;
		this.product = product;

	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	//@end
}
