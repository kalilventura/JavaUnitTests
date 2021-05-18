package br.com.github.kalilventura.tdd.repository;

import br.com.github.kalilventura.tdd.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {
    Optional<Booking> findByReservedName(String name);
}
