package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.util.ArmController;
import com.qualcomm.ftcrobotcontroller.opmodes.util.DriveMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;


public class K9TeleOp extends OpMode {

    public DriveMotorController dmc;

    public ArmController amc;

    public Gamepad gamepad;


    public Servo base_servo,
                 grip_servo;

    public double base_min = 0.0;
    public double base_max = 0.5;
    public double grip_min = 0.0;
    public double grip_max = 0.9;

    public boolean apressed = false;
    public boolean bpressed = false;


    /*
        false = back
        true = forward
     */
    public boolean apos = false;
    public boolean bpos = false;

    @Override
    public void loop() {

        try {
            dmc.update();
            amc.update();
        } catch (Exception e) {
            telemetry.addData("Error", e.getMessage());
        }

    }

    @Override
    public void init() {

        //this.gamepad = gamepad1;

        dmc = new DriveMotorController(telemetry, hardwareMap.dcMotor.get("left_motor"),
                hardwareMap.dcMotor.get("right_motor"), gamepad1);

        amc = new ArmController(telemetry, hardwareMap.servo.get("base_servo"), hardwareMap.servo.get("grip_servo"), gamepad1);


    }

    public void start() {
        /*base_servo.setPosition(base_min);
        grip_servo.setPosition(grip_min);*/
    }

}
