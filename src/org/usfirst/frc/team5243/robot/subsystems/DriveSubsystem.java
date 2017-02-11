package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.MecanumDriveCommand;
import org.usfirst.frc.team5243.robot.commands.TankDriveCommand;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

	//declares motors (CANTalons), gyro, 
	CANTalon frontLeft;
    CANTalon backLeft;
    CANTalon frontRight;
    CANTalon backRight;
    RobotDrive robotDrive;
    ADXRS450_Gyro gyro;
    
    MecanumDriveCommand mecanumDrive;
    TankDriveCommand tankDrive;
    
    //initializes motors(CANTalon), gyro,
    public DriveSubsystem(){
    	frontLeft = new CANTalon(RobotMap.frontLeft);
    	frontRight = new CANTalon(RobotMap.frontRight);
    	backLeft = new CANTalon(RobotMap.backLeft);
    	backRight = new CANTalon(RobotMap.backRight);
    	robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	robotDrive.setSafetyEnabled(false);
		gyro = new ADXRS450_Gyro();
		
		
		frontRight.setInverted(true);
    	backRight.setInverted(true);
    	frontLeft.setInverted(false);
    	backLeft.setInverted(false);
    }
    
    //initializes command for mecanum drive & tank drive
    public void commandInitializer(){
		mecanumDrive = new MecanumDriveCommand();
		tankDrive = new TankDriveCommand();
    }
    public void calibrateGyro() {
    	gyro.calibrate();
    }
    public void printGyroAngle(){
    	System.out.println("Gyro Angle: " + gyro.getAngle());
    }    
    public void tankDrive(){ // tank drive
    	robotDrive.tankDrive(-Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getY());
    }

    public void mecanumDrive(){ // mecanum drive
    	/*frontRight.setInverted(true);
    	backRight.setInverted(true);*/
        robotDrive.mecanumDrive_Cartesian(-Robot.oi.getLeftStick().getX(),Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getX(),gyro.getAngle());
    }
    
    public void turn(double y){
    	frontLeft.set(-y);
    	frontRight.set(y);
    	backLeft.set(-y);
    	backRight.set(y);
    }
    public void initDefaultCommand() {
       setDefaultCommand(mecanumDrive);
    }
    public void changeDefaultCommand() {
    	if(getDefaultCommand().equals(mecanumDrive)) setDefaultCommand(tankDrive);
    	else setDefaultCommand(mecanumDrive);
    }
    public void stop(){
    	robotDrive.drive(0, 0);
    }
    public CANTalon getFrontLeft(){
    	return frontLeft;
    }
    public CANTalon getBackLeft(){
    	return backLeft;    	
    }
    public CANTalon getFrontRight(){
    	return frontRight;    	
    }
    public CANTalon getBackRight(){
    	return backRight;
    }
}