package org.firsthumans.recyclerush;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public enum Trigger {
		TRIGGER_LEFT, TRIGGER_RIGHT
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    Joystick controller = new Joystick(0);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    public double getX() {
    	return controller.getRawAxis(RobotMap.CONTROLLER_LX);
    }
    
    public double getY() {
    	return controller.getRawAxis(RobotMap.CONTROLLER_LY);
    }

	public double getTriggers() {
		return controller.getRawAxis(RobotMap.CONTROLLER_RTRIGGER) - controller.getRawAxis(RobotMap.CONTROLLER_LTRIGGER);
	}
	
	public double getRawTrigger(Trigger trigger) {
		if (trigger == Trigger.TRIGGER_LEFT) {
			return controller.getRawAxis(RobotMap.CONTROLLER_LTRIGGER);
		} else {
			return controller.getRawAxis(RobotMap.CONTROLLER_RTRIGGER);
		}
	}
}

