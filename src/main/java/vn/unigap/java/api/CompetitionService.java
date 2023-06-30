package vn.unigap.java.api;

import vn.unigap.java.api.dto.out.CompetitionDtoOut;
import vn.unigap.java.api.dto.out.ListDtoOut;

public interface CompetitionService {
	ListDtoOut<CompetitionDtoOut> list();
}
