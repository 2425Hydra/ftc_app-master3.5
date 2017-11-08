package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;
import org.firstinspires.ftc.robotcontroller.external.samples.PushbotAutoDriveByTime_Linear;

import java.util.concurrent.SynchronousQueue;


@Autonomous(name = "Blue")
//@Disabled
//Created by HYDRA ROBOTICS 10/24/17

public class Two4Autonomous extends LinearOpMode {
    DcMotor left_Drive = null;
    DcMotor right_Drive = null;
    DcMotor winch = null;
    Servo bravo = null;
    Servo charlie = null;
    Servo jewel = null;
    ColorSensor sensor = null;


    @Override
    public void runOpMode() throws InterruptedException {
        {


            left_Drive = hardwareMap.dcMotor.get("left_Drive");
            right_Drive = hardwareMap.dcMotor.get("right_Drive");
            winch = hardwareMap.dcMotor.get("winch");
            bravo = hardwareMap.servo.get("bravo");
            charlie = hardwareMap.servo.get("charlie");
            jewel = hardwareMap.servo.get("jewel");
            sensor = hardwareMap.colorSensor.get("sensor");

            bravo.setPosition(0);
            charlie.setPosition(1);


            left_Drive.setDirection(DcMotorSimple.Direction.REVERSE);
            right_Drive.setDirection(DcMotorSimple.Direction.REVERSE);

            waitForStart();

            sensor.enableLed(true);
            jewel.setPosition(1);
            if (sensor.red() >= 8) {
                left_Drive.setPower(1);
                right_Drive.setPower(1);
                Thread.sleep(300);
            }
            if (sensor.blue() <= 3) {
                left_Drive.setPower(-1);
                right_Drive.setPower(-1);
                Thread.sleep(100);
            }
            jewel.setPosition(0);
        }
    }
}
