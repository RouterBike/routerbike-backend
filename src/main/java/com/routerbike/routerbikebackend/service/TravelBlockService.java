package com.routerbike.routerbikebackend.service;

import com.routerbike.routerbikebackend.repository.TravelBlockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.routerbike.routerbikebackend.model.TravelBock;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelBlockService {

    @Autowired
    TravelBlockRepo travelRepo;

    //CREATE
    public TravelBock createTravelBlock(TravelBock tb) {
        return travelRepo.save(tb);
    }

    //READ
    public List<TravelBock> getTravelBlocks() {
        return travelRepo.findAll();
    }

    //DELETE
    public void deleteTravelBlock(Long tbId) {
        travelRepo.deleteById(tbId);
    }

    //UPDATE
    public TravelBock updateTravelBlock(Long tbId, TravelBock travelDetails) {
        TravelBock travel = travelRepo.findById(tbId).get();
        travel.setLocation(travelDetails.getLocation());
        travel.setScenery(travelDetails.getScenery());
        travel.setRoadCondition(travelDetails.getRoadCondition());
        travel.setRoadType(travelDetails.getRoadType());
        travel.setDifficulty(travelDetails.getDifficulty());

        return travelRepo.save(travel);
    }

    /**
     * @param scenery
     * @param roadCondition
     * @param roadType
     * @param difficulty
     * @return
     */
    //FILTER
    public List<TravelBock> getFilteredTravelBlocks(String scenery, String roadCondition, String roadType, String difficulty) {
        List<TravelBock> filteredBlocks = travelRepo.findAll();

        if (scenery != null) {
            filteredBlocks = filteredBlocks.stream()
                    .filter(block -> block.getScenery().equalsIgnoreCase(scenery))
                    .collect(Collectors.toList());
        }

        if (roadCondition != null) {
            filteredBlocks = filteredBlocks.stream()
                    .filter(block -> block.getRoadCondition().equalsIgnoreCase(roadCondition))
                    .collect(Collectors.toList());
        }

        if (roadType != null) {
            filteredBlocks = filteredBlocks.stream()
                    .filter(block -> block.getRoadType().equalsIgnoreCase(roadType))
                    .collect(Collectors.toList());
        }

        if (difficulty != null) {
            filteredBlocks = filteredBlocks.stream()
                    .filter(block -> block.getDifficulty().equalsIgnoreCase(difficulty))
                    .collect(Collectors.toList());
        }

        return filteredBlocks;
    }


}
