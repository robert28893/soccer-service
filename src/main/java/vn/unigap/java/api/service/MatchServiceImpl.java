package vn.unigap.java.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.unigap.java.api.dto.in.ListMatchDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.ManagerDtoOut;
import vn.unigap.java.api.dto.out.MatchDtoOut;
import vn.unigap.java.api.repository.manager.ManagerRepository;
import vn.unigap.java.api.repository.match.CustomMatchRepository;
import vn.unigap.java.api.repository.player.CustomPlayerRepository;

@Service
public class MatchServiceImpl implements MatchService {

	private final CustomMatchRepository customMatchRepository;
	private final ManagerRepository managerRepository;
	private final CustomPlayerRepository customPlayerRepository;

	@Autowired
	public MatchServiceImpl(
			CustomMatchRepository customMatchRepository,
			ManagerRepository managerRepository,
			CustomPlayerRepository customPlayerRepository) {
		this.customMatchRepository = customMatchRepository;
		this.managerRepository = managerRepository;
		this.customPlayerRepository = customPlayerRepository;
	}

	@Override
	public ListDtoOut<MatchDtoOut> list(ListMatchDtoIn listMatchDtoIn) {
		return customMatchRepository.listMatches(listMatchDtoIn.getCompetitionId(),
				listMatchDtoIn.getSeasonId());
	}

	@Override
	public MatchDtoOut get(Integer id) {
		MatchDtoOut matchDtoOut = customMatchRepository.findById(id);
		matchDtoOut.setHomeTeamManagers(
				managerRepository.findByMatchIdAndTeamId(matchDtoOut.getId(), matchDtoOut.getHomeTeamId())
						.stream().map(m -> ManagerDtoOut.builder()
						.id(m.getId())
						.name(m.getName())
						.nickname(m.getNickname())
						.dob(m.getDob())
						.build()).toList()
		);
		matchDtoOut.setAwayTeamManagers(
				managerRepository.findByMatchIdAndTeamId(matchDtoOut.getId(), matchDtoOut.getAwayTeamId())
						.stream().map(m -> ManagerDtoOut.builder()
						.id(m.getId())
						.name(m.getName())
						.nickname(m.getNickname())
						.dob(m.getDob())
						.build()).toList());

		matchDtoOut.setHomeTeamLineups(
				customPlayerRepository.findByMatchIdAndTeamId(matchDtoOut.getId(), matchDtoOut.getHomeTeamId())
		);
		matchDtoOut.setAwayTeamLineups(
				customPlayerRepository.findByMatchIdAndTeamId(matchDtoOut.getId(), matchDtoOut.getAwayTeamId())
		);

		return matchDtoOut;
	}
}
