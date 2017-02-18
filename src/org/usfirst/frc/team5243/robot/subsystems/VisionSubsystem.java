package org.usfirst.frc.team5243.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class VisionSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	NetworkTable table;
	
	public VisionSubsystem(){
		NetworkTable.shutdown();
        NetworkTable.setClientMode();
        System.out.println("Client Mode set");
       // NetworkTable.setIPAddress("10.52.43.30");
        //System.out.println("IP Address set");
        NetworkTable.initialize();
        System.out.println("NT init");
		table = NetworkTable.getTable("Smart");	
	}
    public void initDefaultCommand() {
    }
    public NetworkTable getTable(){
    	return table;
    }
    /**
     * If the offset is positive, need to turn right
     * @return number of pixels from the center of the image the average reflective tape piece is
     */
    public double getFrontOffsetX(){ // positive then turn right
    	return table.getNumber("frontOffsetX", -9001);
    }
    public double getFrontOffsetY(){
    	return table.getNumber("frontOffsetY", -9001);
    }
    public double getRearOffsetX(){
    	return table.getNumber("rearOffsetX", -9001);
    }
    public double getRearOffsetY(){
    	return table.getNumber("rearOffsetY", -9001);
    }
    public boolean offsetIsGood(String key){
    	return table.getNumber(key, -9001) < -1000;
    }
    
}

