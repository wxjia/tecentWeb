package cn.wxjia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class GetAddressByIp {
	public static String getAddress(String url, String ip) {
		try {
			if ("192.168.1.101".equals(ip)) {
				ip = "175.13.66.63";
			}
			String connUrl = url + "&ip=" + ip;
			System.out.println("connUrl = " + connUrl);
			InputStream inputStream = new URL(connUrl).openStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream, Charset.forName("UTF-8")));

			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = bufferedReader.read()) != -1) {
				sb.append((char) cp);
			}

			String jsonText = sb.toString();
			JSONObject json = new JSONObject(jsonText);

			System.out.println("jsonText = " + jsonText);
			System.out.println("json.toString() = " + json.toString());

			String ret = "" + ((JSONObject) json.get("content")).get("address");
			return ret;

		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException" + e.getMessage());
		} catch (JSONException e) {
			System.out.println("JSONException" + e.getMessage());
		}
		return null;
	}
}
