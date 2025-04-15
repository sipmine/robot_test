package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class FakeLampCommand extends CommandBase {

    private final String lampName;
    private final Boolean status;
    public FakeLampCommand(String lampName, boolean status) {
        this.lampName = lampName;
        this.status = status;
        addRequirements();
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean(lampName+" lamp", status);

    }


    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return true;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
