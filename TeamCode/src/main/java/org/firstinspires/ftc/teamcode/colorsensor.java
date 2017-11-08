package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.BasicOpMode_Iterative;
import org.firstinspires.ftc.robotcontroller.external.samples.PushbotAutoDriveByTime_Linear;

import java.util.concurrent.SynchronousQueue;


@Autonomous(name = "colortest")
//@Disabled
//Created by HYDRA ROBOTICS 10/24/17

public class colorsensor extends LinearOpMode {
    DcMotor left_Drive = null;
    DcMotor right_Drive = null;
    DcMotor winch = null;
    Servo bravo = null;
    Servo charlie = null;
    Servo jewel = null;
    Servo jewel_push = null;
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
            jewel_push = hardwareMap.servo.get("jewel_push");

            sensor = hardwareMap.colorSensor.get("sensor");
            sensor.setI2cAddress(I2cAddr.create8bit(0x3c));


            left_Drive.setDirection(DcMotorSimple.Direction.REVERSE);
            right_Drive.setDirection(DcMotorSimple.Direction.REVERSE);

            waitForStart();

            bravo.setPosition(0);
            charlie.setPosition(1);
            //closes arms
            jewel_push.setPosition(.5);

            winch.setPower(.25);
            Thread.sleep(300);
            winch.setPower(0);
            //lifts winch slowly then stops

            jewel.setPosition(0);
            Thread.sleep(3000);

            //jewel arm goes down

            if (sensor.red() > sensor.blue()) {
                jewel_push.setPosition(0);
                Thread.sleep(7000);

            } else {
                jewel_push.setPosition(1);
                Thread.sleep(7000);
                //if sensing blue, servo pushes red away.
            }

            jewel_push.setPosition(.5);
            jewel.setPosition(1);
            Thread.sleep(1000);
            //return jewel arm back to original position
        }
    }
}