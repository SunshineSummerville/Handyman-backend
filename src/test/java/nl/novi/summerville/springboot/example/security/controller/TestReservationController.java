package nl.novi.summerville.springboot.example.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import nl.novi.summerville.springboot.example.security.NoviExamplesApplication;
import nl.novi.summerville.springboot.example.security.repository.ReservationRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = NoviExamplesApplication.class )
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestReservationController {
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ReservationRepository repository;


    @Test
    @Order(4)
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
    @Order(1)
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


    @Test
    @Order(2)
    public void postLoginAndPostReservation() throws Exception {
        // arrange
        String endpoint = "/api/auth/signin";
        String body = "{\n" +
                "    \"username\": \"handyman\",\n" +
                "    \"password\" : \"123456\"\n" +
                "}";
        // act
        ResultActions response = mvc.perform(post(endpoint)
                .contentType(MediaType.APPLICATION_JSON).content(body))
                // assert
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.accessToken", not(isEmptyOrNullString())));

        MvcResult result = response.andReturn();
        String jsonString = result.getResponse().getContentAsString();
        System.out.println(jsonString);
        ObjectNode node = new ObjectMapper().readValue(jsonString,ObjectNode.class);

        if (node.has("accessToken")) {
            setToken(node.get("accessToken").toString());
            String endpoint2 = "/api/reservation";
            String body2 = "{\n" +
                    "    \"categoryId\": 8,\n" +
                    "    \"handymanId\": 6,\n" +
                    "    \"customerId\": 21,\n" +
                    "    \"reservationDate\": \"25-12-2022\",\n" +
                    "    \"image\":\"\"\n"+
                    "}";
            // act
            mvc.perform(post(endpoint2)
                    .contentType(MediaType.APPLICATION_JSON).content(body2).header("authorization", "Bearer " + getToken().replaceAll("^\"|\"$", "")))

                    // assert
                    .andExpect(status().isCreated())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.reservationDate", equalTo ("25-12-2022")));

        }

    }




}
