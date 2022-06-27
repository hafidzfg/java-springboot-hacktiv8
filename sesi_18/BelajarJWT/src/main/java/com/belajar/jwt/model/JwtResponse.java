package com.belajar.jwt.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID = -5126236264373L;

    private final String jwtToken;

    public JwtResponse(String jwtToken) {

        this.jwtToken = jwtToken;

    }

    public String getToken() {

        return this.jwtToken;

    }

}
