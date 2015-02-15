package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.OI;
import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorHumanControl extends Command {

	OI oi = Robot.oi;
	DigitalInput bottomSwitch;
	DigitalInput topSwitch;

	public ElevatorHumanControl() {
		requires(Robot.elevator);

		bottomSwitch = new DigitalInput(RobotMap.LIMIT_DOWN);
		topSwitch = new DigitalInput(RobotMap.LIMIT_UP);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		float speed = (float)Math.pow(oi.getRightY(), 2.0) * 0.5f;
		if (speed > 0) {
			if (topSwitch.get()) {
				Robot.logNumber("Elevator Speed", 0);
				Robot.elevator.move(0);
			} else {
				Robot.logNumber("Elevator Speed", speed);
				Robot.elevator.move(speed);
			}
		} else if (speed < 0) {
			if (bottomSwitch.get()) {
				Robot.logNumber("Elevator Speed", 0);
				Robot.elevator.move(0);
			} else {
				Robot.logNumber("Elevator Speed", -speed);
				Robot.elevator.move(-speed);
			}
		} else {
			Robot.logNumber("Elevator Speed", 0);
			Robot.elevator.move(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
