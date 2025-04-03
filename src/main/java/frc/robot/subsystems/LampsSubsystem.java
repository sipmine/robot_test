package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LampsSubsystem extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this LampsSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static LampsSubsystem INSTANCE = new LampsSubsystem();

    private final DigitalOutput greenLamp;
    private final DigitalOutput redLamp;
    /**
     * Returns the Singleton instance of this LampsSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code LampsSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static LampsSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this LampsSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private LampsSubsystem() {
        greenLamp = new DigitalOutput(Constants.GREEN_LAMP);
        redLamp = new DigitalOutput(Constants.RED_LAMP);
    }

    public void setGreenLamp(boolean status){
        greenLamp.set(status);
    }

    public void setRedLamp(boolean status){
        redLamp.set(status);
    }


    @Override
    public void periodic() {
        RobotData.greenLamp.setBoolean(greenLamp.get());
        RobotData.redLamp.setBoolean(redLamp.get());
    }
}

