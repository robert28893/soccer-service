package vn.unigap.java.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.java.api.dto.out.CompetitionDtoOut;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.repository.competition.CompetitionRepository;

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
}
