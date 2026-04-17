package com.thtek.irctcautobooker.respository;

import com.thtek.irctcautobooker.entity.PackDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackInfoRepository extends JpaRepository<PackDetails, String> {

    public String getPackDetailsById(String id);
}
