package mochotexto.dataset.schema.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.JsonDatasetMapper;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
public class DebigaGovukSchema implements JsonDatasetMapper {

	@JsonProperty("name")
	private String _name;

	@JsonProperty("company_number")
	private String _companyNumber;

	@JsonProperty("registered_office_address")
	private String _registeredOfficeAddress;

	@JsonProperty("company_status")
	private String _companyStatus;

	@JsonProperty("company_type")
	private String _companyType;

	@JsonProperty("company_creation_date")
	private String _companyCreationDate;

	@JsonProperty("nature_of_business")
	private String _natureOfBusiness;


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
		if (_natureOfBusiness == null) {
			return Collections.emptyList();
		}

		int startIndex = _natureOfBusiness.indexOf("-");
		if (startIndex < 0) {
			return List.of(_natureOfBusiness);
		}

		String extractedValue;
		try {
			extractedValue = _natureOfBusiness.substring(startIndex + 2);
		} catch (Exception e) {
			return Collections.emptyList();
		}

		if (extractedValue.trim().isEmpty()) {
			return Collections.emptyList();
		}
		return List.of(extractedValue);
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
		return _companyCreationDate;
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
		return _registeredOfficeAddress;
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
