package org.firsthumans.recyclerush.subsystems;

import edu.wpi.first.wpilibj.Encoder;

public class EncoderDriveTrain extends DriveTrain {
	
	Encoder frontLeftEncoder;
	Encoder rearLeftEncoder;
	Encoder frontRightEncoder;
	Encoder rearRightEncoder;
	
	public EncoderDriveTrain(int frontLeftMotor, int frontRightMotor,
			int rearLeftMotor, int rearRightMotor, int strafeMotor,
			int frontLeftEncoderChannel, int rearLeftEncoderChannel,
			int frontRightEncoderChannel, int rearRightEncoderChannel) {
		//frontLeftEncoder = new 
		
		super(frontLeftMotor, frontRightMotor, rearLeftMotor, rearRightMotor, strafeMotor);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
