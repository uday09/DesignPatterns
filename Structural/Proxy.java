package Structural;

import java.util.ArrayList;
import java.util.List;

/*

Hiding actual object behind a place holder.Request sent to real object only if necessary, else return it from place holder  

In a college campus, Wifi connection is there to access internet. Few of the web sites need be restricted, in this case Proxy could be used.


*/

class InternetConnection {
	public void connectToWebSite(String website) {
		System.out.println("Connected to : " + website);
	}
}

class ProxyInternetConnection {

	private InternetConnection internetConnection;

	static List<String> restrictedSiteList = new ArrayList<String>();

	static {
		restrictedSiteList.add("kjk.com");
		restrictedSiteList.add("sss.com");
		restrictedSiteList.add("bbb.com");
		restrictedSiteList.add("xyz.com");
		restrictedSiteList.add("abc.com");
	}

	public ProxyInternetConnection() {
		internetConnection = new InternetConnection();
	}

	
	// Real world example could be, LoadBalancer say amazon.in, as user we don't know to which internal server to amazon request is going to. Our request is reaching to public LoadBalancer only. 
	// It internally decides where to send that request
	
	//Connecting to Internet here only when requests are not to restricted web sites.
	
	public void connectToWebSite(String website) {
		if(!restrictedSiteList.contains(website)) {
			internetConnection.connectToWebSite(website);
		}
		else {
			System.out.println("Not allowed to open : " + website);
		}
	}
}

public class Proxy {
	public static void main(String[] args) {
		ProxyInternetConnection proxyInternetConnection = new ProxyInternetConnection();
		proxyInternetConnection.connectToWebSite("xyz.com");
		proxyInternetConnection.connectToWebSite("zzz.com");
	}
}
