package com.qualcomm.ftcrobotcontroller.opmodes.util;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robocol.Telemetry;

/**
 * Created by dchotzen-hartzell19 on 3/28/16.
 */
public class ArmController {

    private Telemetry telemetry;
    private BooleanServo base, claw;
    private Gamepad gamepad;

    private boolean a_pressed, b_pressed;

    public ArmController(Telemetry telemetry, Servo base, Servo claw, Gamepad gamepad) {
        this.telemetry = telemetry;
        this.base = new BooleanServo(0.0F, 0.5F, base);
        this.claw = new BooleanServo(0.0F, 0.9F, claw);
        this.gamepad = gamepad;
    }

    public void update() {
        if (gamepad.a) {
            if (!a_pressed) {
                base.toggle();
                a_pressed = true;
            }
        } else {
            a_pressed = false;
        }

        if (gamepad.b) {
            if (!b_pressed) {
                claw.toggle();
                b_pressed = true;
            }
        } else {
            b_pressed = false;
        }

    }

}
