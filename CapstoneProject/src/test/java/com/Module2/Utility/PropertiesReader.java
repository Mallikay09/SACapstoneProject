package com.Module2.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	Properties prop;
	public PropertiesReader()
	{
		prop=new Properties();
		File f1=new File(System.getProperty("user.dir")+"//config//config.properties");
		
		try {
			FileInputStream fs=new FileInputStream(f1);
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getData(String key)
	{
		return prop.getProperty(key);
	}
}
