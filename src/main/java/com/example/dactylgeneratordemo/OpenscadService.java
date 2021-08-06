package com.example.dactylgeneratordemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zeroturnaround.exec.ProcessExecutor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
public class OpenscadService {

    public void convertScadToPng(Path scadPath, Camera... cameras)
            throws IOException, InterruptedException, TimeoutException {

        for (Camera camera : cameras) {

            String pngPath = scadPath.toString().replace(".scad", "-" + camera + ".png");
            log.info("{} -> {}", scadPath, pngPath);
            List<String> commands = new ArrayList<>();
            commands.add("openscad");
            commands.add(scadPath.toString());
            commands.add("-o");
            commands.add(pngPath);
            commands.add("--imgsize");
            commands.add("1000,1000");
            // adjust camera to look at object's center
            commands.add("--autocenter");
            if (Camera.BOTTOM_DIST_200 != camera) {
                // adjust camera to fit object, so the result image contains the whole object
                commands.add("--viewall");
            }
            commands.add("--camera");
            commands.add(camera.getArg());
            if (Camera.DIAGONAL == camera || Camera.TOP == camera) {
                commands.add("--view");
                commands.add("axes");
            }
            if (Camera.BACK_TOP == camera || Camera.BOTTOM == camera) {
                commands.add("--render");
            }

            new ProcessExecutor().command(commands).execute();
        }
    }

    public void convertScadToStl(String scad) throws IOException, InterruptedException, TimeoutException {

        String stl = scad.replace(".scad", ".stl");
        log.info("{} -> {}", scad, stl);

        new ProcessExecutor().command(List.of("openscad", scad, "-o", stl)).execute();
    }

    public enum Camera {

        DIAGONAL("0,0,0,55,0,25,500"),

        TOP("0,0,0,0,0,0,500"),
        BOTTOM("0,0,0,180,0,180,500"),
        BOTTOM_DIST_200("0,0,0,180,0,180,200"),
        LEFT("0,0,0,90,0,270,500"),
        RIGHT("0,0,0,90,0,90,500"),
        FRONT("0,0,0,90,0,0,500"),
        BACK("0,0,0,90,0,180,500"),
        BACK_TOP("0,0,0,60,0,180,500"),

        ;

        private String arg;

        Camera(String arg) {
            this.arg = arg;
        }

        public String getArg() {
            return arg;
        }
    }
}
