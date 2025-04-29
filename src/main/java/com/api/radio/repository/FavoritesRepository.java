package com.api.radio.repository;

import com.api.radio.entity.Favorites;
import com.api.radio.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface FavoritesRepository extends JpaRepository<Favorites, UUID> {

    Favorites findFavoritesByUserRelationShip(Users userRelationShip);

}
