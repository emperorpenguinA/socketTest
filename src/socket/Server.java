package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final String END = "exit";

	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader br = null;
		int port = 8888;

		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				socket = serverSocket.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				System.out.println("IP:" + socket.getInetAddress().getHostAddress());
				String line = null;
				while ((line = br.readLine()) != null){
					System.out.println(line);
					if (END.equals(line)) {
						socket.close();
						break;
					}
				}
			}
		} catch (IOException e)  {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
