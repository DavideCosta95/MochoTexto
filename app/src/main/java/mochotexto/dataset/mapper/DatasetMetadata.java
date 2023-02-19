package mochotexto.dataset.mapper;

import lombok.Getter;
import mochotexto.dataset.schema.csv.*;
import mochotexto.dataset.schema.json.*;

public enum DatasetMetadata {
	// JSON datasets
	AVENGERS_HITHORIZONS("json/avengers-hithorizons.jsonl", AvengersHithorizonsSchema.class),
	DEBIGA_GLOBALDATA("json/DeBiGa-globaldata.com.json",DebigaGlobaldataSchema .class),
	DEBIGA_GOVUK("json/DeBiGa-gov.uk.json", DebigaGovukSchema.class),
	DEBIGA_WIKIPEDIA("json/DeBiGa-wikipedia.it.json", DebigaWikipediaSchema.class),
	GIOPONSPIZ_WIKIPEDIA("json/GioPonSpiz-wikipedia.org.json", GioponspizWikipediaSchema.class),
	AVENGERS_COMPANIESMARKETCAP("json/avengers-companiesmarketcap.jsonl", AvengersCompaniesmarketcapSchema.class),
	GIOPONSPIZ_COMPANIESMARKETCAP("json/GioPonSpiz-companiesmarketcap.com.json", GioponspizCompaniesmarketcapSchema.class),
	AVENGERS_DISFOLD("json/avengers-disfold.jsonl", AvengersDisfoldSchema.class),
	DEBIGA_DISFOLD("json/DeBiGa-disfold.com.json", DebigaDisfoldSchema.class),
	IGMM_DISFOLD("json/iGMM-disfold.com.json", IgmmDisfoldSchema.class),
	SLYTHERIN_DISFOLD("json/slytherin-disfold.com.json", SlytherinDisfoldSchema.class),
	SLYTHERIN_FORBES("json/slytherin-forbes.com.json", SlytherinForbesSchema.class),
	GREN_FT("json/gren-ft.com.json", GrenFtSchema.class),
	AVENGERS_VALUETODAY("json/avengers-value.today.jsonl", AvengersValuetodaySchema.class),
	GREN_VALUETODAY("json/gren-value.today.json", GrenValuetodaySchema.class),
	IGMM_VALUETODAY("json/iGMM-value.today.json", IgmmValuetodaySchema.class),
	SLYTHERIN_VALUETODAY("json/slytherin-value.today.json", SlytherinValuetodaySchema.class),
	// csv datasets
	DDD_TEAMBLIND("csv/DDD-teamblind.com.csv", DddTeamblindSchema.class),
	FR_COMPANYSOCIALURLS("csv/FR-company_social_urls.csv", FrCompanysocialurlsSchema.class),
	FR_FAMCAPGERMANY("csv/FR-famcap_germany.csv", FrFamcapgermanySchema.class),
	FR_FOLLOWERS("csv/FR-followers.csv", FrFollowersSchema.class),
	MARSCOTOC_AMBITIONBOX("csv/MarScoToc-ambitionbox.com.csv", MarscotocAmbitionboxSchema.class),
	MARSCOTOC_WIKIPEDIA("csv/MarScoToc-wikipedia.org.csv", MarscotocWikipediaSchema.class),
	WISSEL_AZIENDEINFOCLIPPER("csv/wissel-aziende-info-clipper.com.csv", WisselAziendeinfoclipperSchema.class),
	MALPATSAJ_WIKIPEDIA("csv/MalPatSaj-wikipedia.org.csv", MalpatsajWikipediaSchema.class),
	FR_DISFOLD("csv/FR-disfold.csv", FrDisfoldSchema.class),
	FR_FORBES("csv/FR-forbes.csv", FrForbesSchema.class),
	SILVESTRI_FORBES("csv/silvestri-forbes.com.csv", SilvestriForbesSchema.class),
	DDD_FT("csv/DDD-ft.com.csv", DddFtSchema.class),
	SILVESTRI_VALUETODAY("csv/silvestri-value.today.csv", SilvestriValuetodaySchema.class);


	@Getter
	private final String filePath;

	@Getter
	private final Class<? extends DatasetMapper> mapper;

	DatasetMetadata(String filePath, Class<? extends DatasetMapper> mapper) {
		this.filePath = filePath;
		this.mapper = mapper;
	}
}
