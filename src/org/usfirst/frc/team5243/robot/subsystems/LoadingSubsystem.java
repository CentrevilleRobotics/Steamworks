package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LoadingSubsystem extends Subsystem {
    
	private CANTalon loading;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LoadingSubsystem(){
		loading = new CANTalon(RobotMap.loading);
	}
	public void setLoadSpeed(double speed){
		loading.set(speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

