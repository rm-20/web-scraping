import net.dongliu.requests.Requests;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import products.microcenter.Laptop;

public class Main {
	public static void main(String[] args){
		//Requested a url to get a response
		String response = Requests.get("https://www.microcenter.com/category/4294967288/laptops-notebooks").send().readToText();
		//using jsoup to parse the html from the string
		Document doc = Jsoup.parse(response);
		Elements elements = doc.select("ul > li.product_wrapper");
		for(Element element : elements){
			//Creating instance of laptop
			Laptop laptop = new Laptop();

			//getting the item description
			Element a = element.selectFirst("div.normal a");
			laptop.setDescription(a.text());

			//getting the item price
			Element price = element.selectFirst("div.price span[itemprop = price]");
			laptop.setPrice(Double.parseDouble(price.text().replace("$","").replace(",","")));	
			
			System.out.println("Description: " + laptop.getDescription() + 
				" Price: " + laptop.getPrice());		
		}
	}
}