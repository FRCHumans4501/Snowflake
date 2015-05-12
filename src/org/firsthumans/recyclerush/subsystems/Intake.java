package org.firsthumans.recyclerush.subsystems;

import org.firsthumans.recyclerush.Robot;
import org.firsthumans.recyclerush.RobotMap;
import org.firsthumans.recyclerush.commands.IntakeIdle;
import org.firsthumans.recyclerush.subsystems.Elevator.Direction;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	CANTalon leftMotor;
	CANTalon rightMotor;

	DoubleSolenoid solenoid;

	DigitalInput elevatorLimitSwitch;
	boolean lastSwitchState;

	public Intake() {
		this.leftMotor = new CANTalon(RobotMap.INTAKE_LEFTMOTOR);
		this.rightMotor = new CANTalon(RobotMap.INTAKE_RIGHTMOTOR);
		this.solenoid = new DoubleSolenoid(RobotMap.SOLENOIDE_INTAKEFORWARD, RobotMap.SOLENOIDE_INTAKEBACKWARD);		
		this.elevatorLimitSwitch = new DigitalInput(RobotMap.LIMIT_INTAKE);
		
		//this.close();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new IntakeIdle());
	}

	public void idle() {
		leftMotor.set(0);
		rightMotor.set(0);
		//this.solenoid.set(this.solenoid.get());

		boolean elevatorSwitchState = elevatorLimitSwitch.get();
		if (elevatorSwitchState == true && lastSwitchState == false && Robot.elevator.getDirection() == Direction.DOWN) {
			this.open();
			System.out.println("Elevator Intake Open");
		}

		this.lastSwitchState = elevatorSwitchState;
	}

	public void open() {
		this.solenoid.set(Value.kForward);
	}

	public void close() {
		this.solenoid.set(Value.kReverse);
	}

	public void load() {
		leftMotor.set(-1);
		rightMotor.set(-1);
	}

	public void unload() {
		leftMotor.set(1);
		rightMotor.set(1);
	}
}
