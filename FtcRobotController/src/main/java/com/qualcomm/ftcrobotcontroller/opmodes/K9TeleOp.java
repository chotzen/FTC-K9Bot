package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.opmodes.util.ArmController;
import com.qualcomm.ftcrobotcontroller.opmodes.util.DriveMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class K9TeleOp extends OpMode {

    public DriveMotorController dmc;

    public ArmController amc;

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

        dmc = new DriveMotorController(telemetry, hardwareMap.dcMotor.get("left_motor"),
                hardwareMap.dcMotor.get("right_motor"), gamepad1);

        amc = new ArmController(telemetry, hardwareMap.servo.get("base_servo"), hardwareMap.servo.get("grip_servo"), gamepad1);


    }
}
