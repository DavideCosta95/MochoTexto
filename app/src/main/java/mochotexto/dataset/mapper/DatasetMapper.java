package mochotexto.dataset.mapper;

import java.util.List;
import java.util.Map;

public interface DatasetMapper {
	String getName();
	String getStocksName();
	List<String> getSectors();
	String getCountry();
	Float getSharePriceUSD();
	// TODO: valuate to use LocalDate
	String getFoundedOn();
	List<String> getFounders();
	Integer getEmployeesCount();
	// TODO: consider reverting to single string
	String getCeo();
	String getHeadquartersLocation();
	String getTopCompetitor();
	String getTelephoneNumber();
	Map<String, Integer> getFollowersBySocial();
	List<String> getUrls();
	Long getMarketCapitalization2022USD();
	Long getRevenue2022USD();
}
