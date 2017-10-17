import java.io.IOException;
import java.net.URL;

import org.json.JSONObject;

import ecs161.querying.jira.util.Util;

public class GithubQuerier {
	
	private static final String token =  "628c335763aba0e2d80361c0a1be3bc5f4f589f4";
	
	public static void main(String[] args) throws IOException {
		GithubQuerier q = new GithubQuerier(args[0], args[1]);
		
		
		System.out.println(q.query(args[1]));
		
		GithubQuerier q2 = new GithubQuerier(args[2], args[3]);
		
		System.out.println(q2.query(args[3]));
		
//		for (String a : args)
//		{
//			System.out.println(a);
//		}
	}
	
	public String query(String userName) throws IOException {
		int pullRequests = 0 ;
		int mergeRequests = 0;
	
		
		return pullRequests + " " + mergeRequests;
	}
	public GithubQuerier(String account, String name) throws IOException{
		String baseURL = "https://api.github.com/repos/";
		String projectName = name;
		String accountName = account;
		
		URL url = new URL(baseURL + accountName + "/" + projectName + "?access_token" + token);
		JSONObject json = Util.queryURL(url);
		
	}

}
