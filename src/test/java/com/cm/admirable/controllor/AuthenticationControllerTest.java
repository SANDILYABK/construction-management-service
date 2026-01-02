package com.cm.admirable.controllor;

import com.cm.admirable.controller.AuthenticationController;
import com.cm.admirable.dto.LoginRequest;
import com.cm.admirable.dto.LoginResponse;
import com.cm.admirable.service.AuthenticationService;
import com.cm.admirable.service.EmployeeService;
import com.cm.admirable.service.RegistractionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticationController.class)
@AutoConfigureMockMvc
public class AuthenticationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private RegistractionService registractionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthenticationController authenticationController;

    @BeforeEach
    void setup(){
        authenticationService = Mockito.mock(AuthenticationService.class);
         registractionService= Mockito.mock(RegistractionService.class);
        authenticationController= new AuthenticationController(authenticationService,registractionService);
    }

    @Test
    void testAuthenticationUser(){
        LoginRequest request = new LoginRequest("test@gmail.com","password123");
        LoginResponse expectedResponse= new LoginResponse("Success","Login Successful");
        when(authenticationService.authenticateUser(any(LoginRequest.class))).thenReturn(expectedResponse);
        ResponseEntity<LoginResponse> actualResponce = authenticationController.authenticateUser(request);
        assertEquals(expectedResponse.success(),actualResponce.getBody().success());
        assertEquals(expectedResponse.message(),actualResponce.getBody().message());
        verify(authenticationService,times(1)).authenticateUser(any(LoginRequest.class));
    }
    /*@Test
    void authenticateUser_userNotFound() throws Exception{
        LoginResponse request = new LoginResponse("testfail@gamil.com","password666");
        LoginRequest loginRequest = new LoginRequest("testfail@gamil.com","password666");

        Mockito.when(authenticationService.authenticateUser(loginRequest))
                            .thenThrow(HttpClientErrorException.Unauthorized.class);
        mockMvc.perform(post("/api/login")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value("FAILED"))
                .andExpect(jsonPath("$.message").value("Request User Not found."));
    }*/

}
