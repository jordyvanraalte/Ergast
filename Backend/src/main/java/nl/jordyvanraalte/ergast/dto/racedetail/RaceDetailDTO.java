package nl.jordyvanraalte.ergast.dto.racedetail;

import java.util.ArrayList;
import java.util.List;

public class RaceDetailDTO {
    public List<GridDTO> grid;
    public List<RaceResultDTO> raceResult;

    public RaceDetailDTO(List<GridDTO> grid, List<RaceResultDTO> raceResult) {
        this.grid = grid;
        this.raceResult = raceResult;
    }

    public List<GridDTO> getGrid() {
        return grid;
    }

    public List<RaceResultDTO> getRaceResult() {
        return raceResult;
    }
}
