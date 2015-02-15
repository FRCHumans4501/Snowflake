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

	public ElevatorHumanControl() {
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.logString("Elevator Humans Control", "Engaged");
		
		double speed = (float)Math.pow(oi.getRightY(), 2.0);
		if (oi.getRightY() > 0) speed = -speed;
		Robot.elevator.move(speed);
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

