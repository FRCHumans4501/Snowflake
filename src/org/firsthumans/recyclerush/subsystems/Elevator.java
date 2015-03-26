package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;
import org.firsthumans.recyclerush.commands.ElevatorIdle;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	public enum Direction {
		NONE, UP, DOWN
	}
	
	Jaguar winchMotor;
	Direction direction;

	public DigitalInput bottomSwitch;
	public DigitalInput topSwitch;
	
	public Elevator() {
		winchMotor = new Jaguar(RobotMap.ANALOG_WINCHMOTOR);
		
		bottomSwitch = new DigitalInput(RobotMap.LIMIT_DOWN);
		topSwitch = new DigitalInput(RobotMap.LIMIT_UP);
		
		direction = Direction.NONE;
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
				direction = Direction.NONE;
			} else {
				Robot.logNumber("Elevator Speed", speed);
				winchMotor.set(speed);
				direction = Direction.DOWN;
			}
		} else if (speed < 0) {
			if (bottom) {
				Robot.logNumber("Elevator Speed", 0);
				winchMotor.set(0);
				direction = Direction.NONE;
			} else {
				Robot.logNumber("Elevator Speed", speed);
				winchMotor.set(speed);
				direction = Direction.UP;
			}
		} else {
			Robot.logNumber("Elevator Speed", 0);
			winchMotor.set(0);
			direction = Direction.NONE;
		}
	}
	
	public Direction getDirection() {
		return this.direction;
	}
}
