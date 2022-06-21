package src.java.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import src.java.main.MyBot;

import java.util.List;

import static com.google.common.collect.Iterables.isEmpty;
import static org.apache.http.util.TextUtils.isBlank;

public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final MyBot myBot;


    public SendBotMessageServiceImpl(MyBot myBot) {
        this.myBot = myBot;
    }

    @Override
    public void sendMessage(Long chatId, String message) {
        if (isBlank(message)) return;

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            myBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(Long chatId, List<String> messages) {
        if (isEmpty(messages)) return;

        messages.forEach(m -> sendMessage(chatId, m));
    }
}