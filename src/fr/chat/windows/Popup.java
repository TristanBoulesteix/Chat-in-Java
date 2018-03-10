package fr.chat.windows;

import javax.swing.JOptionPane;

import fr.chat.windows.utils.PopupUtils;

public class Popup {
	private static boolean localServer = false;

	public static boolean isLocalServer() {
		return localServer;
	}

	public static void setLocalServer(boolean localServer) {
		Popup.localServer = localServer;
	}

	public static String askForServerPopup() {
		String[] choix = { "Créer un nouveau serveur", "Rejoindre un serveur" };
		String IPserver;

		int actionChoosen = JOptionPane.showOptionDialog(null,
				"Aucun serveur détecté. Veuillez sélectionner une option :", "Serveur introuvable",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);

		if (actionChoosen == 1) {
			IPserver = askForServerIPv4();
			boolean trueIP = PopupUtils.checkIPv4(IPserver);

			if (!trueIP) {
				wrongIPFormat();
				return null;
			} else {
				return IPserver;
			}
		} else if (actionChoosen == 0) {
			IPserver = PopupUtils.CreateServer();
			setLocalServer(true);

			if (IPserver != null) {
				return IPserver;
			}

		}

		return null;
	}

	public static String askForServerIPv4() {
		String IPString = JOptionPane.showInputDialog(null,
				"Écrivez le code du serveur pour vous connecter à celui-ci.\nCe code est fourni lors de la création du serveur. Il s'agit de son IPv4.",
				"Connexion à un nouveau serveur", JOptionPane.QUESTION_MESSAGE);

		return IPString;
	}

	public static void wrongIPFormat() {
		JOptionPane.showMessageDialog(null, "Désolé, le code entré n'est pas au bon format.", "Erreur",
				JOptionPane.ERROR_MESSAGE);
	}
}
