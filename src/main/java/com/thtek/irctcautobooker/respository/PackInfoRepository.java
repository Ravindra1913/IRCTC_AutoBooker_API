package com.thtek.irctcautobooker.respository;

import com.thtek.irctcautobooker.model.PackDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PackInfoRepository extends JpaRepository<PackDetails, String> {

    public String getPackDetailsById(String id);
    @Query("SELECT p.expiryTimeStamp FROM PackDetails p WHERE p.phNo = :phNo AND p.isActive = true ORDER BY p.dateTime DESC LIMIT 1")
    public Date getPackDetailsByphNo(@Param("phNo") String phNo);
}
