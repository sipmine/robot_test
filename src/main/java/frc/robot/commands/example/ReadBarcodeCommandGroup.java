package frc.robot.commands.example;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FakeButtonCommand;
import frc.robot.commands.FakeLampCommand;
import frc.robot.commands.ReadCodeCommand;

public class ReadBarcodeCommandGroup extends SequentialCommandGroup {
    public ReadBarcodeCommandGroup() {

        super(
                new FakeLampCommand("green", false),
                new FakeButtonCommand("Start"),
                new ReadCodeCommand("21"),
                new FakeLampCommand("green", true)
        );
    }
}