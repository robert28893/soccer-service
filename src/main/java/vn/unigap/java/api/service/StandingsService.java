package vn.unigap.java.api.service;

import vn.unigap.java.api.dto.in.GetStandingsDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.StandingsDtoOut;

public interface StandingsService {
	ListDtoOut<StandingsDtoOut> get(GetStandingsDtoIn getStandingsDtoIn);
}
