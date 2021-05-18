package br.com.github.kalilventura.tdd.usecase;

import br.com.github.kalilventura.tdd.model.Booking;
import br.com.github.kalilventura.tdd.repository.BookingRepository;
import br.com.github.kalilventura.tdd.usecase.booking.DaysCalculatorUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DaysCalculatorUseCaseTest {
    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private DaysCalculatorUseCase bookingService;

    @BeforeAll
    void initUseCase() {
        bookingService = new DaysCalculatorUseCase(bookingRepository);

        LocalDate checkIn = LocalDate.parse("2020-11-10");
        LocalDate checkout = LocalDate.parse("2020-11-20");

        Booking booking = new Booking("1", "John", checkIn, checkout, 2);

        Mockito.when(bookingRepository.findByReservedName(booking.getReserveName()))
                .thenReturn(java.util.Optional.of(booking));
    }

    @Test
    public void bookingTestServiceDaysCalculator() {
        String name = "John";
        int days = bookingService.daysCalculator(name);

        Assertions.assertEquals(days, 10);
    }

}
