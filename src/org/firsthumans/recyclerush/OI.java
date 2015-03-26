package org.firsthumans.recyclerush;

import org.firsthumans.recyclerush.commands.GripperClose;
import org.firsthumans.recyclerush.commands.GripperIdle;
import org.firsthumans.recyclerush.commands.GripperOpen;
import org.firsthumans.recyclerush.commands.IntakeClose;
import org.firsthumans.recyclerush.commands.IntakeIdle;
import org.firsthumans.recyclerush.commands.IntakeLoad;
import org.firsthumans.recyclerush.commands.IntakeOpen;
import org.firsthumans.recyclerush.commands.IntakeUnload;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	XboxController controller = new XboxController(0);
	
	Button closeGripperButton = new JoystickButton(controller, XboxController.BUMPER_L);
	Button openGripperButton = new JoystickButton(controller, XboxController.BUMPER_R);
	
	Button intakeOpenButton = new JoystickButton(controller, XboxController.BUTTON_X);
	Button intakeCloseButton = new JoystickButton(controller, XboxController.BUTTON_B);
	Button intakeLoadButton = new JoystickButton(controller, XboxController.BUTTON_A);
	Button intakeUnloadButton = new JoystickButton(controller, XboxController.BUTTON_Y);
	
	// TODO(jerish): Test Code DO NOT SHIP
	/*Button autoTestOn = new JoystickButton(controller, RobotMap.BUTTON_A);
	Button autoTestOff = new JoystickButton(controller, RobotMap.BUTTON_B);
	Button straightTestOn = new JoystickButton(controller, RobotMap.BUTTON_X);
	Button straightTestOff = new JoystickButton(controller, RobotMap.BUTTON_Y);*/
	
	/*
	 * CONTROLS
	 * Left Stick   - Drive Speed
	 * Triggers     - Drive Rotation
	 * Right Stick  - Elevator Movement
	 * Left Bumper  - Close Gripper
	 * Right Bumper - Open Gripper
	 * A			- Intake Load
	 * Y			- Intake Unload
	 * X			- Open Intake
	 * B			- Close Intake
	 */
	public OI() {
		// GRIPPER
		closeGripperButton.whenPressed(new GripperClose());
		closeGripperButton.whenReleased(new GripperIdle());
		
		openGripperButton.whenPressed(new GripperOpen());
		openGripperButton.whenReleased(new GripperIdle());
		
		// INTAKE
		intakeLoadButton.whenPressed(new IntakeLoad());
		intakeLoadButton.whenReleased(new IntakeIdle());
		
		intakeUnloadButton.whenPressed(new IntakeUnload());
		intakeUnloadButton.whenReleased(new IntakeIdle());
		
		intakeOpenButton.whenPressed(new IntakeOpen());
		intakeCloseButton.whenPressed(new IntakeClose());
		
		// TODO(jerish): Test Code DO NOT SHIP
		//autoTestOn.whenPressed(new DriveRotateAngle(90));
		//autoTestOff.whenPressed(new DriveArcade());
		
		/*autoTestOn.whenPressed(new AutonomousGroup());
		autoTestOff.whenPressed(new DriveIdle());
		
		straightTestOn.whenPressed(new DriveArcadeStraight());
		straightTestOff.whenPressed(new DriveArcade());*/
	}

	public double getX() {
		return controller.getX(Hand.kLeft);
	}

	public double getRightX() {
		return controller.getX(Hand.kRight);
	}

	public double getY() {
		return controller.getY(Hand.kLeft);
	}

	public double getRightY() {
		return controller.getY(Hand.kRight);
	}

	public double getTriggers() {
		return controller.getRawAxis(XboxController.TRIGGER_R)
				- controller.getRawAxis(XboxController.TRIGGER_L);
	}
	
	public double getMatchTime() {
		return Timer.getMatchTime();
	}
	
	public void setRumble(double value) {
		controller.setRumble(RumbleType.kLeftRumble, (float)value);
		controller.setRumble(RumbleType.kRightRumble, (float)value);
	}
}
