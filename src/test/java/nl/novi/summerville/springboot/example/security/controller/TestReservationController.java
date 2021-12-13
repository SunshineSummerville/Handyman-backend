package nl.novi.summerville.springboot.example.security.controller;

import nl.novi.summerville.springboot.example.security.NoviExamplesApplication;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = NoviExamplesApplication.class )
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")

public class TestReservationController {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ReservationRepository repository;


    @Test
    public void getCategories() throws Exception {
        // arrange
        String endpoint = "/api/categories";
        // act
        mvc.perform(get(endpoint)
                .contentType(MediaType.APPLICATION_JSON))
                // assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(20)));


    }

    @Test
    public void postSignup() throws Exception {
        // arrange
        String endpoint = "/api/auth/signup";
        String body = "{\n" +
                "    \"username\": \"handyman\",\n" +
                "    \"password\" : \"123456\",\n" +
                "    \"firstname\": \"handyman\",\n" +
                "    \"lastname\": \"handyman\",\n" +
                "    \"email\" : \"handyman@handyman.com\",\n" +
                "    \"phonenumber\": \"0612345678\",\n" +
                "    \"street\": \"handymanstreet\",\n" +
                "    \"housenumber\": \"1\",\n" +
                "    \"postalcode\": \"1111HM\",\n" +
                "    \"provincie\": \"Zuid-Holland\",\n" +
                "    \"role\": [\"handyman\", \"user\"]\n" +
                "}";
        // act
        mvc.perform(post(endpoint)
                .contentType(MediaType.APPLICATION_JSON).content(body))
                // assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", equalTo ("User registered successfully!")));


    }
}
