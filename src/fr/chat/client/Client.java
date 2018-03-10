package fr.chat.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import fr.chat.main.ChatData;

public class Client extends Thread {
	String toSend;
	String ip;

	public Client(String message, String iPserver) {
		super(message);
		toSend = message;
		ip = iPserver;
	}

	@Override
	public void run() {
		Socket client = null;
		try {
			client = new Socket("localhost", ChatData.PORT);

			OutputStream outstream = client.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);

			out.print(toSend);

			out.flush();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
