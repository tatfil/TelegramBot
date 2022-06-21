package src.java.command;

import src.java.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EventCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String EVENT_MESSAGE = "Ближайшее мероприятие состоится\n"
            + "09.07.2022";

    public EventCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), EVENT_MESSAGE);
    }
}
