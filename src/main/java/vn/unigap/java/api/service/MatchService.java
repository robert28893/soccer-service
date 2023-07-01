package vn.unigap.java.api.service;

import vn.unigap.java.api.dto.in.ListMatchDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.MatchDtoOut;

public interface MatchService {
    ListDtoOut<MatchDtoOut> list(ListMatchDtoIn listMatchDtoIn);
}
