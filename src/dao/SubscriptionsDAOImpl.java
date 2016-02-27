package dao;

/**
*
* @author  Tarun Shimoga
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import publisher.Product;
import publisher.Vendor;
import subscriber.Consumer;
import subscriber.Subscriber;
import subscriber.Subscription;

public class SubscriptionsDAOImpl implements SubscriptionsDAO {
	
	//@begin
	private static String SUBSCRIPTIONS_PATH = "src" + File.pathSeparator + "resources" + File.pathSeparator + "subscriptions";
	private static String TEMP_FILE_PATH = "src"+ File.pathSeparator +"resources" + File.pathSeparator + "temp.csv";
	
	private int subscriptionsFileLines = 0;
	private int tempFileLines = 0;

	private static SubscriptionsDAO daoImpl;

	private SubscriptionsDAOImpl() {

	}

	public static SubscriptionsDAO getInstance() {
		if (daoImpl == null) {
			daoImpl = new SubscriptionsDAOImpl();
		}
		return daoImpl;
	}

	private BufferedReader getDataFileReader() throws IOException {
		File f = new File(SUBSCRIPTIONS_PATH);
		if (!f.exists()) {
			f.createNewFile();
		}
		FileInputStream file = new FileInputStream(SUBSCRIPTIONS_PATH);
		BufferedReader br = new BufferedReader(new InputStreamReader(file));
		return br;
	}

	private BufferedWriter getDataFileWriter(String path) throws IOException {
		
		FileOutputStream file = new FileOutputStream(path, true);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(file,
				"UTF-8"));
		return br;
	}

	private boolean consumerAlreadySubscribed(Subscription subscription)
			throws Exception {
		BufferedReader bfr = getDataFileReader();
		boolean subscribed = false;
		String line;
		Consumer c = (Consumer) subscription.getSubscriber();
		Product p = subscription.getProduct();
		while ((line = bfr.readLine()) != null) {
			String consumerName = line.split(",")[0];
			String productType = line.split(",")[1];

			if (consumerName.equalsIgnoreCase(c.getName())
					&& p.getProductType().equalsIgnoreCase(productType)) {
				subscribed = true;
				break;
			}
		}
		bfr.close();
		return subscribed;
	}

	private static void overwriteTempFile() {
		File file = new File(TEMP_FILE_PATH);
		File oldFile = new File(SUBSCRIPTIONS_PATH);
		oldFile.delete();
		file.renameTo(new File(SUBSCRIPTIONS_PATH));
	}
 //@end
	@Override
	public void subscribe(Subscription subscription) throws Exception {
//@begin
		if (!consumerAlreadySubscribed(subscription)) {
			Consumer c = (Consumer) subscription.getSubscriber();
			String subscriptionEntry = c.getName() + ","
					+ subscription.getProduct().getProductType();
			BufferedWriter br = getDataFileWriter(SUBSCRIPTIONS_PATH);
			if (subscriptionsFileLines != 0) {
				br.newLine();
			}

			br.append(subscriptionEntry);
			br.flush();
			br.close();
			subscriptionsFileLines++;
		}
//@end
	}

	@Override
	public void unsubscribe(Subscription subscription) throws Exception {
//@begin
		if (consumerAlreadySubscribed(subscription)) {
			Consumer c = (Consumer) subscription.getSubscriber();
			BufferedReader reader = getDataFileReader();
			BufferedWriter writer = getDataFileWriter(TEMP_FILE_PATH);
			String line;
			while ((line = reader.readLine()) != null) {
				if (line != null && !line.isEmpty()) {
					String consumer = line.split(",")[0];
					String productType = line.split(",")[1];
					if (!consumer.equalsIgnoreCase(c.getName())
							|| !productType.equalsIgnoreCase(subscription.getProduct()
									.getProductType())) {
						if (tempFileLines != 0) {
							writer.newLine();
						}

						writer.append(line);
						writer.flush();
						tempFileLines++;
					}
				}
			}

			subscriptionsFileLines = tempFileLines;
			writer.close();
			reader.close();
			overwriteTempFile();
		}
//@end
	}

	
	 
	 @Override
	public List<Subscriber> getSubscribers(Product product) throws IOException {
//@begin
		List<Subscriber> subscribers = new ArrayList<Subscriber>();

		BufferedReader bfr = getDataFileReader();
		String line;
		while ((line = bfr.readLine()) != null) {
			String consumer = line.split(",")[0];
			String productType = line.split(",")[1];

			if (productType.equalsIgnoreCase(product.getProductType())) {
				subscribers.add(new Consumer(consumer));
			}
		}

		bfr.close();
		return subscribers;
	}
//@end

}
