package com.SIGER.SIGER.security.enums;

public enum RolNombre {

    USER("USER"),
    ADMIN("ADMIN");

    private static final String ROLE_PREFIX = "ROLE_";
    private final String name;

    RolNombre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFullRoleName() {
        return ROLE_PREFIX + name;
    }
}