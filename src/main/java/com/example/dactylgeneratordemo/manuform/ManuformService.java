package com.example.dactylgeneratordemo.manuform;

import com.example.dactylgeneratordemo.OpenscadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
class ManuformService {

    private final ManuformProperties manuformProperties;

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    private final OpenscadService openscadService;

    /**
     * @param manuform
     * @param filename filename without extension
     * @param cameras one or more {@link OpenscadService.Camera}
     */
    @SneakyThrows
    void generate(Manuform manuform, String filename, OpenscadService.Camera... cameras) {

        // create directory
        Optional<File> dir = Optional.ofNullable(Paths.get(filename).getParent()).map(Path::toFile);
        dir.ifPresent(d -> {
            if (!d.exists()) d.mkdirs();
        });

        // json
        String json = objectMapper.writeValueAsString(manuform);
        log.info("Generate manuform with params\n{}\nto {}", json, filename);
        if (manuformProperties.isGenerateJson()) {
            FileCopyUtils.copy(json.getBytes(StandardCharsets.UTF_8), Paths.get(filename + ".json").toFile());
        }

        // json -> scad
        Path scadPath = Paths.get(filename + ".scad");
        if (manuformProperties.isGenerateScad()) {
            RequestEntity<String> request = RequestEntity.post(manuformProperties.getUrl())
                                                         .contentType(MediaType.APPLICATION_JSON)
                                                         .body(json);
            String scadContent = restTemplate.postForObject(manuformProperties.getUrl(), request, String.class);
            FileCopyUtils.copy(scadContent.getBytes(StandardCharsets.UTF_8), scadPath.toFile());
        }

        // scad -> png
        if (manuformProperties.isGeneratePng()) {
            openscadService.convertScadToPng(scadPath, cameras);
        }

        // scad -> stl
        if (manuformProperties.isGenerateStl()) {
            openscadService.convertScadToStl(scadPath.toString());
        }
    }
}
