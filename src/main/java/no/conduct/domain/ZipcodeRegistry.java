package no.conduct.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class ZipcodeRegistry {

    @Value("${zipcode.filename}")
    private String filename;

    private final Map<String, String> zipcodes = new HashMap<>();

    private void loadFromFile()
            throws IOException {

        final ClassPathResource r = new ClassPathResource(filename);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(r.getInputStream(), "UTF-8"))) {
            in.lines().forEach(line -> {
                final String parts[] = line.split("\t");
                zipcodes.put(parts[0], parts[1]);
            });
        }

    }

    public synchronized String getPlace(final String zipcode)
            throws IOException {

        if (zipcodes.isEmpty()) {
            loadFromFile();
        }
        return zipcodes.get(zipcode);

    }

}
