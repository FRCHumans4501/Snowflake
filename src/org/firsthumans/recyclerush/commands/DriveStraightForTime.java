package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightForTime extends Command {

	Timer timer;
	Gyro gyro;

	double time;
	double speed;
	boolean finished = false;

	public DriveStraightForTime(double speed, double time) {
		timer = new Timer();
		gyro = Robot.gyro;

		this.time = time;
		this.speed = speed;

		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.stop();
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		float angle = (float) gyro.getAngle();
		Robot.driveTrain.arcadeDrive(speed, 0, -angle * RobotMap.DRIVEPID_Kp);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		double currentTime = timer.get();

		if (time > currentTime) {
			return false;
		} else {
			return true;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
