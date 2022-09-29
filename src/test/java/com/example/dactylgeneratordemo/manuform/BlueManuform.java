package com.example.dactylgeneratordemo.manuform;

import com.example.dactylgeneratordemo.OpenscadService.Camera;
import com.example.dactylgeneratordemo.SwitchType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
//        "manuform.url=http://localhost:23000/api/manuform",
        "manuform.generate-stl=false"
})
public class BlueManuform {

    final String MANUFORM_BASE_FILENAME = "blue/local/manuform-4x6+3";

    @Autowired
    ManuformService manuformService;

    private Manuform getBaseManuform() {

        Manuform.Keys keys = new Manuform.Keys(6, 4, ThumbCount.THREE,
                                               LastRow.TWO, InnerColumn.NORMIE, false,
                                               SwitchType.MX_SNAP_IN);
        Manuform.Curve curve = new Manuform.Curve(12, 12, 36, 4, 15, 180);
        Manuform.Connector connector = new Manuform.Connector(false, ConnectorType.TRRS, true);
        Manuform.Form form = new Manuform.Form(false,
                                               6, -3, 7,
                                               true,
                                               0, 0,
                                               2.8, -6.5,
                                               0, 0,
                                               -13, 6,
                                               false,
                                               20,
                                               7, 3,
                                               false,
                                               false);
        Manuform.Misc misc = new Manuform.Misc(false, true);

        return new Manuform(keys, curve, connector, form, misc);
    }

    @Test
    void colCur8_tent10_thumbY0_pinkyYMinus20_height6() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setTenting(10);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(6);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=10)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=6)" +
                                 "-right",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_tent4_thumbY0_pinkyYMinus20_height20() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
//        manuform.getCurve().setCenterCol(2);
        manuform.getCurve().setRowCurvature(69);
        manuform.getCurve().setTenting(3);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(20);
//        manuformService.generate(manuform,
//                                 MANUFORM_BASE_FILENAME + "-" +
//                                 "(col-cur=8)" +
//                                 "(tent=4)" +
//                                 "(thumb-y=0)" +
//                                 "(pinky-y=-20)" +
//                                 "(height=20)" +
//                                 "(internal-holder-trrs)" +
//                                 "-right",
//                                 Camera.DIAGONAL);

        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=4)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=20)" +
                                 "(internal-holder-trrs)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_tent4_thumbY0_pinkyYMinus20_height20_wall2() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setTenting(4);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(20);
        manuform.getForm().setWallThickness(2);

        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=4)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=20)" +
                                 "(wall=2)" +
                                 "(internal-holder-trrs)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_tent5_thumbY0_pinkyYMinus20_height15_wall2() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setTenting(5);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(15);
        manuform.getForm().setWallThickness(2);

        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=5)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=15)" +
                                 "(wall=2)" +
                                 "(internal-holder-trrs)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_tent6_thumbY0_pinkyYMinus20_height11_wall12() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setTenting(6);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(11);
        manuform.getForm().setWallThickness(1.2);

        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=6)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=11)" +
                                 "(wall=1.2)" +
                                 "(internal-holder-trrs)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_tent6_thumbY0_pinkyYMinus20_height10_wall2_external() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setTenting(6);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(10);
        manuform.getForm().setWallThickness(2);

        manuform.getConnector().setExternal(true);
        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=6)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=10)" +
                                 "(wall=2)" +
                                 "(external)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_tent7_thumbY0_pinkyYMinus20_height10_wall2() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setTenting(7);
        manuform.getForm().setThumbClusterOffsetY(0);
        manuform.getForm().setStaggerPinkyY(-20);
        manuform.getForm().setHeightOffset(10);
        manuform.getForm().setWallThickness(2);

        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(tent=7)" +
                                 "(thumb-y=0)" +
                                 "(pinky-y=-20)" +
                                 "(height=10)" +
                                 "(wall=2)" +
                                 "(internal-holder-trrs)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

}
