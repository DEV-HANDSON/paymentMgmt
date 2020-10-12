package com.atm.demo.controller;

import com.atm.demo.entity.Payment;
import com.atm.demo.paymentmgmt.PaymentManagementDemoApplicationTests;
import com.atm.demo.request.CreatePaymentRequest;
import com.atm.demo.response.PaymentResponse;
import com.atm.demo.services.PaymentService;
import com.atm.demo.services.PaymentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.Assert.assertEquals;



import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentController.class)
@AutoConfigureMockMvc
public class PaymentControllerTest{

    @Autowired
     private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

     @MockBean
     private PaymentServiceImpl paymentService;

    public PaymentControllerTest(){}

    @Before
    public void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void createPaymentTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePaymentRequest payment = new CreatePaymentRequest();
        payment.setId("4849");
        payment.setOrderId((long) 7587875);
        payment.setTransactionId((long) 87585787);
        String jsonRequest = objectMapper.writeValueAsString(payment);

        PaymentResponse paymentResponse = new PaymentResponse();

        paymentResponse.setResponseMessage("Payment Success");
        paymentResponse.setResponseCode("200");
        paymentResponse.setSuccessful(true);


        Mockito.when(paymentService.createpayment(Mockito.any(CreatePaymentRequest.class))).thenReturn(paymentResponse);

        String exampleCourseJson = "{\"id\":\"1111\",\"transactionId\":\"4787484\",\"orderId\":\"475787484\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/payment/create")
                .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
                .contentType(MediaType.APPLICATION_JSON)
                ;

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        System.out.println("String Response ......"+json);

        MockHttpServletResponse response  = mvcResult.getResponse();



    }
}
