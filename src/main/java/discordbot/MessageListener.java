package discordbot;

import java.io.IOException;
import java.util.Properties;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class MessageListener implements MessageCreateListener {

	Properties prop;
	
	public MessageListener(){
		prop = new Properties();
		try {
			prop.load(getClass().getResourceAsStream("/urls.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void onMessageCreate(DiscordAPI api, Message message) {

		if(message.getContent().startsWith(".")){
			String command = message.getContent().substring(1);
			String[] split = command.split(" ");
			if(split[0].equals("dotabuff")){
				if(prop.getProperty(split[1]) == null){
					message.reply("Invalid name");
				}
				else{
					message.reply(prop.getProperty(split[1]));
				}
			}
		}
		else{

			switch (message.getContent()) {
			case "Kappa":
				message.reply("http://res.cloudinary.com/urbandictionary/image/upload/a_exif,c_fit,h_200,w_200/v1395991705/gjn81wvxqsq6yzcwubok.png");
				break;
			case "BibleThump":
				message.reply("https://pbs.twimg.com/profile_images/577309793104175104/y2jIo9dq.png");
				break;
			case "KappaRoss":
				message.reply("https://pbs.twimg.com/profile_images/678352686501228544/PbzA8GFf.png");
				break;
			case "PogChamp":
				message.reply("http://vignette1.wikia.nocookie.net/kancolle/images/c/c0/PogChamp.png");
				break;
			case "DansGame":
				message.reply("https://www.kindafunnyforums.com/images/smilies/33-DansGame.png");
				break;
			case "Kreygasm":
				message.reply("http://www.miicharacters.com/miis/large/17819_kreygasm.jpg");
				break;
			}
		}
	}

}
