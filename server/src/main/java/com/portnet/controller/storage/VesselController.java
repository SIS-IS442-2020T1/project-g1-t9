package com.portnet.controller.storage;

import java.text.ParseException;
import java.util.List;

import com.portnet.entity.storage.Vessel;
import com.portnet.service.storage.VesselService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VesselController {
    @Autowired
    private VesselService vesselService;

    /**
     * Get methods
     * 
     * @throws ParseException
     */
    @GetMapping(value = "/vessels", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> getVesselsByDate(@RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate) {
        List<Vessel> vesselList = vesselService.getVesselsByDate(startDate, endDate);
        return ResponseEntity.ok(vesselList);   
    }
}