package fr.chat.main;

import java.io.IOException;

import fr.chat.server.Server;
import fr.chat.utils.ServerSettings;
import fr.chat.windows.ChatWindows;
import fr.chat.windows.Popup;

public class Messagerie {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		ServerSettings getConnexion = new ServerSettings();
		getConnexion.getLastServerIP();

		Popup connexion = new Popup();

		if (connexion.isLocalServer()) {
			Server server = new Server();
			server.start();

			openWindow();
		} else {
			openWindow(getConnexion.getIPserver());
		}

	}

	protected static void openWindow() {
		ChatWindows window = new ChatWindows();
		window.initialize();
		window.getFrame().setVisible(true);
	}

	protected static void openWindow(String IP) {
		ChatWindows window = new ChatWindows(IP);
		window.initialize();
		window.getFrame().setVisible(true);
	}

}
