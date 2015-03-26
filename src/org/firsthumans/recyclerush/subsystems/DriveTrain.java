package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;
import org.firsthumans.recyclerush.commands.DriveIdle;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	RobotDrive drive;
	Talon strafeWheel;
	
	Talon frontLeftTalon;
	Talon frontRightTalon;
	Talon rearLeftTalon;
	Talon rearRightTalon;

	float heading;

	public DriveTrain() {
		this.frontLeftTalon = new Talon(RobotMap.DRIVE_FRONTLEFTMOTOR);
		this.frontRightTalon = new Talon(RobotMap.DRIVE_FRONTRIGHTMOTOR);
		this.rearLeftTalon = new Talon(RobotMap.DRIVE_REARLEFTMOTOR);
		this.rearRightTalon = new Talon(RobotMap.DRIVE_REARRIGHTMOTOR);
		
		drive = new RobotDrive(frontLeftTalon, rearLeftTalon, frontRightTalon, rearRightTalon);
		strafeWheel = new Talon(RobotMap.DRIVE_STRAFEMOTOR);
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
	
	public void rotateDegrees(double targetAngle, double currentAngle) {
		double rotate = (targetAngle - currentAngle) * 0.01;
		
		this.arcadeDrive(0, 0, rotate);
	}
	
	/*float maxEncoderRate = 0;
	float minEncoderRate = 0;
	public void logEncoderValues() {
		Robot.logNumber("Encoder 1 Rate", rearLeftEncoder.getRate());
		Robot.logNumber("Encoder 1 Distance", rearLeftEncoder.getDistance());
		if (rearLeftEncoder.getRate() > maxEncoderRate) maxEncoderRate = (float)rearLeftEncoder.getRate();
		if (rearLeftEncoder.getRate() < minEncoderRate) minEncoderRate = (float)rearLeftEncoder.getRate();
		
		Robot.logNumber("Encoder 2 Rate", rearRightEncoder.getRate());
		Robot.logNumber("Encoder 2 Distance", rearRightEncoder.getDistance());
		if (rearRightEncoder.getRate() > maxEncoderRate) maxEncoderRate = (float)rearRightEncoder.getRate();
		if (rearRightEncoder.getRate() < minEncoderRate) minEncoderRate = (float)rearRightEncoder.getRate();
		
		Robot.logNumber("Encoder 3 Rate", frontLeftEncoder.getRate());
		Robot.logNumber("Encoder 3 Distance", frontLeftEncoder.getDistance());
		if (frontLeftEncoder.getRate() > maxEncoderRate) maxEncoderRate = (float)frontLeftEncoder.getRate();
		if (frontLeftEncoder.getRate() < minEncoderRate) minEncoderRate = (float)frontLeftEncoder.getRate();
		
		Robot.logNumber("Encoder 4 Rate", frontRightEncoder.getRate());
		Robot.logNumber("Encoder 4 Distance", frontRightEncoder.getDistance());
		if (frontRightEncoder.getRate() > maxEncoderRate) maxEncoderRate = (float)frontRightEncoder.getRate();
		if (frontRightEncoder.getRate() < minEncoderRate) minEncoderRate = (float)frontRightEncoder.getRate();
		
		Robot.logNumber("Maximum Encoder Rate", maxEncoderRate);
		Robot.logNumber("MinimumEncoder Rate", minEncoderRate);
		
		double avgEncoderRate = (rearLeftEncoder.getRate() + rearRightEncoder.getRate() + frontLeftEncoder.getRate() + frontRightEncoder.getRate()) / 4;
		Robot.logNumber("Encoder Avg Rate", avgEncoderRate);
		
		double avgEncoderDistance = (rearLeftEncoder.getDistance() + rearRightEncoder.getDistance() + frontLeftEncoder.getDistance() + frontRightEncoder.getDistance()) / 4;
		Robot.logNumber("Encoder Avg Distance", avgEncoderDistance);
	}
	
	public void resetEncoders() {
		rearLeftEncoder.reset();
		rearRightEncoder.reset();
		frontLeftEncoder.reset();
		frontRightEncoder.reset();
	}*/
}
