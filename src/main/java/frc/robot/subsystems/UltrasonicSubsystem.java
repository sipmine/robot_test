package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class UltrasonicSubsystem extends SubsystemBase {

    private final Ultrasonic ultrasonic;

    private final String name;
    public UltrasonicSubsystem(int trig, int echo, String name) {
        ultrasonic = new Ultrasonic(trig, echo);
        this.name = name;
    }

    public double getDistance(){
        return ultrasonic.getRangeMM();
    }

    @Override
    public  void  periodic(){
        RobotData.sensorTab.add(name.concat(" Ultrasonic"), getDistance());
    }
}

