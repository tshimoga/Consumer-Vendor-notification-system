package publisher;

/**
*
* @author  Tarun Shimoga
*/



public class Product {

	private String brandName;

	private String productType;
	
	private Publisher publisher;
	
	
	public Product(String productType) {
		super();
		this.productType = productType;
	}

	public Product(String brandName, String productType) {
		this.brandName = brandName;
		this.productType = productType;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}


	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher Publisher) {
		this.publisher = Publisher;
	}

}
