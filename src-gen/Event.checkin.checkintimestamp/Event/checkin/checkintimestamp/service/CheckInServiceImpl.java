package Event.checkin.checkintimestamp.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event.checkin.core.service.CheckInServiceDecorator;
import Event.checkin.core.model.CheckInImpl;
import Event.checkin.core.service.CheckInServiceComponent;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.model.CheckInDecorator;
import Event.checkin.CheckInFactory;

public class CheckInServiceImpl extends CheckInServiceDecorator {
    public CheckInServiceImpl (CheckInServiceComponent record) {
        super(record);
    }

 	public CheckIn createCheckIn(Map<String, Object> requestBody){
		String checkInIdStr = (String) requestBody.get("checkInId");
		int checkInId = Integer.parseInt(checkInIdStr);
		boolean attended = (boolean) requestBody.get("attended");
		CheckIn checkincheckintimestamp = record.createCheckIn(requestBody);
		CheckIn checkincheckintimestampdeco = CheckInFactory.createCheckIn("Event.checkin.checkintimestamp", checkincheckintimestamp, checkInId, attended, attendeemanagementimpl, timestamp);
		Repository.saveObject(checkincheckintimestampdeco);
		return checkincheckintimestampdeco;
	}

	public CheckIn createCheckIn(Map<String, Object> requestBody, int id){
		CheckIn savedCheckIn = Repository.getObject(id);
		String checkInIdStr = (String) requestBody.get("checkInId");
		int checkInId = Integer.parseInt(checkInIdStr);
		boolean attended = (boolean) requestBody.get("attended");
		UUID recordCheckInCheckInId = ((CheckInDecorator) savedCheckIn).getCheckInId();
		CheckIn CheckIn = record.createCheckIn(requestBody, recordCheckInCheckInId);
		CheckIn checkincheckintimestamp = CheckInFactory.createCheckIn("Event.checkin.checkintimestamp.model.CheckInImpl", CheckIn, checkInId, attended, attendeemanagementimpl, timestamp);
		return checkincheckintimestamp;
	}

    public HashMap<String, Object> updateCheckIn(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("checkInId");
		
		CheckIn checkincheckintimestamp = Repository.getObject(id);
		checkincheckintimestamp = createCheckIn(requestBody, id);
		
		Repository.updateObject(checkincheckintimestamp);
		checkincheckintimestamp = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return checkincheckintimestamp.toHashMap();
	}

	public HashMap<String, Object> getCheckIn(String idStr){
		int id = Integer.parseInt(idStr);
		CheckIn checkincheckintimestamp = Repository.getObject(id);
		return checkincheckintimestamp.toHashMap();
	}

	public HashMap<String, Object> getCheckInById(int id){
		List<HashMap<String, Object>> checkinList = getAllCheckIn();
		for (HashMap<String, Object> checkin : checkinList){
			int checkin_id = ((Double) checkin.get("checkinid")).intValue();
			if (checkin_id == id){
				return checkin;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllCheckIn(){
		List<CheckIn> List = Repository.getAllObject("checkin_checkintimestamp");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<CheckIn> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteCheckIn(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("checkInId"));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllCheckIn();
	}

	
}
