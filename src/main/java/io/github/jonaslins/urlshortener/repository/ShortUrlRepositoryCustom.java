package io.github.jonaslins.urlshortener.repository;

import io.github.jonaslins.urlshortener.model.ShortUrl;
import io.github.jonaslins.urlshortener.model.ShortUrlStatistics;

import java.util.Optional;

public interface ShortUrlRepositoryCustom {

    Optional<ShortUrl> findAndIncrementHitCount(String code);

    Optional<ShortUrlStatistics> getStatisticsByCode(String code);
}
