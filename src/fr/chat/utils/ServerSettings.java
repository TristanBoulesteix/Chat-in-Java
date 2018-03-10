package fr.chat.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import fr.chat.SystemChatConstant;
import fr.chat.windows.Popup;

public class ServerSettings {
	private String IPserver;

	public String getIPserver() {
		return IPserver;
	}

	public void setIPserver(String iPserver) {
		IPserver = iPserver;
	}

	public void getLastServerIP() {
		File lastServer = new File(SystemChatConstant.PATH);

		if ((!(lastServer.exists())) || lastServer.length() <= 0) {
			String newIP = Popup.askForServerPopup();

			if (newIP != null) {
				try {
					FileWriter writer = new FileWriter(lastServer);
					writer.write(newIP);
					writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			getLastServerIP();

		} else {
			InputStream flux;
			try {
				flux = new FileInputStream(lastServer);
				InputStreamReader lecture = new InputStreamReader(flux);
				BufferedReader buff = new BufferedReader(lecture);
				String dataOfFile = buff.readLine();
				setIPserver(dataOfFile);
				buff.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
