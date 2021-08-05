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

    final String URI = "https://dactyl.siskam.link/api/manuform";

    private final ObjectMapper objectMapper;

    private final RestTemplate restTemplate;

    private final OpenscadService openscadService;

    /**
     * @param manuform
     * @param filename filename without extension
     * @param cameras
     */
    @SneakyThrows
    void generate(Manuform manuform, String filename, OpenscadService.Camera... cameras) {

        // create directory
        Optional<File> dir = Optional.ofNullable(Paths.get(filename).getParent()).map(Path::toFile);
        dir.ifPresent(d -> {
            if (d.exists()) d.mkdirs();
        });

        // json
        String json = objectMapper.writeValueAsString(manuform);
        FileCopyUtils.copy(json.getBytes(StandardCharsets.UTF_8), Paths.get(filename + ".json").toFile());
        log.info("Generate manuform with params\n{}\nto {}", json, filename);

        // json -> scad
        RequestEntity<String> request = RequestEntity.post(URI)
                                                     .contentType(MediaType.APPLICATION_JSON)
                                                     .body(json);
        Path scadPath = Paths.get(filename + ".scad");
        String scadContent = restTemplate.postForObject(URI, request, String.class);
        FileCopyUtils.copy(scadContent.getBytes(StandardCharsets.UTF_8), scadPath.toFile());

        // scad -> png
        openscadService.convertScadToPng(scadPath, cameras);
    }
}
