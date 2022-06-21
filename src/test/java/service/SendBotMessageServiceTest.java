package service;

import main.MyBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.mockito.Mockito;
import service.SendBotMessageService;
import service.SendBotMessageServiceImpl;

class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private MyBot myBot;

    @BeforeEach
    public void init() {
        myBot = Mockito.mock(MyBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(myBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        Long chatId = 1L;
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(myBot).execute(sendMessage);
    }
}

