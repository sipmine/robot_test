package frc.robot.subsystems;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IRSharpSubsystem extends SubsystemBase {



    private final AnalogInput sharp;
    private final String name;
    public IRSharpSubsystem(int port, String name) {
        sharp = new AnalogInput(port);
        this.name = name;
    }

    public double getDistance(){
        return (Math.pow(sharp.getAverageVoltage(), -1.2045)) * 27.726;
    }

    @Override
    public void periodic(){
        RobotData.sensorTab.add(name.concat(" Sharp"), getDistance());
    }


}

