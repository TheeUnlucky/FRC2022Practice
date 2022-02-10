// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  //private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  //private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  //private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  //private final Joystick m_stick = new Joystick(0);
  //private final Timer m_timer = new Timer();

  private final Joystick joyStick1 = new Joystick(0);
  private final Timer myTimer = new Timer();
  private final TalonSRX talon1 = new TalonSRX(3);

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_rightDrive.setInverted(true);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    myTimer.reset();
    myTimer.stop();
    myTimer.start();
}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    /*if (m_timer.get() > 6.0) { //if timer is under 2 seconds:
      m_robotDrive.arcadeDrive(1.0, 0.0); // drive forwards half speed
    } else { //or else:
      m_robotDrive.arcadeDrive(-1.0, 0.0); // stop robot
    }*/
    if (myTimer.get() < 6.0) {
      talon1.set(TalonSRXControlMode.PercentOutput, 0.3);
    } else {
      talon1.set(TalonSRXControlMode.PercentOutput, 0.0);
    }
  
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
  //  m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
    if (joyStick1.getRawButton(5)){
      talon1.set(TalonSRXControlMode.PercentOutput, 0.3);
    }
    else if (joyStick1.getRawButton(6)){
      talon1.set(TalonSRXControlMode.PercentOutput, -0.3);
    }
    else {
      talon1.set(TalonSRXControlMode.PercentOutput, 0.0);
    }
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
