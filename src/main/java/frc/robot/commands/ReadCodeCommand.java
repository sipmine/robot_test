package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RobotData;
import frc.robot.subsystems.VisionSubsystem;


public class ReadCodeCommand extends CommandBase {

    private final VisionSubsystem visionSubsystem = RobotContainer.visionSubsystem;

    private NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private NetworkTable table = inst.getTable("VisionSubsystem");
    private boolean getNewBarcode;
    private final String correctCode;
    public ReadCodeCommand(String correctCode) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        this.correctCode = correctCode;
        addRequirements(visionSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        getNewBarcode = SmartDashboard.getBoolean("Get New Barcode", false);

        if (getNewBarcode)
        {
            visionSubsystem.readBarcode();
            SmartDashboard.putBoolean("Get New Barcode", false);
        }
    }

    @Override
    public boolean isFinished() {
        String data = table.getEntry("barcodeData").getString("Nothing was read");
        boolean success =correctCode.equals(data);
        SmartDashboard.putBoolean("Success barcode", success);
        return success;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
