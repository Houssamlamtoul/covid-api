package org.example.covidapi.repository;

import org.example.covidapi.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCentre, Long> {
    public VaccinationCentre findByNameIgnoreCaseLike(String name);

    public VaccinationCentre findById(int id);

    @Query("SELECT MAX(id) FROM VaccinationCentre")
    public Integer findMaxId();

    @Modifying
    @Query("UPDATE VaccinationCentre v SET v.address = :address, v.city = :city, v.name = :name, v.postalCode = :postalCode WHERE v.id = :id")
    public int updateVaccinationCentre(@Param("id") int id, @Param("address") String address,
            @Param("city") String city, @Param("name") String name, @Param("postalCode") String postalCode);
}