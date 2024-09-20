
import java.net.URL;

class ref {
	public ref() {
		try {
			System.out.println("\n YOU CAN REFER THESE SITES FOR MORE INFORMATION!!");
			System.out.println(" TOP SITES FOR YOUR DIET, FOOD AND HEALTH!! \n");
			URL site1 = new URL("http://www.healthifyme.com");// food diet fitness
			URL site2 = new URL("http://www.myfitnesspal.com");// food and fitnes
			URL site3 = new URL("http://www.wellandgood.com"); // food diet
			URL site4 = new URL("http://www.healthline.com"); // fitness
			URL site5 = new URL("http://www.shape.com"); // Fitness
			System.out.println("\t Website: " + site1.toExternalForm());
			System.out.println("\t Website: " + site2.toExternalForm());
			System.out.println("\t Website: " + site3.toExternalForm());
			System.out.println("\t Website: " + site4.toExternalForm());
			System.out.println("\t Website: " + site5.toExternalForm());
			System.out.println("\n Thank You So Much!!!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

public class URLRef
{
	public static void main(String args[])
	{
		ref obj = new ref();
	}
}
