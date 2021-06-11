import net.dongliu.requests.Requests;

public class Main {
	public static void main(String[] args){
		System.out.println("Hello World");
		String response = Requests.get("https://microcenter.com").send().readToText();
		System.out.println(response);
	}
}