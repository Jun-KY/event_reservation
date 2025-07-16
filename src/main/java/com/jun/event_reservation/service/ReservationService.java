package com.jun.event_reservation.service;

import com.jun.event_reservation.dto.ReservationDto;
import com.jun.event_reservation.model.Event;
import com.jun.event_reservation.model.Reservation;
import com.jun.event_reservation.repository.EventRepository;
import com.jun.event_reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service @RequiredArgsConstructor @Transactional
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;

    public Page<Reservation> getByEvent(Long eventId, Pageable pageable){
        return reservationRepository.findByEventId(eventId, pageable);
    }

    public Reservation create (Long eventId, ReservationDto reservationDto){
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new NoSuchElementException("No event found"));

        Reservation reservation = new Reservation();
        reservation.setEvent(event);

        reservation.setAttendeeName((reservationDto.getAttendeeName()));

        reservation.setSeats(reservationDto.getSeats());

        return reservationRepository.save(reservation);
    }

    public Reservation update (Long id, ReservationDto reservationDto){
        Reservation existReservation = reservationRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No reservation found"));

        existReservation.setAttendeeName(reservationDto.getAttendeeName());
        existReservation.setSeats(reservationDto.getSeats());

        return reservationRepository.save(existReservation);
    }

    public void delete(Long id){
        reservationRepository.deleteById(id);
    }
}
