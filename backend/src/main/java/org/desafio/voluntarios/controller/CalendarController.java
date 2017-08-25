package org.desafio.voluntarios.controller;

import java.io.IOException;
import java.util.List;

import org.desafio.voluntarios.service.CalendarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.calendar.model.Calendar;

@RestController
public class CalendarController {

	@RequestMapping(method = RequestMethod.POST, path = "/v1/calendars", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Calendar> criaAgenda() throws IOException {
		return ResponseEntity.ok(CalendarService.criaAgenda());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/v1/calendars/{calendarId}/share", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus(value = HttpStatus.OK)
	public void compartilhaAgenda(@PathVariable String calendarId, @RequestBody List<String> emails) {
		CalendarService.compartilhaAgenda(calendarId, emails);
	}
	
}
