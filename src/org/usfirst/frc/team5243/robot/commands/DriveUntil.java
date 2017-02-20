package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.SensorSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.VisionSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class DriveUntil extends Command {

	private double distanceToWall;
	private SensorSubsystem sensorSubsystem;
	private DriveSubsystem driveSubsystem;
	private VisionSubsystem visionSubsystem;
	private boolean front;
	private NetworkTable table;
	private DriveStraight tempForward;
	private DriveStraight tempBackward;
    public DriveUntil(double inches,boolean front) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	distanceToWall = inches;
    	this.front = front;
    	sensorSubsystem = Robot.sensorSubsystem;
    	driveSubsystem = Robot.driveSubsystem;
    	//visionSubsystem = Robot.visionSubsystem;
    	//this.table = Robot.visionSubsystem.getTable();
    	//tempForward = new DriveStraight(true);
    	//tempBackward = new DriveStraight(false);
    	requires(driveSubsystem);
    	requires(sensorSubsystem);
    	requires(visionSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveSubsystem.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(front){
    		if(visionSubsystem.offsetIsValid("frontOffsetX")){
    			improvedStraight();
    		}else{		
		    	//tempForward.execute();
    			System.out.println("Driving straight, front is " + front);
	    	}  		
    	}else{
    		if(visionSubsystem.offsetIsValid("rearOffsetX")){
    			improvedStraight();
    		}else{
    			//tempBackward.execute();
    			System.out.println("Driving straight, front is " + front);
    		}
    	}
    }
    private void improvedStraight(){
    	if(front){
    		if(Math.abs(table.getNumber("frontOffsetX", 0.0)) > 20.0 || Math.abs(driveSubsystem.getGyroAngle()) > 3.0){
    			// we correct ourselves here
    			if(Math.abs(driveSubsystem.getGyroAngle()) > 3.0){
	    			if(driveSubsystem.getGyroAngle() > 3.0){
	    				driveSubsystem.turnRight(.5);
	    				System.out.println("Turning right, front is " + front);	    				
	    			}else{
	    				driveSubsystem.turnLeft(.5);
	    				System.out.println("Turning left, front is " + front);
    				}
    			}else if(Math.abs(table.getNumber("frontOffsetX", 0.0)) > 20){
    				if(table.getNumber("frontOffsetX", 0.0) > 20.0){
	    				driveSubsystem.strafeLeft(.5);
	    				System.out.println("Strafing left, front is " + front);
	    			}else{
	    				driveSubsystem.strafeRight(.5);
	    				System.out.println("Strafing right, front is " + front);
	    			}
    			}
    		}else{
    			driveSubsystem.setAllMotors(.75);
    			//System.out.println("Driving improved straight, front is " + front);
    		}
    	}else{
    		if(Math.abs(table.getNumber("rearOffsetX", 0.0)) > 20.0 || Math.abs(driveSubsystem.getGyroAngle()) > 3.0){
    			// we correct ourselves here
    			if(Math.abs(driveSubsystem.getGyroAngle()) > 3.0){
	    			if(driveSubsystem.getGyroAngle() > 3.0){
	    				driveSubsystem.turnRight(.5);
	    				System.out.println("Turning right, front is " + front);
	    			}
	    			else{
	    				driveSubsystem.turnLeft(.5);
	    				System.out.println("Turning left, front is " + front);
    				}
    			}else if(Math.abs(table.getNumber("rearOffsetX", 0.0)) > 20){
    				if(table.getNumber("rearOffsetX", 0.0) > 20.0){
	    				driveSubsystem.strafeRight(.5);
	    				System.out.println("Strafing right, front is " + front);
	    			}
	    			else{
	    				driveSubsystem.strafeLeft(.5);
	    				System.out.println("Strafing left, front is " + front);
	    			}
    			}
    		}else{ 
    			driveSubsystem.setAllMotors(1);
    			System.out.println("Driving improved straight, front is " + front);
    		}
    	}
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(front){
    		//System.out.println("Finished, front is " + front);
    		return sensorSubsystem.getUltrasonicFrontValue() < distanceToWall;
    	}
    	else{
    		//System.out.println("Finished, front is " + front);
    		return sensorSubsystem.getUltrasonicBackValue() < distanceToWall;
    	}
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.setAllMotors(0);
    	System.out.println("Ended, stopping motors, front is " + front);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
