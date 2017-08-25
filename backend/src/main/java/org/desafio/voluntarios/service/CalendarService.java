package org.desafio.voluntarios.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.AclRule;
import com.google.api.services.calendar.model.AclRule.Scope;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;

@Service
public class CalendarService {

    /** Application name. */
    private static final String APPLICATION_NAME = "Desafio Voluntários";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/calendar-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;    
    
    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/calendar-java-quickstart
     */
    private static final List<String> SCOPES = Arrays.asList(CalendarScopes.CALENDAR);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
    
    private static com.google.api.services.calendar.Calendar calendarService;
    
    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    private static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in = CalendarService.class.getResourceAsStream("/client_secret.json");
        
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("onffline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println( "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Calendar client service.
     * @return an authorized Calendar client service
     * @throws IOException
     */
    private static com.google.api.services.calendar.Calendar getCalendarService() throws IOException {
    	
    	if(calendarService == null) {
    	
	        Credential credential = authorize();
	        calendarService =  new com.google.api.services.calendar.Calendar.Builder(
	                HTTP_TRANSPORT, JSON_FACTORY, credential)
	                .setApplicationName(APPLICATION_NAME)
	                .build();
    	}
    	return calendarService;
    	
    }

    public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        // Note: Do not confuse this class with the
        //   com.google.api.services.calendar.model.Calendar class.
        com.google.api.services.calendar.Calendar service =
        getCalendarService();

        
//        concedeAcesso(service);
        
        // List the next 10 events from the primary calendar.
//        DateTime now = new DateTime(System.currentTimeMillis());
//        
//        CalendarListEntry calendarListEntry = service.calendarList().get("matera.com_f6rl20i66o76htsm8ekue88ti4@group.calendar.google.com")
//        		.execute();
//        
//        System.out.println(calendarListEntry);
        
//        criaAgenda(service);
        
//        CalendarList calendarList = service.calendarList().list()
//        		.execute();
//        
//        List<CalendarListEntry> calendarItems = calendarList.getItems();
//        
//        if (calendarItems.size() == 0) {
//            System.out.println("Nenhuma agenda encontrada");
//        } else {
//            System.out.println("Agendas configuradas");
//            for (CalendarListEntry calendarListEntry : calendarItems) {
//            	System.out.printf("%s - %s - %s - (%s)\n", 
//            			calendarListEntry.getId(),
//            			calendarListEntry.getEtag(),
//            			calendarListEntry.getSelected(),
//            			calendarListEntry.getSummary());            	
//			}
//        }
        
//        Events events = service.events().list("matera.com_b0rodpvuus0ck9h1abfclcr9sg@group.calendar.google.com")
//            .setMaxResults(10)
//            .setTimeMin(now)
////            .setOrderBy("startTime")
//            .setSingleEvents(true)
//            .execute();
//        List<Event> items = events.getItems();
//        if (items.size() == 0) {
//            System.out.println("No upcoming events found.");
//        } else {
//            System.out.println("Upcoming events");
//            for (Event event : items) {
//                DateTime start = event.getStart().getDateTime();
//                if (start == null) {
//                    start = event.getStart().getDate();
//                }
//                System.out.printf("%s (%s)\n", event.getSummary(), start);
//            }
//        }
    }

    public static Calendar criaAgenda() throws IOException {
    	
    	Calendar calendar = new Calendar()
    			.setDescription("Desafio Voluntários")
    			.setLocation("Lar Ternura")
    			.setSummary("Desafio Voluntários")
    			.setTimeZone("America/Sao_Paulo");
    	 	

    	Calendar createdCalendar = getCalendarService().calendars().insert(calendar).execute();

    	System.out.println(createdCalendar.getId());
    	
    	return createdCalendar;
    	
    }
    
    
    
    public static void compartilhaAgenda(String calendarId, List<String> emails) {
    	
    	emails.forEach(email -> {
    		AclRule rule = new AclRule();
        	Scope scope = new Scope()
        			.setType("user")
        			.setValue(email);
        	rule.setScope(scope).setRole("owner");

        	// Insert new access rule
        	AclRule createdRule;
			try {
				createdRule = getCalendarService().acl().insert(calendarId, rule).execute();
				System.out.println(createdRule.getId());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
    	});
    	
    	

    }
    
    private static void criaEvento(com.google.api.services.calendar.Calendar service) throws IOException {
    	
    	Event event = new Event()
    			.setSummary("Teste")
    			.setLocation("Lar ternura")
    			.setDescription("Voluntários");

    	DateTime startDateTime = new DateTime("2017-08-23T21:00:00-03:00");
    	EventDateTime start = new EventDateTime()
    			.setDateTime(startDateTime)
    			.setTimeZone("America/Sao_Paulo");
    	event.setStart(start);

    	DateTime endDateTime = new DateTime("2017-08-23T23:00:00-03:00");
    	EventDateTime end = new EventDateTime()
    			.setDateTime(endDateTime)
    			.setTimeZone("America/Sao_Paulo");
    	event.setEnd(end);

    	String[] recurrence = new String[] {"RRULE:FREQ=WEEKLY;COUNT=2"};
    	event.setRecurrence(Arrays.asList(recurrence));

    	EventAttendee[] attendees = new EventAttendee[] {
    			new EventAttendee().setEmail("teste@teste.com"),
    	};
    	event.setAttendees(Arrays.asList(attendees));

    	EventReminder[] reminderOverrides = new EventReminder[] {
    			new EventReminder().setMethod("email").setMinutes(24 * 60),
    			new EventReminder().setMethod("popup").setMinutes(10),
    	};
    	Event.Reminders reminders = new Event.Reminders()
    			.setUseDefault(false)
    			.setOverrides(Arrays.asList(reminderOverrides));
    	event.setReminders(reminders);

    	String calendarId = "primary";
    	event = service.events().insert(calendarId, event).execute();
    	System.out.printf("Event created: %s\n", event.getHtmlLink());

    }


}
