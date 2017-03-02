package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionSubsystem extends Subsystem {
    
	//declaration of network table
	NetworkTable table;
	
	//constructor
	public VisionSubsystem(){
		table = NetworkTable.getTable("Smart");	
	}
	
    public void initDefaultCommand() {
    
    }
    
    //returns network table
    public NetworkTable getTable(){
    	return table;
    }
    /**
     * If the offset is positive, need to turn right
     * @return number of pixels from the center of the image the average reflective tape piece is
     */ 
    //returns frontOffset in the X direction
    public double getFrontOffsetX(){
    	return table.getNumber("frontOffsetX", -9001);
    }
    
    //returns frontOffset in the Y direction
    public double getFrontOffsetY(){
    	return table.getNumber("frontOffsetY", -9001);
    }
    
    //returns rearOffset in the X direction
    public double getRearOffsetX(){
    	return table.getNumber("rearOffsetX", -9001);
    }
    
    //returns rearOffset in the Y direction
    public double getRearOffsetY(){
    	return table.getNumber("rearOffsetY", -9001);
    }
    public boolean offsetIsValid(String key){
    	return Math.abs(table.getNumber(key,-9001)) <= 360;
    }
}

