/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{

    public static final int TITAN_ID = 42;


    public static final int MOTOR_L_ID = 0;
    public static final int MOTOR_R_ID = 1;

    public static final double WHEEL_RADIUS = 0.051;
    public static final int pulsePerRotation = 1446;
    public static final double gearRatio = 1 / 1;
    public static final double encoderPerPulse = pulsePerRotation * gearRatio;

    public static final double DISTENCE_PER_TICK  = (Math.PI * 2 * WHEEL_RADIUS) / encoderPerPulse;
    public static final int BUTTON_ID = 0;
    public static final int GREEN_LAMP = 0;
    public static final int RED_LAMP = 0;


    /**
     *  FLEX DIO (ch 1-11)
     */
    public static final int ULTRASONIC_1_ECHO = 0;
    public static final int ULTRASONIC_1_TRIG= 0;
    public static final int ULTRASONIC_2_ECHO = 0;
    public static final int ULTRASONIC_2_TRIG= 0;

    /**
     *  ANALOG DIO (ch 22-25)
     */

    public static final int IR_SHARP_1 = 0;

    public static final int IR_SHARP_2 = 0;

}
