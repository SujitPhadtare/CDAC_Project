package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomDTO;
import com.app.dto.GetBookingListDTO;
import com.app.dto.PostFeedbackDTO;
import com.app.dto.ResponseDTO;
import com.app.pojos.Bus;
import com.app.service.IBusService;
import com.app.service.IBookingService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	public CustomerController() {
		System.out.println("in ctor of : " + getClass().getName());
	}

	@Autowired
	private IBusService busService;
	@Autowired
	private IBookingService bookingService;

	@GetMapping("/search_bus/{departureDate}")
	public ResponseEntity<?> searchBus(@RequestParam String fromCity, @RequestParam String toCity,
			@PathVariable String departureDate) {
		List<Bus> busList = busService.searchBus(fromCity, toCity, LocalDate.parse(departureDate));
		System.out.println(departureDate);
		if (!busList.isEmpty()) {
			return new ResponseEntity<>(busList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Currently No Bus Available For this Route", HttpStatus.OK);
		}

	}

	@GetMapping("/select_bus")
	public ResponseEntity<?> selectBus(@RequestParam int aid) {
		System.out.println("in select bus : " + aid);
		return new ResponseEntity<>(new ResponseDTO<>("success", busService.selectBusFromListById(aid)), HttpStatus.OK);
	}

	@PutMapping("/post_feedback")
	public ResponseEntity<?> postFeedback(@RequestParam int bid, @RequestBody PostFeedbackDTO feedbackDto) {
		System.out.println("in post Feedback " + bid + " " + feedbackDto);

		return new ResponseEntity<>(bookingService.postFeedback(bid, feedbackDto.getFeedback()), HttpStatus.OK);
	}

	@PostMapping("/book-ticket")
	public ResponseEntity<?> getData(@RequestBody CustomDTO custDto) {
		return new ResponseEntity<>(bookingService.bookTicket(custDto), HttpStatus.OK);
	}

	@DeleteMapping("/cancel_ticket")
	public ResponseEntity<?> cancelTicket(@RequestParam int bId) {
		bookingService.deleteBooking(bId);
		return new ResponseEntity<>("Booking Deleted Successfully!!!!", HttpStatus.OK);
	}
	@GetMapping("/get_userbookings/{uid}")
	public ResponseEntity<?> getBookingByUserId(@PathVariable int uid){
		List<GetBookingListDTO> list = bookingService.findByUserId(uid);
		if (!list.isEmpty())
			return new ResponseEntity<>(new ResponseDTO<>("success", list), HttpStatus.OK);
		else
			return new ResponseEntity<>(new ResponseDTO<>("error", "no bookings yet"), HttpStatus.OK);
	}
}
