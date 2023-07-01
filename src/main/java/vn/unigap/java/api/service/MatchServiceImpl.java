package vn.unigap.java.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.java.api.dto.in.ListMatchDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.MatchDtoOut;
import vn.unigap.java.api.repository.match.CustomMatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

    private final CustomMatchRepository customMatchRepository;

    @Autowired
    public MatchServiceImpl(CustomMatchRepository customMatchRepository) {
        this.customMatchRepository = customMatchRepository;
    }

    @Override
    public ListDtoOut<MatchDtoOut> list(ListMatchDtoIn listMatchDtoIn) {
        return customMatchRepository.listMatches(listMatchDtoIn.getCompetitionId(),
                listMatchDtoIn.getSeasonId());
    }
}
