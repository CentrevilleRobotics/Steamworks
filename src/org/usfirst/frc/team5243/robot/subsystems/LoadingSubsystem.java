package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoadingSubsystem extends Subsystem {
    
	private CANTalon loadMotor;
	private CANTalon liftMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LoadingSubsystem(){
		loadMotor = new CANTalon(RobotMap.loadMotor);
		liftMotor = new CANTalon(RobotMap.liftMotor);
	}
	public void setLoadMotors(double speed){
		loadMotor.set(speed);
		liftMotor.set(speed);
	}
	public void setLoadMotor(double speed) {
		loadMotor.set(speed);
	}
	public void setLiftMotor(double speed) {
		liftMotor.set(speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

