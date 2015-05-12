package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorRaise extends Command {

	Timer timer;
	double runTime;
	
	public ElevatorRaise() {
		requires(Robot.elevator);
		
		timer = new Timer();
		runTime = 0;
	}
	
	public ElevatorRaise(double time) {
		requires(Robot.elevator);
		
		timer = new Timer();
		runTime = time;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.stop();
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.elevator.raise(0.75);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (runTime == 0) {
			return Robot.elevator.topSwitch.get();
		} else {
			return (Robot.elevator.topSwitch.get()) || (timer.get() >= runTime);
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.elevator.raise(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
