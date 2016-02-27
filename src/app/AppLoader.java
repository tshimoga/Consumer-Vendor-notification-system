/**
*
* @author  Tarun Shimoga
*/


package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import publisher.Product;
import publisher.Publisher;
import publisher.Vendor;
import subscriber.Consumer;
import subscriber.Subscriber;
import subscriber.Subscription;
import eventhandler.Event;
import eventhandler.EventService;
import eventhandler.EventServiceImpl;
import eventhandler.PublishEvent;
import eventhandler.SubscriptionEvent;
import eventhandler.UnsubscribeEvent;

//@begin
public class AppLoader {
	private static String EVENTS_PATH;
	private static String SUBSCRIPTIONS_PATH = "src" + File.pathSeparator + "resources" + File.pathSeparator + "subscriptions";
	private static String USAGE_MESSAGE = "USAGE: java -cp . app.AppLoader <path_input_file>";

	private static void usage() {
		System.out.println(USAGE_MESSAGE);
		System.exit(1);
	}

	private static void processLine(String line) throws Exception {
		String[] str = line.split(",");
		String operation = str[0].trim();
		String productType = str[2].trim();

		Product product = new Product(productType);
		Subscriber consumer;

		if (operation.equalsIgnoreCase("subscribe")) {
			String subscriberName = str[1];
			consumer = new Consumer(subscriberName);
			consumer.subscribe(product);

		} else if (operation.equalsIgnoreCase("unsubscribe")) {
			String unsubscriberName = str[1];
			consumer = new Consumer(unsubscriberName);
			consumer.unsubscribe(product);

		} else {
			String publisherName = str[1].trim();
			String productName = str[3].trim();
			product.setBrandName(productName);
			Publisher publisher = new Vendor(publisherName);
			if (!publisher.getProducts().contains(product)) {
				publisher.getProducts().add(product);
			}
			product.setPublisher(publisher);
			publisher.publish(product);

		}

	}

	public static void deleteSubscriptionsFile() {
		File file = new File(SUBSCRIPTIONS_PATH);
		file.delete();

	}

	private static void readInputFile() throws Exception {
		FileInputStream file = new FileInputStream(EVENTS_PATH);

		BufferedReader br = new BufferedReader(new InputStreamReader(file));

		String line;
		while ((line = br.readLine()) != null) {
			processLine(line);
		}

		br.close();
	}

	public static void main(String[] args) throws Exception {
		if (args.length < 1) {
			usage();
		}
		EVENTS_PATH = args[0];
		readInputFile();
		deleteSubscriptionsFile();

	}

}
//@end