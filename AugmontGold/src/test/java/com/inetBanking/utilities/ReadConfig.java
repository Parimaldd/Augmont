package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties Pro;
	// Create construtor

	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			Pro = new Properties();
			Pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String url = Pro.getProperty("URL");
		return url;
	}

	public String getUsername() {
		String user = Pro.getProperty("UName");
		return user;
	}

	public String getPassw() {
		String pass = Pro.getProperty("PassCode");
		return pass;
	}

	public String getChromepath() {
		String path = Pro.getProperty("Chromepath");
		return path;
	}

	public String getEdgepath() {
		String path = Pro.getProperty("Microsoftedgepath");
		return path;
	}
}
