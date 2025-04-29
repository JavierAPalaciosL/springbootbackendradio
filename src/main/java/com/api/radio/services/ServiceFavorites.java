package com.api.radio.services;

import com.api.radio.repository.FavoritesRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ServiceFavorites {

    private final FavoritesRepository favoritesRepository;




}
