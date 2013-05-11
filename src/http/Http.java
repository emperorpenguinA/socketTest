package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Http {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader br = null;
		HttpURLConnection conn = null;
		try {
			url = new URL("http://www.rakus.co.jp");
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("pf.sj.itboost.co.jp", 3128));//
			conn = (HttpURLConnection )url.openConnection(proxy);

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ( ( line = br.readLine() ) != null ) {
				System.out.println( line );
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			conn.disconnect();
			try {
				br.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}
}
