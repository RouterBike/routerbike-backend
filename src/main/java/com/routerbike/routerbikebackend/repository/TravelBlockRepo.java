package com.routerbike.routerbikebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.routerbike.routerbikebackend.model.TravelBock;

@Repository
public interface TravelBlockRepo extends JpaRepository<TravelBock, Long> {

}
