package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.JoystickDriveCommand;
import org.usfirst.frc.team5243.robot.commands.JoystickTankDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveSubsystem extends Subsystem {
    Victor frontRight;
    Victor frontLeft;
    Victor backRight;
    Victor backLeft;
    RobotDrive drivetrain;
    
    AnalogGyro gyro;
	public DriveSubsystem(){
    	frontRight = RobotMap.driveFrontRight;
    	frontLeft = RobotMap.driveFrontLeft;
    	backRight = RobotMap.driveBackRight;
    	backLeft = RobotMap.driveBackLeft;
    	drivetrain = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	gyro = RobotMap.gyro;
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDriveCommand());
    }
    public void mecanumDrive(Joystick left, Joystick right){
    	drivetrain.mecanumDrive_Cartesian(left.getX(), left.getY(), right.getX(), gyro.getAngle());    	
    }    
    
    public void tankDrive(Joystick left, Joystick right) {
    	drivetrain.tankDrive(left.getY(), right.getY());
    }
    
    public void driveStraight(){
    	frontRight.set(1);  
    	frontLeft.set(1);
    	backRight.set(1);
    	backLeft.set(1);
    }
    public void strafeLeft(){
    	frontLeft.set(-1);
    	backLeft.set(1);
    	frontRight.set(1);
    	backRight.set(-1);
    }
    public void strafeRight(){
    	frontLeft.set(1);
    	backLeft.set(-1);
    	frontRight.set(-1);
    	backRight.set(1);
    }
    public void driveBackwards(){
    	frontRight.set(-1);
    	frontLeft.set(-1);
    	backRight.set(-1);
    	backLeft.set(-1);
    }
    
    
    
}

