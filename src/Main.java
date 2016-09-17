
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Main {
	public static void main(String[] args) throws IOException {
		String repo="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the url of repository");
		repo=sc.nextLine();
		int i=repo.indexOf(".com/");
		repo=repo.substring(i+4);
		String pulls="https://api.github.com/repos"+repo+"/pulls";
		URL url=new URL(pulls);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
			//System.out.println(inputLine);
		}
		
		String pullreqs=response.toString();
		int start=pullreqs.indexOf("[");
		pullreqs=pullreqs.substring(start+1,pullreqs.length()-1);
		JSONObject json  = new JSONObject(pullreqs);
		System.out.println("Pull Requests");
		System.out.println(json);
		in.close();
		
		String emojis="https://api.github.com/emojis";
		URL url2=new URL(emojis);
		HttpURLConnection con2=(HttpURLConnection) url2.openConnection();
		con2.setRequestMethod("GET");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
		String inputLine2;
		StringBuffer response2 = new StringBuffer();

		while ((inputLine2 = in2.readLine()) != null) {
			response2.append(inputLine2);
			//System.out.println(inputLine);
		}
		String emoji=response2.toString();
		 System.out.println("Emojis: ");
		System.out.println(emoji);
		in.close();
	}

}
