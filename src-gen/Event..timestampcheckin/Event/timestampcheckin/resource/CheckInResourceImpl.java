package Event..timestampcheckin.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import Event..core.resource.CheckInResourceDecorator;
import Event..core.resource.CheckInResourceComponent;
import Event..core.model.;
import Event..core.model.CheckInImpl;
import Event..core.service.CheckInServiceComponent;
import Event..timestampcheckin.service.CheckInServiceImpl;

public class CheckInResourceImpl extends CheckInResourceDecorator {
	protected CheckInServiceComponent recordComponent;
	private CheckInServiceImpl invalidtimestampcheckinServiceImpl = new CheckInServiceImpl(recordComponent);

    public CheckInResourceImpl (CheckInResourceComponent record) {
        super(record);
    }

    
    @Route(url="call/timestampcheckin/save")
    public List<HashMap<String,Object>> saveinvalid(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		invalid invalidtimestampcheckin = createinvalid(vmjExchange);
		return getAllinvalid(vmjExchange);
	}

    public  createinvalid(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			invalid result = invalidtimestampcheckinServiceImpl.createinvalid(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public  createinvalid(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			invalid result = invalidtimestampcheckinServiceImpl.createinvalid(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/timestampcheckin/update")
    public HashMap<String, Object> updateinvalid(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return invalidtimestampcheckinServiceImpl.updateinvalid(requestBody);
	}

	
    @Route(url="call/timestampcheckin/detail")
    public HashMap<String, Object> getinvalid(VMJExchange vmjExchange){
		return record.getinvalid(vmjExchange);
	}

	
    @Route(url="call/timestampcheckin/list")
    public List<HashMap<String,Object>> getAllinvalid(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return invalidtimestampcheckinServiceImpl.getAllinvalid();
	}

    public List<HashMap<String,Object>> transforminvalidListToHashMap(List<invalid> invalidTimeStampCheckInList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < invalidTimeStampCheckInList.size(); i++) {
            resultList.add(invalidTimeStampCheckInList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/timestampcheckin/delete")
    public List<HashMap<String,Object>> deleteinvalid(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return invalidtimestampcheckinServiceImpl.deleteinvalid(requestBody);
	}

	
}
