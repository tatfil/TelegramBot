package command;

import service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class QuestionCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String QUESTION_MESSAGE = "Введите свой впрос\n"
            + "Чтобы посмотреть список комманд введи /help";

    public QuestionCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), QUESTION_MESSAGE);
    }
}
