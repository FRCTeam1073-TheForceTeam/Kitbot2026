// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OI;



public class TeleopDriveCommand extends Command {
  OI oi;
  Drivetrain drivetrain;

  double rightVelocity;
  double leftVelocity;

  /** Creates a new TeleopDriveCommand. */
  public TeleopDriveCommand(OI oi, Drivetrain drivetrain) {
    // Initializes drivetrain and OI (they're set to the inputs in the parameters)
    this.oi = oi;
    this.drivetrain = drivetrain;

    rightVelocity = 0.0;
    leftVelocity = 0.0;

    // Use addRequirements() here to declare subsystem dependencies.
    //This makes sure that two commands can't try to move the robot in two different directions at once!
    addRequirements(drivetrain);
  }

  /* Called when the command is initially scheduled. */
  @Override
  public void initialize() {}

  /* Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    // Uses the setPower method from the Drivetrain subsystem
    // Uses percent input from the joysticks which sets the speed [between -1 to 1] to the motors

    rightVelocity = oi.getDriverRightY();
    leftVelocity = oi.getDriverLeftY();

    if(rightVelocity < 0.25){
      rightVelocity = 0;
    }

    if(leftVelocity < 0.25){
      leftVelocity = 0;
    }
    
  }

  /* Called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {
    // Sets motor speeds to 0, so it stops when the command ends
  
  }

  /* Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}
