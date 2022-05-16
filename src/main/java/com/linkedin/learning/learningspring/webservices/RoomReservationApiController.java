package com.linkedin.learning.learningspring.webservices;

import com.linkedin.learning.learningspring.business.ReservationService;
import com.linkedin.learning.learningspring.business.RoomReservation;
import com.linkedin.learning.learningspring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RoomReservationApiController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public RoomReservationApiController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations" ,method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateString, Model model){

        System.out.println("Ostrha");

        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }
}
