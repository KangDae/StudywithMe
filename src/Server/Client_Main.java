package Server;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

import Resource.R;

public class Client_Main {
	public R startF = new R();
	public Client_Main() {
		
		startF.frameStart.start();
	}
	public static void main(String[] args) {
		System.setProperty("file.encoding","UTF-8");
		  try{
		  Field charset = Charset.class.getDeclaredField("defaultCharset");
		  charset.setAccessible(true);
		  charset.set(null,null);
		  new Client_Main();	
		  }
		  catch(Exception e){
		   
		  }
		
	}

}
