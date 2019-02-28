package com.udesc.ceavi.deso.empds.backend.security;

public class SecurityConstants {
    static final String SECRET = "ceavi";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/users/sign-up";
    static final long EXPIRATION_TIME = 86400000L;

}