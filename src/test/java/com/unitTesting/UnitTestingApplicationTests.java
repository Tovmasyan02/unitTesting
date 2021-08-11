package com.unitTesting;


import com.unitTesting.beans.Bean1;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest
class UnitTestingApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Bean1 bean1;

	@Test
	public void test1() throws Exception {
		Mockito.when(bean1.printHello()).thenReturn("Mochito!");
		mockMvc.perform(
				MockMvcRequestBuilders.get("/getHello")
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(mvcResult1 -> mvcResult1.getResolvedException().getClass().equals(Exception.class));
	//	.andExpect(MockMvcResultMatchers.content().string("Магия от Михито"))


		//System.out.println("TEST RESULT");
		//System.out.println(mvcResult.getResponse().getContentAsString());
	}

}
