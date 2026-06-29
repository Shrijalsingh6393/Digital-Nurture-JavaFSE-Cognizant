package com.pattern.command;

/**
 * Invoker class that holds and triggers Command objects.
 * It has no knowledge of what the command actually does — it just calls execute().
 */
public class RemoteControl {
    private Command command;

    /**
     * Sets the command to be executed when the button is pressed.
     *
     * @param command the command to set
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Simulates pressing the button on the remote control.
     */
    public void pressButton() {
        if (command == null) {
            System.out.println("[RemoteControl] No command assigned. Please set a command first.");
        } else {
            System.out.print("[RemoteControl] Button pressed -> ");
            command.execute();
        }
    }
}
