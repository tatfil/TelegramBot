package command;


import static command.CommandName.EVENT;
import static command.EventCommand.EVENT_MESSAGE;

public class EventCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return EVENT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return EVENT_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new EventCommand(sendBotMessageService);
    }
}
