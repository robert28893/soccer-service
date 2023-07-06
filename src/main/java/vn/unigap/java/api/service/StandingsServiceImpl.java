package vn.unigap.java.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.java.api.dto.in.GetStandingsDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.StandingsDtoOut;
import vn.unigap.java.api.repository.competition.CustomCompetitionRepository;

@Service
public class StandingsServiceImpl implements StandingsService {
	private final CustomCompetitionRepository customCompetitionRepository;

	@Autowired
	public StandingsServiceImpl(CustomCompetitionRepository customCompetitionRepository) {
		this.customCompetitionRepository = customCompetitionRepository;
	}

	@Override
	public ListDtoOut<StandingsDtoOut> get(GetStandingsDtoIn getStandingsDtoIn) {
		return customCompetitionRepository.getStandings(getStandingsDtoIn);
	}
}
