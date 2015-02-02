package org.firsthumans.recyclerush;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Drive Analog Channels
	public static final int DRIVE_FRONTLEFTMOTOR = 0, DRIVE_REARLEFTMOTOR = 1,
			DRIVE_FRONTRIGHTMOTOR = 2, DRIVE_REARRIGHTMOTOR = 3,
			DRIVE_STRAFEMOTOR = 4;

	// Other Motor Analog Channels
	public static final int ANALOG_WINCHMOTOR = 5;

	// Sensor Digital Channels
	public static final int DIGITAL_GYRO = 0;

	// Controller Trigger Maps
	public static final int CONTROLLER_LX = 0, CONTROLLER_LY = 1,
			CONTROLLER_LTRIGGER = 2, CONTROLLER_RTRIGGER = 3,
			CONTROLLER_RX = 4, CONTROLLER_RY = 5;

	// Cotnroller Button Maps
	public static final int BUTTON_A = 1, BUTTON_B = 2, BUTTON_X = 3,
			BUTTON_Y = 4, BUMPER_R = 5, BUMPER_L = 6, BUTTON_BACK = 7,
			BUTTON_START = 8, STICK_L = 9, STICK_R = 10;

	// Solenoid Channel Maps
	public static final int SOLENOID_GRIPPERFORWARD = 0,
			SOLENOID_GRIPPERBACKWARD = 1;
}