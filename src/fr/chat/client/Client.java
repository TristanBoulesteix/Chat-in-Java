package fr.chat.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import fr.chat.main.AbstractChatData;

public class Client extends Thread {
	public Client() {
		super();
	}

	@Override
	public void run() {
		Socket client = null;
		try {
			client = new Socket("localhost", AbstractChatData.PORT);

			OutputStream outstream = client.getOutputStream();
			PrintWriter out = new PrintWriter(outstream);

			String toSend = "String to send\n";

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
