package nl.jordyvanraalte.ergast.dto.racedetail;

import java.util.ArrayList;
import java.util.List;

public class RaceDetailDTO {
    public List<GridDTO> grid;
    public List<RaceResultDTO> results;

    public RaceDetailDTO(List<GridDTO> grid, List<RaceResultDTO> result) {
        this.grid = grid;
        this.results = result;
    }

    public List<GridDTO> getGrid() {
        return grid;
    }

    public void setGrid(List<GridDTO> grid) {
        this.grid = grid;
    }

    public List<RaceResultDTO> getResults() {
        return results;
    }

    public void setResults(List<RaceResultDTO> result) {
        this.results = result;
    }
}
