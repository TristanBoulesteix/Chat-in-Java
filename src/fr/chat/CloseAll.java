package fr.chat;

import java.io.File;

public class CloseAll {
	public void deleteFile(boolean DeleteAll) {
		File serverSetting = new File(SystemChatConstant.PATH);
		if (serverSetting.exists()) {
			serverSetting.delete();
		}
	}

	public void deleteFile() {
		File serverSetting = new File(SystemChatConstant.PATH);
		if (serverSetting.exists()) {
			serverSetting.delete();
		}

	}

	public void restart() {
		Restart restart = new Restart();

		restart.restartApplication();
	}
}
