package org.firstinspires.ftc.team11683.AutoUtils;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team11683.bot.AutoBot;
import org.firstinspires.ftc.team11683.enums.Color;
import org.firstinspires.ftc.team11683.enums.NewDirection;
import org.firstinspires.ftc.team11683.enums.Status;
import org.firstinspires.ftc.team11683.utils.Utilities;
import org.firstinspires.ftc.team11683.utils.CustomAutonomous;

/**
 * Created by sambl on 12/13/2017
 */

public class Jewel
{
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    public Color AccColor;
    private  AutoBot bot = new AutoBot();
    public Status status;

    public Jewel(HardwareMap hMap, Telemetry telem)
    {
        this.hardwareMap = hMap;
        this.telemetry = telem;
        bot.init(hMap);
        
    }
    private  int getBlue(){return bot.colorSensor.blue();}
    private  int getRed(){return bot.colorSensor.red();}

    public Color interpretColor()
    {
        bot.cServo.setPosition(0.9);
            if(getBlue() > CustomAutonomous.COLOR_THRESHOLD && getRed()<CustomAutonomous.COLOR_THRESHOLD)
            {
                AccColor = Color.BLUE;
            }else if(getRed() > CustomAutonomous.COLOR_THRESHOLD && getBlue()<CustomAutonomous.COLOR_THRESHOLD)
            {
                AccColor = Color.RED;
            }else
            {
                AccColor = Color.UNKNOWN;
            }
            return AccColor;
        }

    public void redrun(){

        AccColor = interpretColor();

        if(AccColor.equals(Color.BLUE)){
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.BACKWARD.v*0.75);
            bot.rightMotor.setPower(NewDirection.BACKWARD.v*0.75);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }else{
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.FORWARD.v*0.75);
            bot.rightMotor.setPower(NewDirection.FORWARD.v*0.75);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }
    }
    public void bluerun()
    {
        AccColor = interpretColor();
        if (AccColor.equals(Color.BLUE)) {
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.FORWARD.v*0.75);
            bot.rightMotor.setPower(NewDirection.FORWARD.v*0.75);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }else{
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.BACKWARD.v*0.75);
            bot.rightMotor.setPower(NewDirection.BACKWARD.v*0.75);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            bot.leftMotor.setPower(0);
            bot.rightMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }
    }


}