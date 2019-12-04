package com.kurly.jehui.validation.member.web;

import com.kurly.util.ResourceMockUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoApi.class)
@RunWith(SpringRunner.class)
public class DemoApiMvcTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void test1() throws Exception {
    // given
    String json = ResourceMockUtil.getString("sample1_1.json");

    // when
    ResultActions resultActions = mockMvc.perform(
        post("/sample1")
        .content(json)
        .contentType(APPLICATION_JSON_UTF8)
    );

    // then
    resultActions
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @Test
  public void test2() throws Exception {
    // given
    String json = ResourceMockUtil.getString("sample1_2.json");

    // when
    ResultActions resultActions = mockMvc.perform(
        post("/sample1")
            .content(json)
            .contentType(APPLICATION_JSON_UTF8)
    );

    // then
    resultActions
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @Test
  public void test3() throws Exception {
    // given
    String json = ResourceMockUtil.getString("sample2.json");

    // when
    ResultActions resultActions = mockMvc.perform(
        put("/sample2")
            .content(json)
            .contentType(APPLICATION_JSON_UTF8)
    );

    // then
    resultActions
        .andDo(print())
        .andExpect(status().isBadRequest());
  }

  @Test
  public void test4() throws Exception {
    // given
    String json = ResourceMockUtil.getString("nested.json");

    // when
    ResultActions resultActions = mockMvc.perform(
        post("/nested")
            .content(json)
            .contentType(APPLICATION_JSON_UTF8)
    );

    // then
    resultActions
        .andDo(print())
        .andExpect(status().isBadRequest());
  }
}