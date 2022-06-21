package command;

import static command.CommandName.QUESTION;
import static command.QuestionCommand.QUESTION_MESSAGE;

public class QuestionCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName() {
        return QUESTION.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return QUESTION_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new QuestionCommand(sendBotMessageService);
    }
}
