package pl.b2bnetwork.domain;

import lombok.Getter;

@Getter
public enum EngineCat {

    R3("r3"),
    R4("r4"),
    R5("r5"),
    R6("r6"),
    V6("v6"),
    V8("v8");

    private String name;

    private EngineCat(String name) {
        this.name = name;
    }
}
