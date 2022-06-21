package src.main.java.main;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Main {
    public static void main(String[] args) {

        TelegramBotsApi botsApi = null;
        try {
            // Instantiate Telegram Bots API
            botsApi = new TelegramBotsApi(DefaultBotSession.class);

            // Register our bot
            botsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
