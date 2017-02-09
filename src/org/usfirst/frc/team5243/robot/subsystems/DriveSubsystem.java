package org.usfirst.frc.team5243.robot.subsystems;
<<<<<<< HEAD

=======
>>>>>>> Temporary commits, placeholder autonomous codes for Boiler and Hopper sides
import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor frontLeft;
	private Victor frontRight;
	private Victor backLeft;
	private Victor backRight;
	private RobotDrive drivetrain;
	
	public DriveSubsystem() {
		frontLeft = new Victor(RobotMap.FrontLeft);
		frontRight = new Victor(RobotMap.FrontRight);
		backLeft = new Victor(RobotMap.BackLeft);
		backRight = new Victor(RobotMap.BackRight);
		drivetrain = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
	}

    public void mecanumDrive(){ // mecanum drive
    	/*frontRight.setInverted(true);
    	backRight.setInverted(true);*/
        robotDrive.mecanumDrive_Cartesian(-Robot.oi.getLeftStick().getX(),Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getX(),gyro.getAngle());
    }
    
    public void driveStraight(double distance) {
    	frontLeft.set(distance);
    	frontRight.set(distance);
    	backLeft.set(distance);
    	backRight.set(distance);
    }
    public void turn(double y){
    	frontLeft.set(-y);
    	frontRight.set(y);
    	backLeft.set(-y);
    	backRight.set(y);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    
    public void tankDrive() {
    	drivetrain.tankDrive(Robot.oi.getLeftStick().getY(), Robot.oi.getRightStick().getY());
    }
    
    public void setSafetyEnabled() {
    	drivetrain.setSafetyEnabled(false);
    }
<<<<<<< HEAD
=======
    public void driveBackwards(){
    	frontRight.set(-1);
    	frontLeft.set(-1);
    	backRight.set(-1);
    	backLeft.set(-1);
    }

    public RobotDrive getDrive() {
    	return robotDrive;
    }
    public double getAngle() {
    	return gyro.getAngle();
    }
    
>>>>>>> Temporary commits, placeholder autonomous codes for Boiler and Hopper sides
}
