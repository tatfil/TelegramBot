package src.java.main;


import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class MyBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";
    private final CommandContainer commandContainer;


    public MyBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }



    @Override
    public String getBotUsername() {
        // Return bot username
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "tg.properties";


        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appProps.getProperty("tg.username");
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "tg.properties";


        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appProps.getProperty("tg.token");
    }
}