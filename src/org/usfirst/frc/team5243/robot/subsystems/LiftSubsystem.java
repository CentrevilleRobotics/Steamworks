package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.Lift;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private CANTalon liftMotor;
	Lift liftCommand;
	public LiftSubsystem(){
		liftMotor = new CANTalon(RobotMap.liftPort);
	}
	
	public CANTalon getLiftMotor(){
		return liftMotor;
	}
	
	public void setLiftMotor(double speed){
		liftMotor.set(speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	public void commandInitializer() {
		// TODO Auto-generated method stub
		liftCommand = new Lift(0.0);
	}
}

