package http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
		BufferedWriter bw = null;
		HttpURLConnection conn = null;
		File file = new File("download.html");

		try {
			url = new URL("http://www.rakus.co.jp");
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("pf.sj.itboost.co.jp", 3128));//
			conn = (HttpURLConnection )url.openConnection(proxy);

			br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			bw = new BufferedWriter(new FileWriter(file));

			String line;
			while ( ( line = br.readLine() ) != null ) {
				System.out.println( line );
				bw.write(line);
				bw.newLine();
			}

			System.out.println("下記のフォルダに保存しました");
			System.out.println(file.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

	}
}
