package vn.unigap.java.api.service;

import vn.unigap.java.api.dto.in.ListSeasonDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.SeasonDtoOut;

public interface SeasonService {
    ListDtoOut<SeasonDtoOut> list(ListSeasonDtoIn listSeasonDtoIn);
}
