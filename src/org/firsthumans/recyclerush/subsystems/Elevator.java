package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;
import org.firsthumans.recyclerush.commands.ElevatorIdle;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	Talon winchMotor;

	public DigitalInput bottomSwitch;
	public DigitalInput topSwitch;
	
	public Elevator(int spoolMotorChannel) {
		winchMotor = new Talon(spoolMotorChannel);
		
		bottomSwitch = new DigitalInput(RobotMap.LIMIT_DOWN);
		topSwitch = new DigitalInput(RobotMap.LIMIT_UP);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorIdle());
	}
	
	public void raise(double speed) {
		this.move(Math.abs(speed));
	}
	
	public void lower(double speed) {
		this.move(-Math.abs(speed));
	}
	
	public void move(double speed) {
		boolean top = topSwitch.get();
		boolean bottom = bottomSwitch.get();
		
		if (speed > 0) {
			if (top) {
				Robot.logNumber("Elevator Speed", 0);
				winchMotor.set(0);
			} else {
				Robot.logNumber("Elevator Speed", speed);
				winchMotor.set(speed);
			}
		} else if (speed < 0) {
			if (bottom) {
				Robot.logNumber("Elevator Speed", 0);
				winchMotor.set(0);
			} else {
				Robot.logNumber("Elevator Speed", speed);
				winchMotor.set(speed);
			}
		} else {
			Robot.logNumber("Elevator Speed", 0);
			winchMotor.set(0);
		}
	}
}
