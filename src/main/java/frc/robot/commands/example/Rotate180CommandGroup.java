package frc.robot.commands.example;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FakeButtonCommand;
import frc.robot.commands.FakeLampCommand;
import frc.robot.commands.MoveForwardCommand;
import frc.robot.commands.RotateCommand;

public class Rotate180CommandGroup extends SequentialCommandGroup {
    public Rotate180CommandGroup() {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(
                new FakeLampCommand("green", false),
                new FakeLampCommand("red", true),

                new FakeButtonCommand("Start"),

                new FakeLampCommand("green", true),

                new RotateCommand(180),

                new FakeLampCommand("green", false),
                new FakeLampCommand("red", false)
        );
    }
}