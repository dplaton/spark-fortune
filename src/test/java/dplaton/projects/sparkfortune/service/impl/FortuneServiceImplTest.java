package dplaton.projects.sparkfortune.service.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by platon on 12.05.2016.
 */
public class FortuneServiceImplTest {

    @Test
    public void testGetFortuneNonOffensive() {
        FortuneServiceImpl fortuneService = new FortuneServiceImpl();

        String message = fortuneService.getFortune(false);
        Assert.assertNotNull(message);

    }

    @Test
    public void testGetFortuneOffensive() {
        FortuneServiceImpl fortuneService = new FortuneServiceImpl();

        String message = fortuneService.getFortune(true);
        Assert.assertNotNull(message);
    }

}
