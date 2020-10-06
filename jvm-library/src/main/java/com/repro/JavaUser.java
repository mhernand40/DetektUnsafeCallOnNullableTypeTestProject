package com.repro;

import org.jetbrains.annotations.Nullable;

public class JavaUser {
    @Nullable
    private final String name;

    public JavaUser(@Nullable final String name) {
        this.name = name;
    }

    @Nullable
    public String getName() {
        return name;
    }
}
