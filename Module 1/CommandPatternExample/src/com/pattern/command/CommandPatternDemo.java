package com.pattern.command;

/**
 * Demo class to test and demonstrate the Command Design Pattern.
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Command Pattern implementation ===");

        // 1. Create Receivers (devices in the house)
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight    = new Light("Bedroom");

        // 2. Create Concrete Commands bound to receivers
        Command livingRoomLightOn   = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff  = new LightOffCommand(livingRoomLight);
        Command bedroomLightOn      = new LightOnCommand(bedroomLight);
        Command bedroomLightOff     = new LightOffCommand(bedroomLight);

        // 3. Create the Invoker (remote control)
        RemoteControl remote = new RemoteControl();

        // 4. Issue commands via the remote control
        System.out.println("\n--- Scenario 1: Turn on Living Room light ---");
        remote.setCommand(livingRoomLightOn);
        remote.pressButton();

        System.out.println("\n--- Scenario 2: Turn off Living Room light ---");
        remote.setCommand(livingRoomLightOff);
        remote.pressButton();

        System.out.println("\n--- Scenario 3: Turn on Bedroom light ---");
        remote.setCommand(bedroomLightOn);
        remote.pressButton();

        System.out.println("\n--- Scenario 4: Turn off Bedroom light ---");
        remote.setCommand(bedroomLightOff);
        remote.pressButton();

        System.out.println("\n--- Scenario 5: Press button with no command assigned ---");
        RemoteControl emptyRemote = new RemoteControl();
        emptyRemote.pressButton();

        System.out.println("\nVerification complete: Commands are decoupled from the invoker and receiver.");
    }
}
