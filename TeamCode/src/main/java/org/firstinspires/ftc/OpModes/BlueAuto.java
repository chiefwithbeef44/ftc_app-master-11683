package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.AutoUtils.Jewel;
<<<<<<< HEAD
import org.firstinspires.ftc.utils.Status;
=======
import org.firstinspires.ftc.AutoUtils.VuforiaUse;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
>>>>>>> master

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="BlueAuto", group="testGroup")
public class BlueAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        RelicRecoveryVuMark vuMark;

        waitForStart();

<<<<<<< HEAD
        while (opModeIsActive())
        {
            telemetry.addData("OpMode Status: ", Status.BEGINNING);
            telemetry.update();
            Jewel jewel = new Jewel(telemetry, hardwareMap);
            telemetry.addData("interpreted color: ", jewel.interpretColor());
            telemetry.addData("OpMode Status: ", Status.WORKING);
=======
//        VuforiaUse vuf = new VuforiaUse(telemetry);
        Jewel jewel = new Jewel(telemetry, hardwareMap);

//        vuf.scanner.initialize();

        while (opModeIsActive())
        {
//            vuMark = vuf.fullRun();
            telemetry.addData("interpreted color: ", jewel.interpretColor());
//            telemetry.addData("VuMark: ", vuMark);
>>>>>>> master
            telemetry.update();
            jewel.altknock("blue");
            telemetry.addData("OpMode Status: ", Status.FINISHED);
            telemetry.update();
        }
    }
}