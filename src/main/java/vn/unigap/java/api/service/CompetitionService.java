package vn.unigap.java.api.service;

import vn.unigap.java.api.dto.out.CompetitionDtoOut;
import vn.unigap.java.api.dto.out.ListDtoOut;

public interface CompetitionService {
    ListDtoOut<CompetitionDtoOut> list();

    CompetitionDtoOut get(Integer id);
}
