package com.example.integracion.Dtos;

import lombok.Data;

@Data
public class DtoAuthRespuesta {

	private String accessToken;
    private String tokenType = "Bearer ";

    public DtoAuthRespuesta(String accessToken) {
        this.accessToken = accessToken;
    }
    
}
