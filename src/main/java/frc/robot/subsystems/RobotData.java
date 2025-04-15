package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotData extends SubsystemBase {

    public static final ShuffleboardTab driveTab = Shuffleboard.getTab("DriveSubsystem");

    public static final NetworkTableEntry leftDist = driveTab.add("leftDist", 0.0).getEntry();
    public static final NetworkTableEntry rightDist = driveTab.add("rightDist", 0.0).getEntry();
    public static final NetworkTableEntry avgDist = driveTab.add("avgDist", 0.0).getEntry();
    public static final NetworkTableEntry leftCount = driveTab.add("leftCount", 0.0).getEntry();
    public static final NetworkTableEntry rightCount = driveTab.add("rightCount", 0.0).getEntry();

    public static final ShuffleboardTab sensorTab = Shuffleboard.getTab("SensorSubsystem");

    public static final NetworkTableEntry yaw = sensorTab.add("Yaw", 0.0).getEntry();
    public static final NetworkTableEntry pitch = sensorTab.add("Pitch", 0.0).getEntry();
    public static final NetworkTableEntry roll = sensorTab.add("Roll", 0.0).getEntry();


    public static final ShuffleboardTab buttonTab = Shuffleboard.getTab("ButtonSubsystem");

    public static final NetworkTableEntry button = buttonTab.add("button status", false).getEntry();


    public static final ShuffleboardTab lampTab = Shuffleboard.getTab("LampSubsystem");

    public static final NetworkTableEntry greenLamp = lampTab.add("green status", false).getEntry();
    public static final NetworkTableEntry redLamp = lampTab.add("red status", false).getEntry();


    public static final ShuffleboardTab visionTab = Shuffleboard.getTab("VisionSubsystem");

}

