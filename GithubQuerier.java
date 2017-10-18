import java.io.IOException;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONArray;

import ecs161.querying.jira.util.Util;

public class GithubQuerier {
	
	private static final String token =  "628c335763aba0e2d80361c0a1be3bc5f4f589f4";
	private JSONObject jsonObj;
	private JSONArray jsonArr;
	
	public static void main(String[] args) throws IOException {
		GithubQuerier q = new GithubQuerier(args[0], args[1]);
		q.query(args[2]);
		
		
		//System.out.println(q.query(args[1]));
		
		//GithubQuerier q2 = new GithubQuerier(args[2], args[3]);
		
		//System.out.println(q2.query(args[3]));
		
//		for (String a : args)
//		{
//			System.out.println(a);
//		}
	}
	
	public String query(String userName) throws IOException {
		int pullRequests = 0 ;
		int mergeRequests = 0;
		//String user;
		String login ;
		String merge;
		
		for (int i = 0; i < this.jsonArr.length(); i++ ) {
			login = this.jsonArr.optJSONObject(i).getJSONObject("user").getString("login");
			//System.out.println(login);
			//System.out.println(this.jsonArr.optJSONObject(i).get("merged_at").toString());
			merge = this.jsonArr.optJSONObject(i).get("merged_at").toString();
			if( login.equals(userName)) {
				pullRequests = pullRequests +1;
				if(!merge.equals("null")) {
					mergeRequests++; 
					
				}
				
			}
		}
		System.out.println(mergeRequests);
		System.out.println(pullRequests);
		
		return pullRequests + " " + mergeRequests;
	}
	public GithubQuerier(String account, String name) throws IOException{
		String baseURL = "https://api.github.com/repos/";
		String projectName = name;
		String accountName = account;
		
		URL url = new URL(baseURL + accountName + "/" + projectName + "/pulls" + "?access_token=" + token +"&state=all");
		JSONObject json = Util.queryURL(url);
		jsonArr= json.getJSONArray("root");
//		
//		System.out.println(json);
//		System.out.println("separate");
//		System.out.println(json.getJSONArray("root"));
	}

}
