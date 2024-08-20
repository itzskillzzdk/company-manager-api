package com.enzoo.company_manager;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.enzoo.company_manager.model.Position;
import com.enzoo.company_manager.repository.PositionRepository;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = { "classpath:application-test.properties" })
public class PositionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PositionRepository positionRepository;

    @BeforeEach
    public void setUp() {
        // Clean existing data
        positionRepository.deleteAll();

        // Insert test data
        positionRepository.save(new Position("CEO", "CEO Notes"));
        positionRepository.save(new Position("CTO", "CTO Notes"));
        positionRepository.save(new Position("HR Manager", "HR Manager Notes"));
    }

    @Test
    public void testGetAllPosition() throws Exception {
        mockMvc.perform(get("/positions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("CEO")))
                .andExpect(jsonPath("$[0].notes", is("CEO Notes")));
    }
}
