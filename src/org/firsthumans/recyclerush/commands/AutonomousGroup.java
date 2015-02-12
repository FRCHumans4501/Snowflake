package org.firsthumans.recyclerush.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {

	public AutonomousGroup() {
		addSequential(new DriveStraightForTime(0.2, 5.0));
	}
}
