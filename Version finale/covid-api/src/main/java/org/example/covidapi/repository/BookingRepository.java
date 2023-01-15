
package org.example.covidapi.repository;

import java.time.LocalDate;

import org.example.covidapi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public Booking findByDate(LocalDate date);

}
