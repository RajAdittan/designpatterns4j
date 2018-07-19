package io.codej.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class BatchExecute implements ExecuteCommand {

    private List<ExecuteCommand> commands = new ArrayList<>();

    public synchronized void add(ExecuteCommand command) {
        commands.add(command);
    }

    @Override
    public synchronized void execute() {
        commands.stream().forEach(command -> command.execute());
    }
}
