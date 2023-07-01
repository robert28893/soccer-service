package vn.unigap.java.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchDtoOut {
    private Integer id;
    private Integer homeTeamId;
    private String homeTeamName;
    private Integer awayTeamId;
    private String awayTeamName;
    private Integer homeScore;
    private Integer awayScore;
    private String matchDate;
    private String kickOff;
}
