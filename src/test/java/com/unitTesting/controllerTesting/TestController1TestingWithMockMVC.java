package com.unitTesting.controllerTesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitTesting.classes.Info;
import com.unitTesting.classes.SubInfo;
import com.unitTesting.exceptions.RestException;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class TestController1TestingWithMockMVC {

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

    @Test
    public void TestSendRequestBody() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Info info=new Info();
        SubInfo subInfo=new SubInfo();
        subInfo.setCreatorName("Armen Tovmasian");
        subInfo.setInfoText("Info about Armen Tovmasian");
        info.setTitle("requestTitle");
        info.setSubInfo(subInfo);
        mockMvc.perform(
                MockMvcRequestBuilders.put("/sendRequestBody")
                        .content(objectMapper.writeValueAsString(info))
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is("responseTitle")));
    }

    @Test
    public void testException1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/getRequestWithException1")
                        .queryParam("throwException",String.valueOf(Boolean.TRUE))
        ).andExpect(mvcResult -> mvcResult.getResolvedException().equals(RestException.class));
    }


   @Test()
    public void testException2() throws Exception {
            Assertions.assertThatThrownBy(()->mockMvc.perform(
                    MockMvcRequestBuilders.get("/getRequestWithException2")
                            .queryParam("throwException",String.valueOf(Boolean.TRUE))

            )).hasCauseExactlyInstanceOf(RuntimeException.class);
    }




}
