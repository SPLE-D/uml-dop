package uml-dop.attendeemanagement.classattendeemanagement.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import uml-dop.attendeemanagement.core.model.AttendeeManagementDecorator;
import uml-dop.attendeemanagement.core.model.AttendeeManagement;
import uml-dop.attendeemanagement.core.model.AttendeeManagementComponent;

@Entity(name="attendeemanagement_classattendeemanagement")
@Table(name="attendeemanagement_classattendeemanagement")
public class AttendeeManagementImpl extends AttendeeManagementDecorator {

	public String attendeeClass;
	public AttendeeManagementImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = AttendeeManagementImpl.class.getName();
    }

	public AttendeeManagementImpl(AttendeeManagementComponent record, String attendeeClass) {
		super(record, AttendeeManagementImpl.class.getName());
		this.attendeeClass = attendeeClass;
		this.objectName = AttendeeManagementImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("attendeeId", attendeeId);
		map.put("attendeeClass", getAttendeeClass());

        return map;
    }

}
