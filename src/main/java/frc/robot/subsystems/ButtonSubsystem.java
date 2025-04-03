package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ButtonSubsystem extends SubsystemBase {


    /**
     * The Singleton instance of this ButtonSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static ButtonSubsystem INSTANCE = new ButtonSubsystem();


    private final DigitalInput button;
    /**
     * Returns the Singleton instance of this ButtonSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code ButtonSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static ButtonSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this ButtonSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private ButtonSubsystem() {
        button = new DigitalInput(Constants.BUTTON_ID);
    }

    public boolean getButtonStatus(){
        return !button.get();
    }

    @Override
    public void periodic() {
        RobotData.button.setBoolean(getButtonStatus());
    }
}

