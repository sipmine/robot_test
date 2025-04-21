package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.SensorSubsystem;


public class MoveForwardCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem = RobotContainer.driveSubsystem;
    private final SensorSubsystem sensorSubsystem = RobotContainer.sensorSubsystem;

    //TODO calibrate PID for move command
    private final PIDController forward = new PIDController(0.5,0,0);
    private final PIDController rotation = new PIDController(0.005,0,0);

    private final double distance;
    public MoveForwardCommand(double distance) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        this.distance = distance;
        addRequirements(driveSubsystem, sensorSubsystem);
    }

    @Override
    public void initialize() {
        sensorSubsystem.resetNavx();
        forward.setTolerance(0.05);
        rotation.setTolerance(1);
    }

    @Override
    public void execute() {
        double leftSpeed = forward.calculate(driveSubsystem.getAvgDistance(), distance) - rotation.calculate(sensorSubsystem.getYaw(), 0);
        double rightSpeed = forward.calculate(driveSubsystem.getAvgDistance(), distance) + rotation.calculate(sensorSubsystem.getYaw(), 0);

        driveSubsystem.setMotorLeftSpeed(leftSpeed);
        driveSubsystem.setMotorRightSpeed(-rightSpeed);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return forward.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.setMotorRightSpeed(0);
        driveSubsystem.setMotorLeftSpeed(0);
    }
}
