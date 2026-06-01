package Event..timestampcheckin.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import Event..core.service.CheckInServiceDecorator;
import Event..core.model.CheckInImpl;
import Event..core.service.CheckInServiceComponent;
import Event..core.model.;
import Event..core.model.invalidDecorator;
import Event..invalidFactory;

public class CheckInServiceImpl extends CheckInServiceDecorator {
    public CheckInServiceImpl (CheckInServiceComponent record) {
        super(record);
    }

 	public invalid createinvalid(Map<String, Object> requestBody){
		invalid invalidtimestampcheckin = record.createinvalid(requestBody);
		invalid invalidtimestampcheckindeco = invalidFactory.createinvalid("Event..timestampcheckin", invalidtimestampcheckin, , timestamp);
		Repository.saveObject(invalidtimestampcheckindeco);
		return invalidtimestampcheckindeco;
	}

	public invalid createinvalid(Map<String, Object> requestBody, int id){
		invalid savedinvalid = Repository.getObject(id);
		UUID recordinvalid = ((invalidDecorator) savedinvalid).get();
		invalid invalid = record.createinvalid(requestBody, recordinvalid);
		invalid invalidtimestampcheckin = invalidFactory.createinvalid("Event..timestampcheckin.model.CheckInImpl", invalid, , timestamp);
		return invalidtimestampcheckin;
	}

    public HashMap<String, Object> updateinvalid(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("");
		
		invalid invalidtimestampcheckin = Repository.getObject(id);
		invalidtimestampcheckin = createinvalid(requestBody, id);
		
		Repository.updateObject(invalidtimestampcheckin);
		invalidtimestampcheckin = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return invalidtimestampcheckin.toHashMap();
	}

	public HashMap<String, Object> getinvalid(String idStr){
		int id = Integer.parseInt(idStr);
		invalid invalidtimestampcheckin = Repository.getObject(id);
		return invalidtimestampcheckin.toHashMap();
	}

	public HashMap<String, Object> getinvalidById(int id){
		List<HashMap<String, Object>> invalidList = getAllinvalid();
		for (HashMap<String, Object> invalid : invalidList){
			int invalid_id = ((Double) invalid.get("")).intValue();
			if (invalid_id == id){
				return invalid;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllinvalid(){
		List<invalid> List = Repository.getAllObject("_timestampcheckin");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<invalid> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteinvalid(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get(""));
		int id = Integer.parseInt(idStr);
		Repository.deleteObject(id);
		return getAllinvalid();
	}

	
}
