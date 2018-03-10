package fr.chat.windows.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class PopupUtils {
	public static boolean checkIPv4(String possibleIP) {
		try {
			if (possibleIP == null || possibleIP.isEmpty()) {
				return false;
			}

			String[] parts = possibleIP.split("\\.");
			if (parts.length != 4) {
				return false;
			}

			for (String s : parts) {
				int i = Integer.parseInt(s);
				if ((i < 0) || (i > 255)) {
					return false;
				}
			}
			if (possibleIP.endsWith(".")) {
				return false;
			}

			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static String CreateServer() {
		String newIP;

		try {
			newIP = InetAddress.getLocalHost().getHostAddress();

			if (!(InetAddress.getByName(newIP).isSiteLocalAddress())) {
				JOptionPane.showMessageDialog(null,
						"Une erreur s'est produite. Impossible de récupérer l'adresse du serveur.", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				return null;

			} else if (InetAddress.getByName(newIP).isLoopbackAddress()) {
				JOptionPane.showMessageDialog(null,
						"Attention ! Une erreur s'est produite. Le serveur fonctionne uniquement en localHost,\nVeuillez vérifier votre connexion Internet.",
						"Erreur", JOptionPane.ERROR_MESSAGE);
				return "localhost";

			} else {
				return newIP;
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;
		}
	}
}
