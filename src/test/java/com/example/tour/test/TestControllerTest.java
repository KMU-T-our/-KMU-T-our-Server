package com.example.tour.test;

import com.example.tour.AbstractRestDocsTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TestController.class)
class TestControllerTest extends AbstractRestDocsTests {

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/test")).andExpect(status().isOk());
    }
}