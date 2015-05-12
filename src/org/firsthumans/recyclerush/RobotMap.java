package org.firsthumans.recyclerush;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public enum DriveMode { 
		ARCADE,
		GYRO,
		ENCODER,
		ENCODER_PLUS_GYRO
	}
	
	// Drive Analog Channels
	public static final int DRIVE_FRONTLEFTMOTOR = 0, DRIVE_FRONTRIGHTMOTOR = 1,
			DRIVE_REARLEFTMOTOR = 2, DRIVE_REARRIGHTMOTOR = 3,
			DRIVE_STRAFEMOTOR = 4;

	// Other Motor Analog Channels
	public static final int ANALOG_WINCHMOTOR = 5;
	
	// CAN Channels for Talon SRX
	public static final int INTAKE_RIGHTMOTOR = 2, INTAKE_LEFTMOTOR = 3;

	// Sensor Digital Channels
	public static final int DIGITAL_GYRO = 0;

	// Limit Switches
	public static final int LIMIT_DOWN = 0, LIMIT_UP = 1, LIMIT_INTAKE = 2;

	// Encoder Digital Channels
	public static final int ENCODER_FL_A = 6, ENCODER_FL_B = 7, // Front Left
			ENCODER_FR_A = 8, ENCODER_FR_B = 9, // Front Right
			ENCODER_RL_A = 2, ENCODER_RL_B = 3, // Rear Left
			ENCODER_RR_A = 4, ENCODER_RR_B = 5; // Rear Right

	// Solenoid Channel Maps
	public static final int SOLENOID_GRIPPERFORWARD = 3,
			SOLENOID_GRIPPERBACKWARD = 2,
			SOLENOIDE_INTAKEFORWARD = 0,
			SOLENOIDE_INTAKEBACKWARD = 1;

	// PID Constants for DriveTrain
	public static final double DRIVEPID_Kp = 0.03, DRIVEPID_Ki = 0,
			DRIVEPID_Kd = 0;
}