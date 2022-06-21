package command;

public enum CommandName {

    START("/start"),
    EVENT("/event"),
    QUESTION("/question"),
    HELP("/help"),
    NO("no command");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}