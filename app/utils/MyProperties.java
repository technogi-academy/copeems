package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MyProperties {
	
	//public static final String PROP_1;
	private static final Properties p;
	
	static{
		p = new  Properties();
		//p.load(new FileInputStream(new File("")));
		//PROP_1 = p.get("prop.1").toString();
	}
	
	public static final String get(String key){
		String prop = p.getProperty(key);
		//validaciones...
		return prop;
	}
	
	

}
