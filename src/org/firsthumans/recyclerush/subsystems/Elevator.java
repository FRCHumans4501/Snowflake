package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.commands.ElevatorIdle;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	Talon winchMotor;
	
	public Elevator(int spoolMotorChannel) {
		winchMotor = new Talon(spoolMotorChannel);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorIdle());
	}
	
	public void raise(double speed) {
		winchMotor.set(Math.abs(speed));
	}
	
	public void lower(double speed) {
		winchMotor.set(-Math.abs(speed));
	}
	
	public void move(double speed) {
		winchMotor.set(speed);
	}
}
