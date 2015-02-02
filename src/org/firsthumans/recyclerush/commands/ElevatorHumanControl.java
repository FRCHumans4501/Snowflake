package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.OI;
import org.firsthumans.recyclerush.Robot;

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
    	double speed = oi.getRightY();
    	if (speed > 0) {
    		speed = Math.pow(speed, 2.0);
    	} else if (speed < 0) {
    		speed = -Math.pow(speed, 2.0);
    	} else {
    		speed = 0;
    	}
    	Robot.elevator.set(speed);
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
