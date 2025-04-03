package frc.robot.subsystems;


import com.studica.frc.TitanQuad;
import com.studica.frc.TitanQuadEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

    /**
     * The Singleton instance of this DriveSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static DriveSubsystem INSTANCE = new DriveSubsystem();
    private final TitanQuad motorLeft;
    private final TitanQuad motorRight;

    private final TitanQuadEncoder encoderLeft;
    private final TitanQuadEncoder encoderRight;


    /**
     * Returns the Singleton instance of this DriveSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code DriveSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static DriveSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this DriveSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */

    private DriveSubsystem() {
        motorLeft = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR_L_ID);
        motorRight = new TitanQuad(Constants.TITAN_ID, Constants.MOTOR_R_ID);

        encoderLeft = new TitanQuadEncoder(motorLeft, Constants.MOTOR_L_ID, Constants.DISTENCE_PER_TICK);
        encoderRight = new TitanQuadEncoder(motorRight, Constants.MOTOR_R_ID, Constants.DISTENCE_PER_TICK);


    }

    public void setMotorLeftSpeed(double speed) {
        motorLeft.set(speed);
    }

    public void setMotorRightSpeed(double speed) {
        motorRight.set(speed);
    }

    public double getLeftDistance() {
        return encoderLeft.getEncoderDistance();
    }

    public double getRightDistance() {
        return encoderLeft.getEncoderDistance();
    }

    public double getAvgDistance(){
        return  (getLeftDistance() + getRightDistance()) / 2;
    }

    public double getLeftRaw() {
        return encoderLeft.getRaw();
    }

    public double getRightRaw() {
        return encoderLeft.getRaw();
    }

    @Override
    public void periodic() {
        RobotData.leftDist.setDouble(getLeftDistance());
        RobotData.rightDist.setDouble(getRightDistance());

        RobotData.avgDist.setDouble(getAvgDistance());

        RobotData.leftCount.setDouble(getLeftRaw());
        RobotData.rightCount.setDouble(getRightRaw());
    }
}

