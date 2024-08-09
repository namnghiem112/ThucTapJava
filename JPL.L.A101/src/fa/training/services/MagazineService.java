package fa.training.services;

import fa.training.entities.Magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MagazineService {
    private List<Magazine> magazines = new ArrayList<>();

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    public List<Magazine> getTop10MagazinesByVolume() {
        return magazines.stream()
                .sorted(Comparator.comparingInt(Magazine::getVolume).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
