package frc.robot.commands.example;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FakeButtonCommand;
import frc.robot.commands.FakeLampCommand;

public class FakeLampAndButtonCommandGroup extends SequentialCommandGroup {
    public FakeLampAndButtonCommandGroup() {

        super(
                new FakeLampCommand("green", false),
                new FakeLampCommand("red", true),
                new FakeButtonCommand("Start"),
                new FakeLampCommand("green", true)
        );
    }
}