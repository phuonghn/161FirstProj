package ecs161.querying.jira;


import java.io.IOException;
import java.net.URL;

import org.json.JSONObject;

import ecs161.querying.jira.util.Util;

public class JIRAQuerier {

	public static void main(String[] args) throws IOException {
		JIRAQuerier querier = new JIRAQuerier();
		String name = querier.query();
		System.out.println(name);
	}

	public JIRAQuerier() {
	}

	public String query() throws IOException {
		String baseURL = "https://issues.apache.org/jira/rest/api/2/issue/";
		String jiraID = "DERBY-1366";
		// Query the appropriate API
		URL url = new URL(baseURL + jiraID);
		
		JSONObject json = Util.queryURL(url);
		
		JSONObject root = json.getJSONObject("root");
		JSONObject fields = root.getJSONObject("fields");
		JSONObject issueType = fields.getJSONObject("issuetype");
		return issueType.getString("name");
	}
}
