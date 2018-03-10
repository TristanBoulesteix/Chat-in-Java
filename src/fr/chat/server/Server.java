package fr.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import fr.chat.main.ChatData;

public class Server extends Thread {
	public Server() {
		super();
	}

	@Override
	public void run() {
		ServerSocket server;
		try {
			server = new ServerSocket(ChatData.PORT);

			while (true) {
				Socket client = new Socket();
				client = server.accept();
				System.out.println("Client has connected!");
				InputStream is = client.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String message = br.readLine();
				System.out.println("Message received from client is " + message);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
