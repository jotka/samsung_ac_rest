package pl.finsys.acrest.samsung.out;

public class Command {
    private String component;
    private String capability;
    private String command;
    private String[] arguments;

    public Command(String capability, String command) {
        this.component = "main";
        this.capability = capability;
        this.command = command;
    }

    public Command(String capability, String command, String[] arguments) {
        this.component = "main";
        this.capability = capability;
        this.command = command;
        this.arguments = arguments;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String value) {
        this.component = value;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String value) {
        this.capability = value;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String value) {
        this.command = value;
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] value) {
        this.arguments = value;
    }
}
