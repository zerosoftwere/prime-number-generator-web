package me.xerosoft.controllers;

import me.xerosoft.services.PrimeGeneratorService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(PrimeGeneratorController.class)
public class PrimeGeneratorControllerTest {

    @MockBean
    private PrimeGeneratorService generatorService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldListPrimes() throws Exception {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7);
        Mockito.when(generatorService.generate("cd", 1, 10)).thenReturn(primes);

        mvc.perform(MockMvcRequestBuilders
                .get("/primes?start=1&end=10")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(4)));

    }
}
