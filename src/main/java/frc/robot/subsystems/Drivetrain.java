// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

/* To get import for Rev hardware use this json file: 
https://software-metadata.revrobotics.com/REVLib-2023.json
WPI button -> manage vendor libraries -> install new library (online) */

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  // Declares the motors' variables
  private Spark leftMotorLeader;
  private Spark rightMotorLeader;
  private Spark leftMotorFollower;
  private Spark rightMotorFollower;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    // Initializes the motors to Spark motor objects with pwm channels corresponding to where they're plugged in on the robot
    rightMotorLeader = new Spark(0);
    rightMotorFollower = new Spark(1);
    leftMotorLeader = new Spark(2);
    leftMotorFollower = new Spark(3);
  }

  /* Called once per scheduler run */
  @Override
  public void periodic() {
    // We're not doing anything here to avoid conflicting with our commands!
  }

  /* Sets the motors to given speeds for the left and right sides of the robot */
  public void setPower(double leftPower, double rightPower)
  {
    // The leader and follower *must* be set to the same value because they're physically connected on the robot
    leftMotorLeader.set(-leftPower * 0.5);
    leftMotorFollower.set(-leftPower * 0.5);
    rightMotorLeader.set(rightPower * 0.5);
    rightMotorFollower.set(rightPower * 0.5);
    
    SmartDashboard.putNumber("Right Power", rightPower);
    SmartDashboard.putNumber("Left Power", leftPower);
  }
}