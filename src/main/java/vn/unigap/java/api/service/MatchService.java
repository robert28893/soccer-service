package vn.unigap.java.api.service;

import vn.unigap.java.api.dto.in.ListMatchDtoIn;
import vn.unigap.java.api.dto.in.PageDtoIn;
import vn.unigap.java.api.dto.out.ListDtoOut;
import vn.unigap.java.api.dto.out.MatchDtoOut;
import vn.unigap.java.api.dto.out.PageDtoOut;

public interface MatchService {
	PageDtoOut<MatchDtoOut> list(ListMatchDtoIn listMatchDtoIn, PageDtoIn pageDtoIn);

	MatchDtoOut get(Integer id);
}
