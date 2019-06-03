package io.github.jonaslins.urlshortener.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomShortCodeGeneratorTest {

    @Test
    public void shouldGenerateCode() {
        String generatedCode = RandomShortCodeGenerator.generateCode();

        assertThat(generatedCode).isNotNull();
        assertThat(generatedCode).hasSize(7);
        assertThat(generatedCode).matches("^[A-Za-z0-9]{7}$");
    }
}