package com.example.demo.unit.controller;

import com.example.demo.controller.HomeController;
import com.example.demo.controller.JoinForm;
import com.example.demo.controller.JoinResponse;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;
    @Mock
    private MemberService memberService;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        objectMapper = new ObjectMapper();
    }

    @DisplayName("회원가입 성공")
    @Test
    void join() throws Exception {
        JoinForm joinForm = JoinForm.builder()
                        .name("name")
                        .age(24)
                        .build();

        // given
        doReturn(new Member("name", 24)).when(memberService)
                .join(any(JoinForm.class));

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(joinForm))
        );

        // then
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("name", joinForm.getName()).exists())
                .andExpect(jsonPath("age", joinForm.getAge()).exists())
                .andReturn();
    }
}