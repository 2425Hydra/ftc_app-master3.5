package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;





@TeleOp(name = "Beta")

//Created by HYDRA ROBOTICS 10/24/17

public class FourFour69Op extends OpMode {

    private DcMotor left_Drive;
    private DcMotor right_Drive;
    private DcMotor winch;
    private Servo bravo;
    private Servo charlie;
    private Servo jewel = null;
    Servo jewel_push = null;



    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        left_Drive = hardwareMap.dcMotor.get("left_Drive");
        right_Drive = hardwareMap.dcMotor.get("right_Drive");
        winch = hardwareMap.dcMotor.get("winch");
        bravo = hardwareMap.servo.get("bravo");
        charlie = hardwareMap.servo.get("charlie");
        jewel = hardwareMap.servo.get("jewel");
        jewel_push = hardwareMap.servo.get("jewel_push");



        left_Drive.setDirection(DcMotorSimple.Direction.REVERSE);
        right_Drive.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    public void start() {

    }


    @Override
    public void loop() {


        left_Drive.setPower(-gamepad1.left_stick_y);
        right_Drive.setPower(-gamepad1.right_stick_y);
        //Tank Drive

        jewel.setPosition(1);
        jewel_push.setPosition(.5);

        if (gamepad2.dpad_down) {
            winch.setPower(-.25);
        } else if (gamepad2.dpad_up) {
            winch.setPower(.25);
        } else {
            winch.setPower(0);
        }
        //hold button a to make winch go up, hold button y to go down.
        // If neither pressed, motor is stopped

        {
            if (gamepad2.right_bumper)


                bravo.setPosition(0);
        }
        {
            if (gamepad2.left_bumper)
                bravo.setPosition(1);
        }

        {
            if (gamepad2.right_bumper)


                charlie.setPosition(1);
        }
        {
            if (gamepad2.left_bumper)
                charlie.setPosition(0);
        }

        {
            if (gamepad2.b)


                charlie.setPosition(.5);
        }
        {
            if (gamepad2.b)
                bravo.setPosition(.5);
        }

    }
    //right bumper sets position to grab, left sets it for short release
    //x sets it for inspection size


    @Override
    public void stop() {
    }
}
