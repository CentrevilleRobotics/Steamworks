package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShootingSubsystem extends Subsystem {
    
	CANTalon shooter;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
    public ShootingSubsystem(int shootingPort){
		shooter = new CANTalon(shootingPort);
	}
	
	public void shooting(double speed){
		shooter.set(speed);
		System.out.println("shooter: " + shooter.getSpeed());

	}
	public double getSpeed(){
		return shooter.getSpeed();
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

