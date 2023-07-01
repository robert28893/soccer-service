package vn.unigap.java.api.dto.in;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ListSeasonDtoIn {
    @NotNull
    private Integer competitionId;
}
