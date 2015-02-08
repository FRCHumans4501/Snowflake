package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.commands.DriveIdle;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	RobotDrive drive;
	Talon strafeWheel;

	public DriveTrain(int frontLeftMotor, int frontRightMotor,
			int rearLeftMotor, int rearRightMotor, int strafeMotor) {
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor,
				rearRightMotor);
		strafeWheel = new Talon(strafeMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveIdle());
	}

	public void arcadeDrive(double forward, double strafe, double rotate) {
		// TODO(jerish): Implement gyro / encoder drive correction
		drive.arcadeDrive(forward, rotate);
		
		// NOTE(jerish): Strafe motor Inverted
		strafeWheel.set(-strafe);
	}
}
