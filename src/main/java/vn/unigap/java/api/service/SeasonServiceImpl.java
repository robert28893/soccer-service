package vn.unigap.java.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.java.api.dto.in.ListSeasonDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.SeasonDtoOut;
import vn.unigap.java.api.repository.season.SeasonRepository;

import java.util.List;

@Service
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public ListDtoOut<SeasonDtoOut> list(ListSeasonDtoIn listSeasonDtoIn) {
        List<SeasonDtoOut> seasons = seasonRepository.findByCompetitionId(
                        listSeasonDtoIn.getCompetitionId()
                ).stream()
                .map(season -> SeasonDtoOut.builder()
                        .id(season.getId())
                        .name(season.getName())
                        .build()).toList();
        return ListDtoOut.<SeasonDtoOut>builder()
                .data(seasons)
                .build();
    }
}
