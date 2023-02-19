package mochotexto.dataset.schema.csv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.CsvDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
@JsonPropertyOrder({"_rank", "_company", "_revenues2018_$m","_employees","_family_ownership","_founded","_public_private","_generation","_family_executive","_woman_in_leadership","_sector","_headquarters","_state","_website"})
public class FrFamcapgermanySchema implements CsvDatasetMapper {
	private String _rank;
	private String _company;
	private String _revenues2018_$m;
	private String _employees;
	private String _family_ownership;
	private String _founded;
	private String _public_private;
	private String _generation;
	private String _family_executive;
	private String _woman_in_leadership;
	private String _sector;
	private String _headquarters;
	private String _state;
	private String _website;

	// TODO: add 2018 revenues


	@Override
	@JsonIgnore
	public String getName() {
		return _company;
	}

	@Override
	@JsonIgnore
	public String getStocksName() {
		return null;
	}

	@Override
	@JsonIgnore
	public List<String> getSectors() {
		return ParsingUtils.makeSanitizedStringList(_sector);
	}

	@Override
	@JsonIgnore
	public String getCountry() {
		return "Germany";
	}

	@Override
	@JsonIgnore
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getFoundedOn() {
		return _founded;
	}

	@Override
	@JsonIgnore
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public Integer getEmployeesCount() {
		return ParsingUtils.sanitizeInteger(_employees);
	}

	@Override
	@JsonIgnore
	public List<String> getCeo() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public String getHeadquartersLocation() {
		return _headquarters;
	}

	@Override
	@JsonIgnore
	public String getTopCompetitor() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getTelephoneNumber() {
		return null;
	}

	@Override
	@JsonIgnore
	public Map<String, Integer> getFollowersBySocial() {
		return Collections.emptyMap();
	}

	@Override
	@JsonIgnore
	public List<String> getUrls() {
		return ParsingUtils.makeSanitizedStringList(_website);
	}

	@Override
	@JsonIgnore
	public Long getMarketCapitalization2022USD() {
		return null;
	}

	@Override
	@JsonIgnore
	public Long getRevenue2022USD() {
		return null;
	}
}
