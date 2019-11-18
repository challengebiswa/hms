package org.hms.restclient;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.load(RestClient.class.getClassLoader().getResourceAsStream("application.properties"));
		String port = prop.getProperty("server.port");
		String url = prop.getProperty("specialist.url");
		String context = prop.getProperty("server.servlet.contextPath") + url;
		String env = "localhost:" + port + context;
		String hospitalName = "XYZ";
		String specialist = "Dentist";
		String type = "application/xml";
		RestClient.restTest(port, env, type, hospitalName, specialist);
	}

	public static ResponseEntity<String> restTest(String port, String env, String type, String hospitalName,
			String specialist) {
		final String uri = "http://" + env + "?hospitalName" + hospitalName + "&specialistType=" + specialist;

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		if (type.equalsIgnoreCase("application/json"))
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		else if (type.equalsIgnoreCase("application/xml"))
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		System.out.println(result);
		return result;
	}

}
