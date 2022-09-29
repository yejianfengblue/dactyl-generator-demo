package com.example.dactylgeneratordemo.manuform;

import com.example.dactylgeneratordemo.OpenscadService.Camera;
import com.example.dactylgeneratordemo.SwitchType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
       "manuform.url=http://localhost:3030/api/manuform",
       "manuform.generate-json=true",
       "manuform.generate-stl=true"
})
public class SplitManuformTest {

    final String MANUFORM_BASE_FILENAME = "split/manuform-4x5+3";

    @Autowired
    ManuformService manuformService;

    private Manuform getBaseManuform() {

        Manuform.Keys keys = new Manuform.Keys(5, 4, ThumbCount.THREE_MINI,
                                               LastRow.ZERO, InnerColumn.NORMIE, false,
                                               SwitchType.KAILH);
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
    void colCur8_rowCur69_CenterColMiddleFinger_pinkyYMinus22_Test() {

        Manuform manuform = getBaseManuform();
        manuform.getCurve().setColumnCurvature(8);
        manuform.getCurve().setPinkyColumnCurvature(8);
        manuform.getCurve().setRowCurvature(69);
        manuform.getCurve().setCenterCol(2);
        manuform.getForm().setStaggerPinkyY(-22);

        manuform.getForm().setHotswap(true);

        manuform.getMisc().setRightSide(false);
        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=8)" +
                                 "(row-cur=69)" +
                                 "(center-col=middle)" +
                                 "(pinky-y=-22)" +
                                 "(hotswap)" +
                                 "-left",
                                 Camera.DIAGONAL);
    }

    @Test
    void colCur8_rowCur69_CenterColMiddleFinger_pinkyYMinus22_colExtra0_Test() {

        Manuform manuform = getBaseManuform();

        manuform.getKeys().setSwitchType(SwitchType.KAILH);

        manuform.getCurve().setColumnCurvature(6);
        manuform.getCurve().setPinkyColumnCurvature(6);
        manuform.getCurve().setRowCurvature(69);
        manuform.getCurve().setCenterCol(2);

        // manuform.getForm().setHotswap(true);
        manuform.getForm().setThumbClusterOffsetZ(-10);
        manuform.getForm().setStaggerPinkyY(-22);
        manuform.getForm().setStaggerPinkyZ(4);

        manuform.getMisc().setRightSide(true);

        manuformService.generate(manuform,
                                 MANUFORM_BASE_FILENAME + "-" +
                                 "(col-cur=6)" +
                                 "(row-cur=69)" +
                                 "(center-col=middle)" +
                                 "(thumb-z=-10)" +
                                 "(pinky-y=-22)" +
                                 "(pinky-z=4)" +
                                 "(col-ex-height=-1)" +
                                 // "-hotswap" +
                                 "-right",
                                 Camera.DIAGONAL);
    }
}
