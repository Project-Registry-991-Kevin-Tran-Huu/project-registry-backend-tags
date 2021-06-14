package com.revature.registry.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.revature.registry.ProjectRegistryProjectApplication;
import com.revature.registry.service.TagService;


@SpringBootTest(classes = ProjectRegistryProjectApplication.class)
@ExtendWith(SpringExtension.class)
class TagControllerTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    @InjectMocks
    private TagController tagControl;
    
    
    private TagService tagServ;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void test() {
        fail("Not yet implemented");
    }

}
