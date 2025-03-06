package frc.robot.commands;

import frc.robot.subsystems.PivotSub;
import frc.robot.constants.IntakeConstants;

import com.ctre.phoenix6.controls.PositionVoltage;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class PivotPos0 extends Command {
    private final PivotSub intakePivot;

    public PivotPos0(PivotSub intakePivot) {
        this.intakePivot = intakePivot;
    }
    @Override
    public void execute() {
        // create a position closed-loop request, voltage output, slot 0 configs
        final PositionVoltage m_request = new PositionVoltage(0).withSlot(0);

        // set position to 10 rotations
        intakePivot.setControl(.5);  
    }
}


