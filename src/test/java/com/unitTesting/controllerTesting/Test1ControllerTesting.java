package com.unitTesting.controllerTesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class Test1ControllerTesting {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSimpleGetRequestTesting() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/simpleGetRequest")
        ).andExpect(MockMvcResultMatchers.status().isOk())
         .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    @Test
    public void testGetRequestWithPathVariable() throws Exception {
        String param="its my path param";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/getRequestWithPathVariable/{message}",param)
               // .param("message",param)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(param));
    }

    @Test
    public void testGetRequestWithRequestParam() throws Exception {
        String requestParam="its my request param";
        mockMvc.perform(
                MockMvcRequestBuilders.get("/getRequestWithRequestParam")
                        .queryParam("message",requestParam)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(requestParam));
    }



}
