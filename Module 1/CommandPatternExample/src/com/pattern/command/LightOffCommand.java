package com.pattern.command;

/**
 * Concrete Command class that issues a "turn off" request to the Light receiver.
 */
public class LightOffCommand implements Command {
    private final Light light;

    /**
     * Binds this command to the given Light receiver.
     *
     * @param light the Light receiver to act upon
     */
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
