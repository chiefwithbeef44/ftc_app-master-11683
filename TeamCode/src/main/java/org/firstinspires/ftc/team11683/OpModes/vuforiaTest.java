package org.firstinspires.ftc.team11683.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.team11683.AutoUtils.VuforiaScanner;

/**
 * Created by sambl on 12/15/2017.
 */
//@TeleOp(name = "vuforiaTest", group = "Test")
public class vuforiaTest extends OpMode
{
    VuforiaScanner scanner = new VuforiaScanner();
    public void init()
    {
        telemetry.addLine("starting init");
        telemetry.update();
        scanner.initialize();
        telemetry.addLine("initialized");
        telemetry.update();
    }

    public void loop(){
        scanner.getVuMark();
        telemetry.addData("vuMark: ", scanner.getVuMark());
        telemetry.update();
    }
}
