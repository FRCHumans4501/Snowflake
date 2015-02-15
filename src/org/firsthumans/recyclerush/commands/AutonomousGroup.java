package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {

	public AutonomousGroup() {
		addSequential(new DriveStraightForTime(0.5, 5.0));
	}
	
	public synchronized void start() {
		Robot.gyro.reset();
		
		super.start();
	}
}
