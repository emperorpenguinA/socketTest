package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	private static final String END = "exit";
	private static final String ENTER = "\n";

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String ipAddress = "172.16.20.12";
		int port = 8888;

		try {
			ipAddress = args[1];
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			socket = new Socket(ipAddress, port);
			if ( socket.isConnected() ) {
				br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
				String line = "";
				System.out.println("connect OK");
				System.out.println("入力を終了したいときは「" + END + "」と入力して下さい");
				while ((line = br.readLine()) != null) {
					bw.write(line + ENTER);
					if (END.equals(line)) {
						break;
					}
				}
			} else {
				System.out.println("connect ERROR");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
				socket.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
