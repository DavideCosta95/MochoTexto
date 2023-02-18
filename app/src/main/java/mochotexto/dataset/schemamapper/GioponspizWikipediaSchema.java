package mochotexto.dataset.schemamapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.DatasetMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
public class GioponspizWikipediaSchema implements DatasetMapper {

	@JsonProperty("Name")
	private String _name;

	@JsonProperty("Industry")
	private String _industry;

	@JsonProperty("Sector")
	private String _sector;

	@JsonProperty("Headquarters")
	private String _headquarters;

	@JsonProperty("Founded")
	private String _founded;


	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getStocksName() {
		return null;
	}

	@Override
	public List<String> getSectors() {
		List<String> sectors = new ArrayList<>();
		if (_industry != null && !_industry.isBlank()) {
			sectors.add(_industry);
		}
		if (_sector != null && !_sector.isBlank()) {
			sectors.add(_sector);
		}
		return sectors;
	}

	@Override
	public String getCountry() {
		return null;
	}

	@Override
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	public String getFoundedOn() {
		return _founded;
	}

	@Override
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	@Override
	public Integer getEmployeesCount() {
		return null;
	}

	@Override
	public List<String> getCeo() {
		return Collections.emptyList();
	}

	@Override
	public String getHeadquartersLocation() {
		return _headquarters;
	}

	@Override
	public String getTopCompetitor() {
		return null;
	}

	@Override
	public String getTelephoneNumber() {
		return null;
	}

	@Override
	public Map<String, Integer> getFollowersBySocial() {
		return Collections.emptyMap();
	}

	@Override
	public List<String> getUrls() {
		return Collections.emptyList();
	}

	@Override
	public Long getMarketCapitalization2022USD() {
		return null;
	}

	@Override
	public Long getRevenue2022USD() {
		return null;
	}
}
