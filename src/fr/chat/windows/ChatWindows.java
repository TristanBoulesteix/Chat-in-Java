package fr.chat.windows;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.chat.CloseAll;
import fr.chat.client.Client;

public class ChatWindows {

	private String IPserver;
	private JFrame frame;
	private JTextField textField;
	private JTextField txtConverstion;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChatWindows window = new ChatWindows();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnknownHostException
	 */
	public ChatWindows() throws UnknownHostException {
		IPserver = "localhost";
		initialize();
	}

	public ChatWindows(String iP) throws UnknownHostException {
		IPserver = iP;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws UnknownHostException
	 */
	public void initialize() throws UnknownHostException {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		getFrame().getContentPane().setLayout(gridBagLayout);

		txtConverstion = new JTextField();
		txtConverstion.setDisabledTextColor(Color.BLACK);
		txtConverstion.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtConverstion.setEnabled(false);
		txtConverstion.setEditable(false);
		txtConverstion.setText("Conversation");
		GridBagConstraints gbc_txtConverstion = new GridBagConstraints();
		gbc_txtConverstion.gridwidth = 2;
		gbc_txtConverstion.insets = new Insets(0, 0, 5, 5);
		gbc_txtConverstion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtConverstion.gridx = 0;
		gbc_txtConverstion.gridy = 0;
		frame.getContentPane().add(txtConverstion, gbc_txtConverstion);
		txtConverstion.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 15;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		frame.getContentPane().add(textArea, gbc_textArea);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 16;
		getFrame().getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.setAction(action);
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.gridx = 1;
		gbc_btnEnvoyer.gridy = 16;
		frame.getContentPane().add(btnEnvoyer, gbc_btnEnvoyer);

		JMenuBar menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);

		JMenu mnMessagerie = new JMenu("Messagerie");
		menuBar.add(mnMessagerie);

		JMenuItem mntmRinitialiser = new JMenuItem("R\u00E9initialiser");
		mnMessagerie.add(mntmRinitialiser);

		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.setAction(action_1);
		mnMessagerie.add(mntmQuitter);

		JMenu mnChat = new JMenu("Chat");
		menuBar.add(mnChat);

		JMenuItem mntmDconnexion = new JMenuItem("D\u00E9connexion");
		mntmDconnexion.setAction(action_2);
		mnChat.add(mntmDconnexion);

		JMenuItem mntmIpServeur = new JMenuItem("IP serveur : " + InetAddress.getLocalHost().getHostAddress());
		mntmIpServeur.setEnabled(false);
		mnChat.add(mntmIpServeur);

		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);

		JMenuItem mntmAide = new JMenuItem("Aide");
		mnAide.add(mntmAide);

		JMenu mnPropos = new JMenu("\u00C1 propos");
		menuBar.add(mnPropos);

		JMenuItem mntmVersion = new JMenuItem("Version");
		mntmVersion.setEnabled(false);
		mnPropos.add(mntmVersion);

		JMenuItem mntmChangelog = new JMenuItem("Changelog");
		mnPropos.add(mntmChangelog);

		JMenuItem mntmProposDu = new JMenuItem("\u00C1 propos du d\u00E9veloppeur");
		mntmProposDu.setAction(action_3);
		mnPropos.add(mntmProposDu);

		getFrame().getRootPane().setDefaultButton(btnEnvoyer);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Envoyer");
			putValue(SHORT_DESCRIPTION, "Envoyer votre message");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!textField.getText().isEmpty()) {
				String message = textField.getText();
				Client client = new Client(message, IPserver);

				client.start();

			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Quitter");
			putValue(SHORT_DESCRIPTION, "Fermer toutes les fenêtres et quitter l'application");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Déconnexion");
			putValue(SHORT_DESCRIPTION, "Déconnectez-vous du serveur");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean confirmation = Popup.popupBeforeDisconect();

			if (confirmation) {
				CloseAll reset = new CloseAll();
				reset.deleteFile(true);
				reset.restart();
			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Á propos du développeur");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Popup.aboutMe();
		}
	}
}
