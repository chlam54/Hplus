package com.app.scraper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.app.dao.AbstractDaoImpl;
import com.app.util.Util;

public class ImageScraper {
	public static void execute() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(AbstractDaoImpl.url, AbstractDaoImpl.user, AbstractDaoImpl.password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select id,homeNameEn,awayNameEn,awayName,homeName from data.match");
			while (rs.next()) {
				String url = "https://g10oal.com/match/" + rs.getString("id") + "/history";
				String html = getHTMLString(url);
				Document doc = Jsoup.parse(html);
				
				for(Element e : doc.getElementsByTag("img")) {
					String src = e.attr("src");
					String alt = e.attr("alt");
					try {
						if(alt.contains(rs.getString("homeName"))) {
							downLoadFile(src,rs.getString("homeNameEn"));
						}
	
						if(alt.contains(rs.getString("awayName"))) {
							downLoadFile(src,rs.getString("awayNameEn"));
						}
					}catch(IOException io) {
						io.printStackTrace();
					}
	
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String getHTMLString(String url) {
		String responseString = "";
		HttpClient httpClient = new DefaultHttpClient(); 
		try {
			
			HttpResponse response = httpClient.execute(new HttpGet(url));
			HttpEntity entity = response.getEntity();
			responseString = EntityUtils.toString(entity, "UTF-8");
			
		} catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	httpClient.getConnectionManager().shutdown();
        }
		return responseString;
	}
	
	public static boolean downLoadFile(String url, String fileName) throws IOException{

		
		String savePath = "//root//web//oddstat//public//img//fc//"+fileName+".png";
		
		if(new File(savePath).exists()) {
			System.out.println(fileName+" is exist");
			return false;
		}
		
		HttpClient client = new DefaultHttpClient(); 
		HttpGet get = new HttpGet(url);
		HttpResponse response = null;
		
		try {
			response = client.execute(get);
			int state = response.getStatusLine().getStatusCode();
			System.out.println(state);
			if(state == HttpStatus.SC_OK){	
				HttpEntity entity = response.getEntity();
							
				InputStream input = entity.getContent();
				
				FileOutputStream bout = new FileOutputStream(savePath);
				
				byte[] buffer = new byte[1024 * 100000];
				int read = 0;

				while ((read = input.read(buffer)) > 0) {
					bout.write(buffer,0,read);
					System.out.println(read);
				}
				input.close(); 
				bout.close();
				System.out.println("download success");
			}else{
				System.out.println("read error");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			client.getConnectionManager().shutdown();
		}
		return true;
	}
	

}
