package vn.unigap.java.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.unigap.java.api.dto.out.CompetitionDtoOut;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.entity.Competition;
import vn.unigap.java.api.repository.competition.CompetitionRepository;
import vn.unigap.java.common.errorcode.ErrorCode;
import vn.unigap.java.common.exception.ApiException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public ListDtoOut<CompetitionDtoOut> list() {
        List<CompetitionDtoOut> data = competitionRepository.findAll().stream()
                .map(c -> CompetitionDtoOut.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .countryName(c.getCountryName())
                        .gender(c.getGender())
                        .build()).collect(Collectors.toList());
        return ListDtoOut.<CompetitionDtoOut>builder()
                .data(data)
                .build();
    }

    @Override
    public CompetitionDtoOut get(Integer id) {
        Competition competition = this.competitionRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND,
                        String.format("competition not found: %s", id)));
        return CompetitionDtoOut.builder()
                .id(competition.getId())
                .countryName(competition.getCountryName())
                .gender(competition.getGender())
                .name(competition.getName())
                .build();
    }
}
