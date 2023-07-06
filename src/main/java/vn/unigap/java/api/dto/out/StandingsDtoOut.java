package vn.unigap.java.api.dto.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandingsDtoOut {
	private Integer teamId;
	private String teamName;
	private Integer mp;
	private Integer w;
	private Integer d;
	private Integer l;
	private Integer gf;
	private Integer ga;
	private Integer gd;
	private Integer pts;
}
