package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.commands.GripperClose;

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

	public Gripper(int forwardChannel, int reverseChannel) {
		solenoid = new DoubleSolenoid(forwardChannel, reverseChannel);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new GripperClose());
	}

	public void open() {
		solenoid.set(Value.kForward);
		state = GripperState.GP_OPEN;
	}

	public void close() {
		solenoid.set(Value.kReverse);
		state = GripperState.GP_CLOSED;
	}
	
	public GripperState getState() {
		return state;
	}
}
