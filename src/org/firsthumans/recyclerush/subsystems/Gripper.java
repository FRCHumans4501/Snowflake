package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.RobotMap;
import org.firsthumans.recyclerush.commands.GripperIdle;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {

	public enum GripperState {
		GP_OPEN, GP_CLOSED
	}

	DoubleSolenoid solenoid;
	GripperState state;

	public Gripper() {
		solenoid = new DoubleSolenoid(RobotMap.SOLENOID_GRIPPERFORWARD, RobotMap.SOLENOID_GRIPPERBACKWARD);
		state = GripperState.GP_CLOSED;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new GripperIdle());
	}

	public void open() {
		solenoid.set(Value.kForward);
		state = GripperState.GP_OPEN;
	}

	public void close() {
		solenoid.set(Value.kReverse);
		state = GripperState.GP_CLOSED;
	}
	
	public void set(GripperState state) {
		switch (state) {
		case GP_CLOSED:
			this.close();
			break;
			
		case GP_OPEN:
			this.open();
			break;
		}
	}
	
	public GripperState getState() {
		return state;
	}
}
