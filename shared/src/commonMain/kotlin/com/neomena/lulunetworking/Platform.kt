package com.neomena.lulunetworking

public interface Platform {
    public val name: String
}

public expect fun getPlatform(): Platform