package command;

import service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static command.CommandName.*;

public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;


    public final static String START_MESSAGE = String.format("Привет. Я New Telegram Bot.\n " +
            "%s чтобы узнать о ближайших событиях\n" +
            "%s чтобы задать вопрос\n" +
            "%s для справки", EVENT.getCommandName(), QUESTION.getCommandName(), HELP.getCommandName());

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}