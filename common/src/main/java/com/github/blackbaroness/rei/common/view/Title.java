package com.github.blackbaroness.rei.common.view;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;

@Getter
@Builder
public class Title {

    private final String title;
    private final String subtitle;

    @Builder.Default
    private final Duration fadeInDuration = Duration.ofSeconds(1);

    @Builder.Default
    private final Duration stayDuration = Duration.ofSeconds(10);

    @Builder.Default
    private final Duration fadeOutDuration = Duration.ofSeconds(1);
}
