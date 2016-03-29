package com.qualcomm.ftcrobotcontroller.opmodes.util;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.robocol.Telemetry;
import com.qualcomm.robotcore.util.Range;

public class DriveMotorController {

    public DcMotor lmotor, rmotor;
    public Telemetry telemetry;
    public Gamepad gamepad;

    public boolean xpressed = false;

    /*
    true = tank
    false = arcade
    Tank is default
     */
    public boolean driveMode = true;

    public DriveMotorController(Telemetry telemetry, DcMotor left, DcMotor right, Gamepad gamepad) {
        this.telemetry = telemetry;
        lmotor = left;
        lmotor.setDirection(DcMotor.Direction.REVERSE);
        rmotor = right;
        this.gamepad = gamepad;
    }

    public void update() {
        // Get the current drive mode
        if (gamepad.x) {
            if (!xpressed) {
                xpressed = true;
                driveMode = !driveMode;
            }
        } else {
            xpressed = false;
        }

        try {
        // Tank Drive
        if (driveMode) {
            lmotor.setPower(-gamepad.left_stick_y);
            rmotor.setPower(-gamepad.right_stick_y);
        }

        // Arcade Drive
        else {
            float mod = 0.7F * -gamepad.left_stick_x;
            float base = 0.5F * gamepad.left_stick_y;

            float left = Range.clip(base + mod, -1, 1);
            float right = Range.clip(base - mod, -1, 1);

            lmotor.setPower(-left);
            rmotor.setPower(-right);
        }

        } catch (Exception e) {

        }
    }

}
