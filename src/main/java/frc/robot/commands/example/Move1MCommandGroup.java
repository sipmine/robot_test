package frc.robot.commands.example;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FakeButtonCommand;
import frc.robot.commands.FakeLampCommand;
import frc.robot.commands.MoveForwardCommand;

public class Move1MCommandGroup extends SequentialCommandGroup {
    public Move1MCommandGroup() {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(
                new FakeLampCommand("green", false),
                new FakeLampCommand("red", true),

                new FakeButtonCommand("Start"),

                new FakeLampCommand("green", true),

                new MoveForwardCommand(1),

                new FakeLampCommand("green", false),
                new FakeLampCommand("red", false)
        );
    }
}