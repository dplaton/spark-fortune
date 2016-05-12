package dplaton.projects.sparkfortune.service.impl;

import dplaton.projects.sparkfortune.service.FortuneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by platon on 12.05.2016.
 */
@Service
public class FortuneServiceImpl implements FortuneService {

    private static final Logger LOG = LoggerFactory.getLogger(FortuneService.class);

    @Override
    public String getFortune(boolean offensive) {
        Runtime runtime = Runtime.getRuntime();
        Process p = null;
        String response = "";

        String command = "fortune".concat( offensive ? " -o": "");

        try {
            p = runtime.exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response += line + "\n";
            }
            return response;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
}
