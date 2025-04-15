package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class FakeButtonCommand extends CommandBase {

    private final String buttonName;
    public FakeButtonCommand(String buttonName) {
        this.buttonName = buttonName;
        addRequirements();
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean(buttonName + " Button", false);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return SmartDashboard.getBoolean(buttonName + " Button",false);
    }


}
