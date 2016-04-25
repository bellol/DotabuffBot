# DotabuffBot
a discord bot written with [Javacord](https://github.com/BtoBastian/JavacordBot) to quickly get a link to dotabuff for a specified player

#Config setup
remove -example from the property files and enter your own bot token/player names and links

#Usage
get the bot to join your server by replacing CLIENT_ID with the id of the bot and following the link
```
https://discordapp.com/oauth2/authorize?&client_id=CLIENT_ID&scope=bot
```

to receive a response from the bot
```
.dotabuff <name>
```

#Build and run
```
mvn clean package
cd target
java -jar discordbot-1.0-jar-with-dependencies.jar
```
