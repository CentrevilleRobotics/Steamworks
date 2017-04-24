package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;
import org.usfirst.frc.team5243.robot.commands.MecanumDriveCommand;
import org.usfirst.frc.team5243.robot.commands.TankDriveCommand;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Victor;
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
    AHRS gyro;
    
    //declare drive commands
    MecanumDriveCommand mecanumDrive;
    TankDriveCommand tankDrive;
    
    //initializes motors(CANTalon), gyro,
    public DriveSubsystem(){
    	System.out.println("DriveSubsystem Constructor");
    	frontLeft = new CANTalon(RobotMap.FrontLeft);
    	frontRight = new CANTalon(RobotMap.FrontRight);
    	backLeft = new CANTalon(RobotMap.BackLeft);
    	backRight = new CANTalon(RobotMap.BackRight);
    	robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	robotDrive.setSafetyEnabled(false);
		gyro = new AHRS(SPI.Port.kMXP);
		//set acceleration rate of voltage on motors
		//frontRight.setVoltageRampRate(24);
    	//backRight.setVoltageRampRate(24);
    	//frontLeft.setVoltageRampRate(24);
    	//backLeft.setVoltageRampRate(24);
		
		//Invert necessary motors
    	frontRight.setInverted(true);
    	backRight.setInverted(true);
    	
    }
    
    //resets gyro angle
    public void resetGyro(){
    	gyro.reset();
    }
    
    //initializes command for mecanum drive & tank drive
    public void commandInitializer(){
		mecanumDrive = new MecanumDriveCommand();
		tankDrive = new TankDriveCommand();		
    }
    
    //strafes robot right
    public void strafeRight(double speed) {
    	/*if(speed > .1){
    		speed = .1;
    	}else if(speed < -.1){
    		speed = .1;
    	}*/
    	frontRight.set(-speed);
    	frontLeft.set(speed);
    	backLeft.set(-speed);
    	backRight.set(speed);
    }
    
    //strafes robot left
    public void strafeLeft(double speed) {
    	strafeRight(-speed);
    }
    
    
    //returns gyro angle
    public double getGyroAngle(){
    	return gyro.getYaw();
    }
    
    //returns gyro rate
    public double getGyroRate(){
    	return gyro.getRate();
    }
    
    
    public void tankDrive(){ // tank drive
    	robotDrive.tankDrive(-Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getY());
    }
    
    public void mecanumDrive(){ // mecanum drive
        robotDrive.mecanumDrive_Cartesian(Robot.oi.getLeftStick().getX(),-Robot.oi.getLeftStick().getY(),Robot.oi.getRightStick().getX(),gyro.getAngle());
    }
    
    //turns bot in place
    public void turn(double speed){
    	/*if(speed > .1){
    		speed = .1;
    	}else if(speed < -.1){
    		speed = -.1;
    	}*/
    	frontLeft.set(-speed);
    	frontRight.set(speed);
    	backLeft.set(-speed);
    	backRight.set(speed);
    }
    
    //turn left at speed
    public void turnLeft(double speed){
    	/*if(speed > .1){
    		speed = .1;
    	}else if(speed < -.1){
    		speed = -.1;
    	}*/
    	frontLeft.set(-speed);
    	backLeft.set(-speed);
    	frontRight.set(speed);
    	backRight.set(speed);    	
    }
    
    //turn right at speed
    public void turnRight(double speed){
    	/*if(speed > .1){
    		speed = .1;
    	}else if(speed < -.1){
    		speed = -.1;
    	}*/
    	frontLeft.set(speed);
    	backLeft.set(speed);
    	frontRight.set(-speed);
    	backRight.set(-speed);
    }
    
    //sets all motors to one speed
    public void setAllMotors(double speed){
    	/*if(speed > .1){
    		speed = .1;
    	}else if(speed < -.1){
    		speed = -.1;
    	}*/
    	frontLeft.set(speed);
    	frontRight.set(speed);
    	backLeft.set(speed);
    	backRight.set(speed);
    }
    
    //sets default command to mecanum
    public void initDefaultCommand() {
       setDefaultCommand(mecanumDrive);
    }
    
    //allows driver to switch between mecanum and tank drive
    public void changeDefaultCommand() {
    	if(getDefaultCommand().equals(mecanumDrive)) setDefaultCommand(tankDrive);
    	else setDefaultCommand(mecanumDrive);
    }
    
    //returns current robotDrive object
    public RobotDrive getDrive() {
    	return robotDrive;
    }
    
    //sets all motors to power 0
    public void stop(){
    	robotDrive.drive(0, 0);
    }
    
    //returns speed of front left motor
    public double getFrontLeftSpeed() {
    	return frontLeft.getSpeed();
    }
    
    //returns speed of back left motor
    public double getBackLeftSpeed() {
    	return backLeft.getSpeed();
    }
    
    //returns speed of front right motor
    public double getFrontRightSpeed() {
    	return frontRight.getSpeed();
    }
    
    //returns speed of back right motor
    public double getBackRightSpeed() {
    	return backRight.getSpeed();
    }
    
    public void improvedStraight(double speed) {
    	//This is equivalent to the code below in the same method.
    	setRight(getGyroAngle() < 0 ? speed + .1 * Math.abs(getGyroAngle()) : speed);
    	setLeft(getGyroAngle() > 0 ? speed + .05 * Math.abs(getGyroAngle()) : speed);
    	
    	System.out.println("Front Left Speed: " + getFrontLeftSpeed() + "  Gyro Angle: " + .1 * getGyroAngle()) ;
    	/*if(getGyroAngle() < 0) {
    		setRight(speed + .13 * Math.abs(getGyroAngle()));
    		setLeft(speed);
    	} else if(getGyroAngle() > 0) {
    		setRight(speed);
    		setLeft(speed + .13 * Math.abs(getGyroAngle()));
    	} else {
    		setAllMotors(speed);
    	}*/
    }
    
    public void setRight(double speed){
    	frontRight.set(speed);
    	backRight.set(speed);
    }
    
    public void setLeft(double speed){
    	frontLeft.set(speed);
    	backLeft.set(speed);
    }
}