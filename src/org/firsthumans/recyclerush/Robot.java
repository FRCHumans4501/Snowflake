package org.firsthumans.recyclerush;

import org.firsthumans.recyclerush.commands.DriveArcade;
import org.firsthumans.recyclerush.commands.DriveForwardForTime;
import org.firsthumans.recyclerush.commands.DriveIdle;
import org.firsthumans.recyclerush.commands.ElevatorHumanControl;
import org.firsthumans.recyclerush.commands.ElevatorIdle;
import org.firsthumans.recyclerush.subsystems.DriveTrain;
import org.firsthumans.recyclerush.subsystems.Elevator;
import org.firsthumans.recyclerush.subsystems.Gripper;
import org.firsthumans.recyclerush.subsystems.Intake;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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

	// Subsystems
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Gripper gripper = new Gripper();
	public static final Elevator elevator = new Elevator();
	public static final Intake intake = new Intake();

	public static Gyro gyro;

	SendableChooser autonomousChooser;
	Command autonomousCommand;

	// TODO(Sandy):Had to disable cam stuff
	// CameraServer server;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();

		gyro = new Gyro(RobotMap.DIGITAL_GYRO);
		
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Auto Mode Off", new DriveIdle());
		autonomousChooser.addObject("Auto On", new DriveForwardForTime(1/3, 2.0));
		SmartDashboard.putData("Auto Chooser", autonomousChooser);

		/*
		 * try { autonomousCommand = new AutonomousGroup(); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		/*
		 * TODO(Sandy):Had to disable cam stuff server =
		 * CameraServer.getInstance(); server.setQuality(50);
		 * server.startAutomaticCapture("cam0");
		 */
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		gyro.reset();
		//driveTrain.resetEncoders();
		
		autonomousCommand = (Command)autonomousChooser.getSelected();
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
		
		//driveTrain.resetEncoders();

		gyro.reset();
		
		Scheduler.getInstance().add(new DriveArcade());
		Scheduler.getInstance().add(new ElevatorHumanControl());
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		gyro.reset();

		//driveTrain.resetEncoders();

		Scheduler.getInstance().add(new DriveIdle());
		Scheduler.getInstance().add(new ElevatorIdle());
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		//driveTrain.logEncoderValues();

		Robot.logNumber("Gyro Angle", gyro.getAngle());
		Robot.logNumber("Gyro Rate", gyro.getRate());

		double matchTime = oi.getMatchTime();
		if (matchTime - 120 >= 0) {
			// Increase from 0 to 1/2 over the last 15 seconds of the match
			oi.setRumble((1 / 2) * ((matchTime - 120) / 15));
		}

		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	/**
	 * Logging Functions
	 */
	public static void logNumber(String key, double value) {
		SmartDashboard.putNumber(key, value);
	}

	public static void logString(String key, String value) {
		SmartDashboard.putString(key, value);
	}
}
