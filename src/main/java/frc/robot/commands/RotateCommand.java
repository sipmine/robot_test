package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.SensorSubsystem;


public class RotateCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem = RobotContainer.driveSubsystem;
    private final SensorSubsystem sensorSubsystem = RobotContainer.sensorSubsystem;

    //TODO calibrate PID for rotation command
    private final PIDController rotation = new PIDController(0,0,0);

    private final double angle;
    public RotateCommand(double angle) {

        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        this.angle = angle;
        addRequirements(driveSubsystem, sensorSubsystem);
    }

    @Override
    public void initialize() {
        sensorSubsystem.resetNavx();
        rotation.setTolerance(1);
    }

    @Override
    public void execute() {
        double leftSpeed = rotation.calculate(sensorSubsystem.getYaw(), angle);
        double rightSpeed=rotation.calculate(sensorSubsystem.getYaw(), angle);

        driveSubsystem.setMotorLeftSpeed(leftSpeed);
        driveSubsystem.setMotorRightSpeed(rightSpeed);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return rotation.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setMotorRightSpeed(0);
        driveSubsystem.setMotorLeftSpeed(0);
    }
}
