package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.math.util.Units;
import frc.robot.generated.TunerConstants;

import static edu.wpi.first.units.Units.*;

public class constants {

    public static final class ElevatorConstants {
        public static final int LIFT_MAIN = 62;             //PWM
        public static final int LIFT_FOLLOW = 61;             //PWM
        public static final int LIFT_CUR_LMT = 50;   //const

        public static final double LIFT_MOTOR_VOLTAGE_COMP = 10;
        public static final double LIFT_SPEED_DOWN = 0.5;
        public static final double LIFT_SPEED_UP = -0.5;
        public static final double LIFT_HOLD_DOWN = (0.5 * 0.05);
        public static final double LIFT_HOLD_UP = (0.5 * 0.05);

        public static final double LIFT_HEIGHT_1 = 0.0;   //set point 1 is Stowed
        public static final double LIFT_HEIGHT_2 = .55;   //set point 2 is L2
        public static final double LIFT_HEIGHT_3 = 1.55;   //set point 3 is L3
        public static final double LIFT_HEIGHT_4 = 3.15;   //set point 4 is Shallow Climb
        public static final double LIFT_HEIGHT_5 = 2.55;   //set point 5 is max

        public static final double   kElevatorGearing         = 12.0;
        public static final double   kElevatorSproketTeeth    = 22;
        public static final double   kElevatorPitch           = Units.inchesToMeters(0.25);
        public static final double   kElevatorDrumRadius      = (kElevatorSproketTeeth * kElevatorPitch) / (2 * Math.PI);// radius = Circumference / (2 pi)
        // Encoder is reset to measure 0 at the bottom, so minimum height is 0.
        public static final double   kMinElevatorHeightMeters = Units.inchesToMeters(0);//min height / 10
        public static final double   kMaxElevatorHeightMeters = Units.inchesToMeters(30);

      }
   
    public final class TalonFXConstants {
        public static final int COUNTS_PER_REV = 2048;
        public static final double COUNTS_PER_DEG = COUNTS_PER_REV / 360.0;
    
        public static final boolean TALON_FUTURE_PROOF = true; 
        
    
        
    }
    
    public final class IntakeConstants {
      public static final int INTAKE_Pivot_ID=30;
      public static final int INTAKE_Grab_ID= 16;
      
      
      public static final double Pivot_SPEED= .15;
      public static final double Pivot_SPEED_HOLD= -.017;

      public static final double INTAKE_SPEED= .30;
      public static final double INTAKE_SPEED_HOLD= .0;
  
      public static final InvertedValue INTAKE_INVERSION = InvertedValue.Clockwise_Positive;
      public static final NeutralModeValue INTAKE_NEUTRAL_MODE = NeutralModeValue.Brake;
      public static final double INTAKE_POSITION_STATUS_FRAME = 0.05;
      public static final double INTAKE_VELOCITY_STATUS_FRAME = 0.01; 
      
      public static final double PIVOT_POS_0 = 0;
      public static final double PIVOT_POS_1 = 3;
      public static final double PIVOT_POS_2 = 5;  
      public static final double PIVOT_POS_3 = 15;  
      
  
  }

  public final class VisionConstants {
    public static final String CAM_NAME="Replace Me";

  }

  public static class SwerveConstants {
        public static final double kMaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
        public static final double kMaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

        public static final double kTranslationalDeadband = kMaxSpeed * 0.1;
        public static final double kRotationalDeadband = kMaxAngularRate * 0.1;
  }

  public static final class ClimbConstants {
    public static final int LIFT_MAIN = 16;             //PWM
    public static final int LIFT_CUR_LMT = 50;   //const

    public static final double LIFT_MOTOR_VOLTAGE_COMP = 10;
    public static final double LIFT_SPEED_DOWN = 0.5;
    public static final double LIFT_SPEED_UP = -0.5;
    public static final double LIFT_HOLD_DOWN = 0;
    public static final double LIFT_HOLD_UP = 0.17;

    public static final double LIFT_HEIGHT_1 = 0.0;   //set point 1 is Stowed
    public static final double LIFT_HEIGHT_2 = .55;   //set point 2 is L2
    public static final double LIFT_HEIGHT_3 = 1.55;   //set point 3 is L3
    public static final double LIFT_HEIGHT_4 = 3.15;   //set point 4 is Shallow Climb
    public static final double LIFT_HEIGHT_5 = 0;   //set point 5 is max

    public static final double   kElevatorGearing         = 12.0;
    public static final double   kElevatorSproketTeeth    = 22;
    public static final double   kElevatorPitch           = Units.inchesToMeters(0.25);
    public static final double   kElevatorDrumRadius      = (kElevatorSproketTeeth * kElevatorPitch) / (2 * Math.PI);// radius = Circumference / (2 pi)
    // Encoder is reset to measure 0 at the bottom, so minimum height is 0.
    public static final double   kMinElevatorHeightMeters = Units.inchesToMeters(0);//min height / 10
    public static final double   kMaxElevatorHeightMeters = Units.inchesToMeters(30);
  }

}
