package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveIdle extends Command {
 
	DriveTrain driveTrain;

	public DriveIdle() {
		requires(Robot.driveTrain);

		driveTrain = Robot.driveTrain;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		driveTrain.arcadeDrive(0, 0, 0);
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
