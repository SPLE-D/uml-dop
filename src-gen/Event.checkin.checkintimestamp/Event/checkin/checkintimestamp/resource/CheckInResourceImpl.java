package Event.checkin.checkintimestamp.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event.checkin.core.resource.CheckInResourceDecorator;
import Event.checkin.core.resource.CheckInResourceComponent;
import Event.checkin.core.model.CheckIn;
import Event.checkin.core.model.CheckInImpl;
import Event.checkin.core.service.CheckInServiceComponent;
import Event.checkin.checkintimestamp.service.CheckInServiceImpl;

public class CheckInResourceImpl extends CheckInResourceDecorator {
	protected CheckInServiceComponent recordComponent;
	private CheckInServiceImpl checkincheckintimestampServiceImpl = new CheckInServiceImpl(recordComponent);

    public CheckInResourceImpl (CheckInResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/checkintimestamp/save")
    public List<HashMap<String,Object>> saveCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		CheckIn checkincheckintimestamp = createCheckIn(vmjExchange);
		return getAllCheckIn(vmjExchange);
	}

    public CheckIn createCheckIn(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkincheckintimestampServiceImpl.createCheckIn(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public CheckIn createCheckIn(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			CheckIn result = checkincheckintimestampServiceImpl.createCheckIn(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/checkintimestamp/update")
    public HashMap<String, Object> updateCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return checkincheckintimestampServiceImpl.updateCheckIn(requestBody);
	}

	
    @Route(url="call/checkintimestamp/detail")
    public HashMap<String, Object> getCheckIn(VMJExchange vmjExchange){
		return record.getCheckIn(vmjExchange);
	}

	
    @Route(url="call/checkintimestamp/list")
    public List<HashMap<String,Object>> getAllCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return checkincheckintimestampServiceImpl.getAllCheckIn();
	}

    public List<HashMap<String,Object>> transformCheckInListToHashMap(List<CheckIn> CheckInCheckInTimeStampList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < CheckInCheckInTimeStampList.size(); i++) {
            resultList.add(CheckInCheckInTimeStampList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/checkintimestamp/delete")
    public List<HashMap<String,Object>> deleteCheckIn(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return checkincheckintimestampServiceImpl.deleteCheckIn(requestBody);
	}

	
}
