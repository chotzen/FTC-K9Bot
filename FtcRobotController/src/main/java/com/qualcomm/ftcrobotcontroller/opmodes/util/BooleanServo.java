package com.qualcomm.ftcrobotcontroller.opmodes.util;

import com.qualcomm.robotcore.hardware.Servo;

public class BooleanServo {

    float max;
    float min;

    Servo servo;

    // max = true
    // min = false;
    boolean position;

    public BooleanServo(float max, float min, Servo servo) {
        this.servo = servo;
        this.max = max;
        this.min = min;
        servo.setPosition(min);
    }

    public void toggle() {
        if (position) servo.setPosition(min);
        else servo.setPosition(max);
        position = !position;
    }
}
