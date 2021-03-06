package org.firstinspires.ftc.team11683.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.team11683.bot.WorkingBot;

/**
 * Created by sambl on 9/25/2017
 */
@TeleOp(name = "TELE", group = "teleOp")
public class teleOp extends CustomTeleOp
{
    public WorkingBot bot = new WorkingBot();

    //vars
    private long prevTime = 0;
    private int lPrevPos = 0;
    private int rPrevPos = 0;
    private int fPrevPos = 0;
    private double rightPower = 0;
    private double leftPower = 0;

    //init
    public void init()
    {
        bot.init(hardwareMap);
        //initialization
        bot.leftClamp.setPosition(1);
        bot.rightClamp.setPosition(0);
        bot.cServo.setPosition(0.2);

    }

    //loop
    public void loop()
    {
        long currTime = System.nanoTime();
        int lPos = bot.leftMotor.getCurrentPosition();
        int rPos = bot.rightMotor.getCurrentPosition();
        int fPos = bot.forkUp.getCurrentPosition();

        double dTime = (currTime - prevTime) * 10E-9;
        double dLPos = lPos - lPrevPos;
        double dRPos = rPos - rPrevPos;
        double dFpos = fPos - fPrevPos;

        double lSpeed = Math.abs(dLPos/dTime);
        double rSpeed = Math.abs(dRPos/dTime);
        double fSpeed = Math.abs(dFpos/dTime);
        //joysticks

        //left
        if(Math.abs(gamepad1.left_stick_y) > JOYSTICK_THRESHOLD) {
            leftPower = scaleInput(gamepad1.left_stick_y);
            bot.leftMotor.setPower(0.75*leftPower);
        } else
            {
            bot.leftMotor.setPower(0);
        }

        //right
        if(Math.abs(gamepad1.right_stick_y) > JOYSTICK_THRESHOLD) {
            rightPower = scaleInput(gamepad1.right_stick_y);
            bot.rightMotor.setPower(0.75*rightPower);
        } else
            {
            bot.rightMotor.setPower(0);
        }

        //claw
        if (gamepad1.x)
        {
            bot.leftClamp.setPosition(0.4);
            bot.rightClamp.setPosition(0.4);
        }
        if (gamepad1.b)
        {
            bot.leftClamp.setPosition(1);
            bot.rightClamp.setPosition(0);
        }

        //forkUP
        if (gamepad1.dpad_up)
        {
            bot.forkUp.setPower((double) 0.75*gamepad1.left_trigger);
        }
        if (gamepad1.dpad_down)
        {
            bot.forkUp.setPower((double) -0.75*gamepad1.left_trigger);
        }

        //telemetry
        telemetry.addData("L Position: ", lPos);
        telemetry.addData("R Position: ", rPos);
        telemetry.addData("Fork Pos: ", fPos);
        telemetry.addData("L Speed: ", lSpeed);
        telemetry.addData("R Speed: ", rSpeed);
        telemetry.addData("Fork Speed: ", fSpeed);
        telemetry.addData("LeftStickY: ", gamepad1.left_stick_y);
        telemetry.addData("RightStickY: ", gamepad1.right_stick_y);
        telemetry.addData("L Pow: ", bot.leftMotor.getPower());
        telemetry.addData("R Pow: ", bot.rightMotor.getPower());
        telemetry.addData("Fork Pow: ", bot.forkUp.getPower());
        telemetry.addData("RightClampPos: ", bot.rightClamp.getPosition());
        telemetry.addData("LeftClampPos: ", bot.leftClamp.getPosition());
        telemetry.update();

        //reset prev
        prevTime = currTime;
        lPrevPos = lPos;
        rPrevPos = rPos;
        fPrevPos = fPos;
    }
}