package Event.eventcreation.typeeventcreation.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event.eventcreation.core.model.EventCreationDecorator;
import Event.eventcreation.core.model.EventCreation;
import Event.eventcreation.core.model.EventCreationComponent;

@Entity(name="eventcreation_typeeventcreation")
@Table(name="eventcreation_typeeventcreation")
public class EventCreationImpl extends EventCreationDecorator {

	public EventCreationImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = EventCreationImpl.class.getName();
    }

	public EventCreationImpl(EventCreationComponent record,  eventType, EventType eventtype) {
		super(record, EventCreationImpl.class.getName());
		this.objectName = EventCreationImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("eventId", eventId);

        return map;
    }

}
