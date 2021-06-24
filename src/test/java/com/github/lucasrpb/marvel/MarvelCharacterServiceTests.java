package com.github.lucasrpb.marvel;

import com.github.lucasrpb.marvel.services.CharacterService;
import com.github.lucasrpb.marvel.services.ComicService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, args = {"true"})
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MarvelCharacterServiceTests {

    @Autowired
    CharacterService characterService;

    @Autowired
    ComicService comicService;

    @Autowired
    private MockMvc mockMvc;

    ThreadLocalRandom rand = ThreadLocalRandom.current();

    @Test
    void notNull() {
       assertThat(characterService).isNotNull();
       assertThat(mockMvc).isNotNull();
    }

    /*@Test
    @Before
    void populate(){
        Helper.populate(characterService);
    }*/

    @Test
    public void findAllCharacters() throws Exception {
        mockMvc.perform(
                get("/v1/public/characters")
        ).andDo(print()).andExpect(status().is(200));
    }

    @Test
    public void findCharacterById() throws Exception {
        mockMvc.perform(get("/v1/public/characters/1"))
        .andDo(print())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }
}