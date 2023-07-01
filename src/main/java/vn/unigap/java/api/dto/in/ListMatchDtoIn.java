package vn.unigap.java.api.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ListMatchDtoIn {
    @NotNull
    private Integer competitionId;
    @NotNull
    private Integer seasonId;
}
