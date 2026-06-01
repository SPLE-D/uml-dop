package Event..timestampcheckin.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import Event..core.model.CheckInDecorator;
import Event..core.model.CheckIn;
import Event..core.model.CheckInComponent;

@Entity(name="_timestampcheckin")
@Table(name="_timestampcheckin")
public class CheckInImpl extends CheckInDecorator {

	public EDate timestamp;
	public CheckInImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = CheckInImpl.class.getName();
    }

	public CheckInImpl(CheckInComponent record, EDate timestamp) {
		super(record, CheckInImpl.class.getName());
		this.timestamp = timestamp;
		this.objectName = CheckInImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("", );
		map.put("timestamp", getTimestamp());

        return map;
    }

}
