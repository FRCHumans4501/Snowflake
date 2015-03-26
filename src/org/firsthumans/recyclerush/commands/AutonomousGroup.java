package org.firsthumans.recyclerush.commands;

import org.firsthumans.recyclerush.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousGroup extends CommandGroup {

	private class AutonomousGroupStage1 extends CommandGroup {
		
		public AutonomousGroupStage1() {
			addParallel(new GripperOpen());
			addSequential(new ElevatorLower());
			addSequential(new DriveForwardForTime(0.5, 1));
		}
		
	}

	private class AutonomousGroupStage2 extends CommandGroup {
		
		public AutonomousGroupStage2() {
			addSequential(new GripperClose());
			//addParallel(new DriveRotateAngle(90));
			addSequential(new ElevatorRaise(2.0));
		}
		
	}

	private class AutonomousGroupStage3 extends CommandGroup {
		
		public AutonomousGroupStage3() {
			addSequential(new DriveForwardForTime(1, 5));			
		}
		
	}
	
	private class AutonomousGroupStage4 extends CommandGroup {
		
		public AutonomousGroupStage4() {
			//addParallel(new DriveRotateAngle(-90));
			addSequential(new ElevatorLower());
			addParallel(new GripperOpen());
			addSequential(new DriveForwardForTime(0.5, -1));
		}
		
	}
		
	public AutonomousGroup() throws InterruptedException {
		/*
		 * Drive Forward + Lower Elevator
		 * Grab Box
		 * Lift Elevator + Rotate 90 degrees
		 * Drive Forward
		 * Rotate 90 degrees + Lower Elevator
		 * Drop Box + Drive backwards
		 */	
		addSequential(new AutonomousGroupStage1());
		addSequential(new AutonomousGroupStage2());
		addSequential(new AutonomousGroupStage3());
		addSequential(new AutonomousGroupStage4());
	}
	
	protected void end() {
		System.out.println("Finished");
	}
	
	public synchronized void start() {
		Robot.gyro.reset();
		
		super.start();
	}
}
