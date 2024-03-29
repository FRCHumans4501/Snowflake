package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripperIdle extends Command {

    public GripperIdle() {
        requires(Robot.gripper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gripper.set(Robot.gripper.getState());
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
