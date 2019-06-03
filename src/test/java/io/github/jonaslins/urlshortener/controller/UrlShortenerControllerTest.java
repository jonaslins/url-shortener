package io.github.jonaslins.urlshortener.controller;

import io.github.jonaslins.urlshortener.controller.request.ShortenUrlRequest;
import io.github.jonaslins.urlshortener.model.UrlShorten;
import io.github.jonaslins.urlshortener.service.UrlShortenerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;


@RunWith(SpringRunner.class)
@WebMvcTest(UrlShortenerController.class)
public class UrlShortenerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UrlShortenerService service;

    @Test
    public void shortenUrl() throws Exception {
        String originalUrl = "https://www.linkedin.com/in/jonaslins/";

        UrlShorten urlShorten = new UrlShorten(originalUrl);

        given(service.shortenUrl(originalUrl)).willReturn(urlShorten);

        ShortenUrlRequest shortenUrlRequest = new ShortenUrlRequest(originalUrl);

        mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(shortenUrlRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.code", notNullValue()))
                .andExpect(jsonPath("$.originalUrl", is("https://www.linkedin.com/in/jonaslins/")));
    }

}