package pl.finsys.acrest.samsung.out;

import java.util.ArrayList;
import java.util.List;

public class SamsungCommand {
    private List<Command> commands = new ArrayList<>();

    public SamsungCommand(String capability, String command) {
        this.commands.add(new Command(capability, command));
    }

    public SamsungCommand(String capability, String command, Object[] params) {
        this.commands.add(new Command(capability, command, params));
    }

    public List getCommands() {
        return commands;
    }

    public void setCommands(List value) {
        this.commands = value;
    }
}
