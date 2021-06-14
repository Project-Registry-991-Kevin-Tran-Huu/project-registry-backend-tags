package com.revature.registry.controller;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.registry.ProjectRegistryProjectApplication;
import com.revature.registry.model.Tag;
import com.revature.registry.service.TagService;


@SpringBootTest(classes = ProjectRegistryProjectApplication.class)
@ExtendWith(SpringExtension.class)

class TagControllerTest {
  
    private MockMvc mockMvc;
    
    @MockBean
    private TagService tagServ;
    
    @Autowired
    @InjectMocks
    private TagController tagCon;
    
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(tagCon).build();
    }

    @Test
    public void getAllTagsTest() throws Exception{
   
        Tag tag1 = new Tag();
        tag1.setId(50);
        tag1.setName("Tester tag");
        tag1.setDescription("My purpose is to exist");

        Tag tag2 = new Tag();
        tag2.setId(51);
        tag2.setName("Tester tag 2");
        tag2.setDescription("My purpose is to foil the first tag, Muhaha");
        
        List<Tag> tags = new ArrayList<Tag>();
        
        tags.add(tag1);
        tags.add(tag2);
        
        when(tagCon.getAllTags()).thenReturn(new ResponseEntity<List<Tag>>(tags,HttpStatus.OK));
        when(tagServ.getAllTags()).thenReturn(tags);
        
        mockMvc.perform(get("/api/tag")).andExpect(status().isOk())
        
        .andExpect(MockMvcResultMatchers.jsonPath("$.*", isA(List.class)))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Tester tag"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Tester tag 2"))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(50))
        .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(51));
        
    }

}
