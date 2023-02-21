package mochotexto.dataset.schema.csv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.CsvDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
@JsonPropertyOrder({"_founded","_top_competitor","_employees","_ceo","_name"})
public class FrDisfoldSchema implements CsvDatasetMapper {
	private String _founded;
	private String _top_competitor;
	private String _employees;
	private String _ceo;
	private String _name;


	@Override
	@JsonIgnore
	public String getName() {
		return _name;
	}

	@Override
	@JsonIgnore
	public String getStocksName() {
		return null;
	}

	@Override
	@JsonIgnore
	public List<String> getSectors() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public String getCountry() {
		return null;
	}

	@Override
	@JsonIgnore
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getFoundedOn() {
		return _founded != null ?_founded.replace("Founded:", "").trim() : null;
	}

	@Override
	@JsonIgnore
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public Integer getEmployeesCount() {
		if (_employees == null) {
			return null;
		}
		return ParsingUtils.sanitizeInteger(_employees.replace("Employees:", "").trim());
	}

	@Override
	@JsonIgnore
	public String getCeo() {
		return _ceo != null ? _ceo.replace("CEO:", "").trim() : null;
	}

	@Override
	@JsonIgnore
	public String getHeadquartersLocation() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getTopCompetitor() {
		return _top_competitor;
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
		return Collections.emptyList();
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
