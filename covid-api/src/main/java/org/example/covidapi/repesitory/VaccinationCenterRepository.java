package org.example.covidapi.repesitory;

import java.util.List;

import org.example.covidapi.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCentre, Integer> {
    public List<VaccinationCentre> findAllByCityIgnoreCaseLike(String city);

    // public List<VaccinationCentre> findAllByCityLike(String city);

    @Query("from VaccinationCentre v where v.city like :city")
    public VaccinationCentre findAllCityIgnoreCaseLike(@Param("city") String city);

}
