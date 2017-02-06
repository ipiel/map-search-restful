package com.example;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoiController {
    @Autowired
    private PoiDao poiDao;
    
    @GetMapping("/public_toilet")
    public List<Poi> list(Model model, 
    		@RequestParam(required=false) String fromLong, @RequestParam(required=false) String toLong,
    		@RequestParam(required=false) String fromLat, @RequestParam(required=false) String toLat) {
    	
    	List<Poi> poiList = poiDao.findAll();
    	Double minLongitude = (fromLong == null) ? null : Double.parseDouble(fromLong),
    		maxLongitude = (toLong == null) ? null : Double.parseDouble(toLong),
			minLatitude = (fromLat == null) ? null : Double.parseDouble(fromLat),
    		maxLatitude = (toLat == null) ? null : Double.parseDouble(toLat);
    	Poi temp;

    	for (Iterator<Poi> it = poiList.iterator(); it.hasNext(); ) {
    		temp = it.next();
    		
    		if ((minLongitude != null && temp.getLongitude() < minLongitude) ||
    			(maxLongitude != null && temp.getLongitude() > maxLongitude) ||
				(minLatitude != null && temp.getLatitude() < minLatitude) ||
				(maxLatitude != null && temp.getLatitude() > maxLatitude)) {
    				it.remove();
    		}
    	}

    	return poiList;
    }
    
    @GetMapping("/public_toilet/count")
    public long count(Model model) {
    	long count = poiDao.count();
    	
    	return count;
    }
}