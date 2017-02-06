package org.usfirst.frc.team5243.robot.subsystems;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShootingSubsystem extends Subsystem {
    
	CANTalon shooter;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	public ShootingSubsystem(int shooterport){
		shooter = new CANTalon(shooterport);
	}
	
	public void shooting(double speed){
		shooter.set(speed);
		System.out.println("Left shooter: " + shooter.getSpeed());
	}
	
    public void initDefaultCommand() {
    	
    }
}

