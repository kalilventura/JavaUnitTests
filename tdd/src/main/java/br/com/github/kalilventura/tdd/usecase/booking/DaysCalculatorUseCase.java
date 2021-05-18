package br.com.github.kalilventura.tdd.usecase.booking;

import br.com.github.kalilventura.tdd.model.Booking;
import br.com.github.kalilventura.tdd.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DaysCalculatorUseCase {
    private final BookingRepository bookingRepository;

    public int daysCalculator(String name) {
        Optional<Booking> booking = bookingRepository.findByReservedName(name);
        return Period.between(booking.get().getCheckIn(), booking.get().getCheckOut()).getDays();
    }
}
