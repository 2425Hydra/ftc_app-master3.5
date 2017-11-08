package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;





@TeleOp(name = "Bravo")

//Created by HYDRA ROBOTICS 10/24/17

public class Team3073Op extends OpMode {

    private DcMotor left_Drive;
    private DcMotor right_Drive;


    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        left_Drive = hardwareMap.dcMotor.get("left_Drive");
        right_Drive = hardwareMap.dcMotor.get("right_Drive");


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
    }



    //right bumper sets position to grab, left sets it for short release
    //x sets it for inspection size


    @Override
    public void stop() {
    }
}
