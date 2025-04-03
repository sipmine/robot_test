package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SensorSubsystem extends SubsystemBase {

    /**
     * The Singleton instance of this SensorSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static SensorSubsystem INSTANCE = new SensorSubsystem();

    private final AHRS navX;
    /**
     * Returns the Singleton instance of this SensorSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code SensorSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static SensorSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this SensorSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private SensorSubsystem() {
        navX = new AHRS(I2C.Port.kMXP);
    }

    public double getYaw(){
        return navX.getYaw();
    }

    public double getPitch(){
        return navX.getPitch();
    }
    public double getRoll(){
        return navX.getRoll();
    }

    @Override
    public void periodic() {
        RobotData.yaw.setDouble(getYaw());
        RobotData.pitch.setDouble(getPitch());
        RobotData.roll.setDouble(getRoll());
    }
}

