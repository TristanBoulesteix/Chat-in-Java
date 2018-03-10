package fr.chat.main;

import java.io.IOException;

import fr.chat.client.Client;
import fr.chat.server.Server;
import fr.chat.windows.ChatWindows;

public class Messagerie {

	public static void main(String[] args) throws IOException {
		openWindow();

		Server server = new Server();
		Client client = new Client("test");

		server.start();
		client.start();
	}

	protected static void openWindow() {
		ChatWindows window = new ChatWindows();
		window.initialize();
		window.getFrame().setVisible(true);
	}

}
