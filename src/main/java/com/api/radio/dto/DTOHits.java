package com.api.radio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DTOHits(String _id, String _score, DTOSource _source) {
}
