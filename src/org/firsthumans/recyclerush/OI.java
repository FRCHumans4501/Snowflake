package org.firsthumans.recyclerush;

import org.firsthumans.recyclerush.commands.GripperClose;
import org.firsthumans.recyclerush.commands.GripperOpen;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public enum Trigger {
		LEFT, RIGHT
	}

	Joystick controller = new Joystick(0);
	Button closeGripperButton = new JoystickButton(controller,
			RobotMap.CONTROLLER_LTRIGGER);
	Button openGripperButton = new JoystickButton(controller,
			RobotMap.CONTROLLER_RTRIGGER);

	public OI() {
		closeGripperButton.whenPressed(new GripperClose());
		openGripperButton.whenPressed(new GripperOpen());
	}

	public double getX() {
		return controller.getRawAxis(RobotMap.CONTROLLER_LX);
	}

	public double getRightX() {
		return controller.getRawAxis(RobotMap.CONTROLLER_RX);
	}

	public double getY() {
		return controller.getRawAxis(RobotMap.CONTROLLER_LY);
	}

	public double getRightY() {
		return controller.getRawAxis(RobotMap.CONTROLLER_RY);
	}

	public double getTriggers() {
		return controller.getRawAxis(RobotMap.CONTROLLER_RTRIGGER)
				- controller.getRawAxis(RobotMap.CONTROLLER_LTRIGGER);
	}

	public double getRawTrigger(Trigger trigger) {
		if (trigger == Trigger.LEFT) {
			return controller.getRawAxis(RobotMap.CONTROLLER_LTRIGGER);
		} else {
			return controller.getRawAxis(RobotMap.CONTROLLER_RTRIGGER);
		}
	}
}
