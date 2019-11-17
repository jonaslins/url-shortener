package io.github.jonaslins.urlshortener.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.jonaslins.urlshortener.controller.request.ShortenUrlRequest;
import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.model.ShortUrlStatistics;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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

        ShortUrl shortUrl = new ShortUrl(originalUrl);

        given(service.shortenUrl(originalUrl)).willReturn(shortUrl);

        ShortenUrlRequest shortenUrlRequest = new ShortenUrlRequest(originalUrl);


        mvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(shortenUrlRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.code", notNullValue()))
                .andExpect(jsonPath("$.originalUrl", is("https://www.linkedin.com/in/jonaslins/")));
    }

    private String toJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }


    @Test
    public void redirectToOriginalUrl() throws Exception {
        String code = "kLPc8a";
        String originalUrl = "https://www.linkedin.com/in/jonaslins/";

        given(service.getOriginalUrlByCode(eq(code), any(), any(), any())).willReturn(originalUrl);

        mvc.perform(get("/" + code)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("https://www.linkedin.com/in/jonaslins/"))
                .andExpect(status().isFound());
    }

    @Test
    public void getStatistics() throws Exception {
        String code = "kLPc8a";
        String originalUrl = "https://www.linkedin.com/in/jonaslins/";

        ShortUrlStatistics shortUrlStatistics = new ShortUrlStatistics();
        shortUrlStatistics.setHitCount(5l);
        shortUrlStatistics.setOriginalUrl(originalUrl);

        given(service.getStatisticsByCode(code)).willReturn(shortUrlStatistics);

        mvc.perform(get("/" + code + "/statistics")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.hitCount", is(5)))
                .andExpect(jsonPath("$.originalUrl", is("https://www.linkedin.com/in/jonaslins/")));
    }

}