/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutoCommandGroup;
import frc.robot.commands.example.FakeLampAndButtonCommandGroup;
import frc.robot.commands.example.Move1MCommandGroup;
import frc.robot.commands.example.ReadBarcodeCommandGroup;
import frc.robot.commands.example.Rotate180CommandGroup;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    public static final DriveSubsystem driveSubsystem = DriveSubsystem.getInstance();
    public static final SensorSubsystem sensorSubsystem = SensorSubsystem.getInstance();

    public static final UltrasonicSubsystem ultrasonic_1 = new UltrasonicSubsystem(Constants.ULTRASONIC_1_TRIG, Constants.ULTRASONIC_1_TRIG, "first");
    public static final UltrasonicSubsystem ultrasonic_2 = new UltrasonicSubsystem(Constants.ULTRASONIC_2_TRIG, Constants.ULTRASONIC_2_TRIG, "second");

    public static final IRSharpSubsystem sharp_1 = new IRSharpSubsystem(Constants.IR_SHARP_1, "first");
    public static final IRSharpSubsystem sharp_2 = new IRSharpSubsystem(Constants.IR_SHARP_2, "second");



    // public static final ButtonSubsystem buttonSubsystem = ButtonSubsystem.getInstance();

    // public static final LampsSubsystem lampSubsystem = LampsSubsystem.getInstance();

    public static final VisionSubsystem visionSubsystem = new VisionSubsystem();

    //TODO main

    public static final Command autocommand = new AutoCommandGroup();

    //TODO example 1 meter move

    // public static final Command autocommand = new Move1MCommandGroup();

    //TODO example rotate 180

    // public static final Command autocommand = new Rotate180CommandGroup();

    //TODO example read QR code (barcode)

    // public static final Command autocommand = new ReadBarcodeCommandGroup();

    //TODO example FakeLampAndButton

    // public static final Command autocommand = new FakeLampAndButtonCommandGroup();


    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings() {

    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return autocommand;
    }
}
