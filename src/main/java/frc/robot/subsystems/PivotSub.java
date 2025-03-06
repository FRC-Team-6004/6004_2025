package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// custom imports
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.constants.IntakeConstants;

public class PivotSub extends SubsystemBase {
    TalonFX intakePivot;
    TalonFX intakeGrab;

    /**
     * This subsystem controls the intake pivot motor.
     */
    public PivotSub() {
        intakePivot = new TalonFX(IntakeConstants.INTAKE_Pivot_ID);

        // Create and configure the TalonFX configuration for the pivot motor
        var intakePivotConfiguration = new TalonFXConfiguration();

        // Set motor output neutral mode to Brake (stop the motor quickly when neutral)
        intakePivotConfiguration.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        // Set the current limits for the motor
        intakePivotConfiguration.CurrentLimits.SupplyCurrentLimit = 55;
        intakePivotConfiguration.CurrentLimits.SupplyCurrentLimitEnable = true;

        // PID control values for position control (Slot 0 settings)
        intakePivotConfiguration.Slot0.kP = 1.5;
        intakePivotConfiguration.Slot0.kI = 0.0;
        intakePivotConfiguration.Slot0.kD = 0.1;
        intakePivotConfiguration.Slot0.kG = 1;
        intakePivotConfiguration.Slot0.GravityType = GravityTypeValue.Arm_Cosine;

        // Ensure the motor is in position control mode (using PID)
        intakePivot.setControl(new PositionVoltage(0).withSlot(0));  // This sets the motor controller into position control mode
    }

    /**
     * Moves the pivot to a specified position using PID control.
     * 
     * @param pos The target position in encoder units (e.g., in terms of rotations or a unit that matches your system)
     */
    public void setControl(double pos) {
        // Create a position control request with the target position and PID settings
        PositionVoltage positionRequest = new PositionVoltage(0).withSlot(0).withPosition(pos);

        // Set the position control for the intake pivot motor
        intakePivot.setControl(positionRequest); 

        System.out.println("Moving to position: " + pos);  // Print the target position for debugging
    }

    @Override
    public void periodic() {
        // Periodic code, could be used for logging or debugging motor status
        //double currentPosition = intakePivot.getPosition().getValue();
        //System.out.println("Current Position: " + currentPosition);
    }

    /** 
     * A method that moves the pivot motor at a given speed.
     * Positive values move the motor forward, negative values move it in reverse.
     * 
     * @param speed motor speed from -1.0 to 1.0, with 0 stopping the motor.
     */
    public void movePivot(double speed) {
        intakePivot.set(speed); // Move motor at the specified speed
    }
}
