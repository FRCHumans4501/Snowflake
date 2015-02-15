package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotateAngle extends Command {

	double targetAngle;
	
    public DriveRotateAngle(double targetAngle) {
        requires(Robot.driveTrain);
        
        this.targetAngle = targetAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Jerish smells - like obviously - he has a nose.   
    	Robot.driveTrain.rotateDegrees(targetAngle, Robot.gyro.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//double jerishDiff = cool - jerish.cool.getCool()
        double angleDiff = targetAngle - Robot.gyro.getAngle();
    	if (angleDiff < 0.1 &&  angleDiff > -0.1) {
        	return true;
        }
    	
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
