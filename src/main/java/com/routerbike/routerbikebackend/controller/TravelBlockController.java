package com.routerbike.routerbikebackend.controller;

import com.routerbike.routerbikebackend.model.TravelBock;
import com.routerbike.routerbikebackend.service.TravelBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TravelBlockController {
    @Autowired
    TravelBlockService travelService;

    //Create a travel block
    @RequestMapping(value="/travelBlocks", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public TravelBock createTravelBlock(@RequestBody TravelBock travel) {
        return travelService.createTravelBlock(travel);
    }
    // Get whole list or Filter with queries travel blocks
    @GetMapping("/travelBlocks")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<TravelBock>> getFilteredTravelBlocks(
            @RequestParam(required = false) String scenery,
            @RequestParam(required = false) String roadCondition,
            @RequestParam(required = false) String roadType,
            @RequestParam(required = false) String difficulty) {
        // Call the service method to get the filtered travel blocks based on the provided parameters
        List<TravelBock> filteredBlocks = travelService.getFilteredTravelBlocks(scenery, roadCondition, roadType, difficulty);

        return ResponseEntity.ok(filteredBlocks);
    }

    // Edit one travel block
    @RequestMapping(value = "/travelBlocks/{tbId}", method=RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:3000")
    public TravelBock readTravelBlocks(@PathVariable(value = "tbId") Long id, @RequestBody TravelBock travelDetails) {
        return travelService.updateTravelBlock(id,travelDetails);
    }
    // Delete one travel block
    @RequestMapping(value = "/travelBlocks/{tbId}", method=RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteTravelBlocks(@PathVariable(value = "tbId") Long id) {
        travelService.deleteTravelBlock(id);
    }


}
