package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;
import org.firsthumans.recyclerush.commands.DriveIdle;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	RobotDrive drive;
	Talon strafeWheel;

	float heading;

	public DriveTrain(int frontLeftMotor, int frontRightMotor,
			int rearLeftMotor, int rearRightMotor, int strafeMotor) {
		drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor,
				rearRightMotor);
		strafeWheel = new Talon(strafeMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveIdle());
	}

	// TODO(jerish): Implement encoder drive correction
	public void arcadeDrive(double forward, double strafe, double rotate) {
		drive.arcadeDrive(forward, rotate);

		// NOTE(jerish): Strafe motor Inverted
		strafeWheel.set(-strafe);
	}

	public void encoderDrive(double forward, double strafe, double rotate) {

	}

	public void arcadeDriveStraight(double forward, double strafe, double rotate) {
		// DOMAIN: (-0.01, 0.01)
		if (rotate < 0.01 && rotate > -0.01) {
			float angle = (float) Robot.gyro.getAngle();
			float gyroCorrection = (heading - angle)
					* (float) RobotMap.DRIVEPID_Kp;
			Robot.logNumber("Gyro Correction", gyroCorrection);

			this.arcadeDrive(forward, strafe, gyroCorrection);
		} else {
			heading = (float) Robot.gyro.getAngle();

			this.arcadeDrive(forward, strafe, rotate);
		}
	}
}
