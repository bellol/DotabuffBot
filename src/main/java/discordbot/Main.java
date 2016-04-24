package discordbot;

import java.io.IOException;
import java.util.Properties;

import com.google.common.util.concurrent.FutureCallback;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;

public class Main implements FutureCallback<DiscordAPI>{

	public static void main(String[] args) {
		new Main().login();
	}

    public void login() {
    	Properties prop = new Properties();
    	try {
			prop.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DiscordAPI api = Javacord.getApi(prop.getProperty("token"), true);
		api.connect(this);
    }
	
	@Override
	public void onSuccess(DiscordAPI api) {
		api.registerListener(new MessageListener());
	}
	
	@Override
	public void onFailure(Throwable t) {
		t.printStackTrace();
	}

}
