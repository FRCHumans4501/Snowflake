package org.firsthumans.recyclerush;

import org.firsthumans.recyclerush.commands.DriveArcade;
import org.firsthumans.recyclerush.commands.DriveIdle;
import org.firsthumans.recyclerush.commands.ElevatorHumanControl;
import org.firsthumans.recyclerush.commands.ElevatorIdle;
import org.firsthumans.recyclerush.subsystems.DriveTrain;
import org.firsthumans.recyclerush.subsystems.Elevator;
import org.firsthumans.recyclerush.subsystems.Gripper;
import org.firsthumans.recyclerush.subsystems.Gripper.GripperState;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	public static final DriveTrain driveTrain = new DriveTrain(
			RobotMap.DRIVE_FRONTLEFTMOTOR, RobotMap.DRIVE_REARLEFTMOTOR,
			RobotMap.DRIVE_FRONTRIGHTMOTOR, RobotMap.DRIVE_REARRIGHTMOTOR,
			RobotMap.DRIVE_STRAFEMOTOR);
	public static final Gripper gripper = new Gripper(
			RobotMap.SOLENOID_GRIPPERFORWARD, RobotMap.SOLENOID_GRIPPERBACKWARD);
	public static final Elevator elevator = new Elevator(
			RobotMap.ANALOG_WINCHMOTOR);
	
	Encoder encoder;
	Gyro gyro;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		encoder = new Encoder(1, 2);
		gyro = new Gyro(0);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		Scheduler.getInstance().add(new DriveArcade());
		Scheduler.getInstance().add(new ElevatorHumanControl());
		gyro.reset();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		Scheduler.getInstance().add(new DriveIdle());
		Scheduler.getInstance().add(new ElevatorIdle());
		gyro.reset();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Encoder Rate", encoder.getRate());
		SmartDashboard.putNumber("Encoder Distance", encoder.getDistance());
		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
		SmartDashboard.putNumber("Gyro Rate", gyro.getRate());
		
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}