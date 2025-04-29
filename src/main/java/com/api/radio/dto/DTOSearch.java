package com.api.radio.dto;


public record DTOSearch(String apiVersion, String version, String query, String took, WrapperHits hits) {
}
