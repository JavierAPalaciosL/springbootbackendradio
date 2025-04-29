package com.api.radio.dto;

import java.util.List;

public record DTOListPlaces(String id, List<String> geo, String url, int size, boolean boost, String title, String country) {
}
