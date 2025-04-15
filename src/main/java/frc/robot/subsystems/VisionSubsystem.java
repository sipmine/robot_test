package frc.robot.subsystems;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    private final NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private final NetworkTable table = inst.getTable("VisionSubsystem");

    private NetworkTableEntry data;
    public VisionSubsystem() {
        SmartDashboard.putBoolean("Get new barcode", false);
    }

    public void readBarcode(){
        table.getEntry("readBarcode").setBoolean(true);
    }


    public void printBarcode()
    {
        data = table.getEntry("barcodeData");
        SmartDashboard.putString("Barcode Data", data.getString("Nothing was read"));
    }

    @Override
    public void periodic()
    {
        printBarcode();
    }
}

