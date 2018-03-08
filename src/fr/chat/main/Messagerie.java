package fr.chat.main;

import java.io.IOException;

import fr.chat.client.Client;
import fr.chat.server.Server;

public class Messagerie {

	public static void main(String[] args) throws IOException {
		Server server = new Server();
		Client client = new Client();

		server.run();
		client.run();
	}

}
