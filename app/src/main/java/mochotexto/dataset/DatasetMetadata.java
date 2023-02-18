package mochotexto.dataset;

import lombok.Getter;
import mochotexto.dataset.schemamapper.*;

public enum DatasetMetadata {
	AVENGERS_HITHORIZONS("avengers-hithorizons.jsonl", AvengersHithorizonsSchema.class),
	DEBIGA_GLOBALDATA("DeBiGa-globaldata.com.json",DebigaGlobaldataSchema .class),
	DEBIGA_GOVUK("DeBiGa-gov.uk.json", DebigaGovukSchema.class),
	DEBIGA_WIKIPEDIA("DeBiGa-wikipedia.it.json", DebigaWikipediaSchema.class),
	GIOPONSPIZ_WIKIPEDIA("GioPonSpiz-wikipedia.org.json", GioponspizWikipediaSchema.class),
	AVENGERS_COMPANIESMARKETCAP("avengers-companiesmarketcap.jsonl", AvengersCompaniesmarketcapSchema.class),
	GIOPONSPIZ_COMPANIESMARKETCAP("GioPonSpiz-companiesmarketcap.com.json", GioponspizCompaniesmarketcapSchema.class),
	AVENGERS_DISFOLD("avengers-disfold.jsonl", AvengersDisfoldSchema.class),
	DEBIGA_DISFOLD("DeBiGa-disfold.com.json", DebigaDisfoldSchema.class),
	IGMM_DISFOLD("iGMM-disfold.com.json", IgmmDisfoldSchema.class),
	SLYTHERIN_DISFOLD("slytherin-disfold.com.json", SlytherinDisfoldSchema.class),
	SLYTHERIN_FORBES("slytherin-forbes.com.json", SlytherinForbesSchema.class),
	GREN_FT("gren-ft.com.json", GrenFtSchema.class),
	AVENGERS_VALUETODAY("avengers-value.today.jsonl", AvengersValuetodaySchema.class),
	GREN_VALUETODAY("gren-value.today.json", GrenValuetodaySchema.class),
	IGMM_VALUETODAY("iGMM-value.today.json", IgmmValuetodaySchema.class),
	SLYTHERIN_VALUETODAY("slytherin-value.today.json", SlytherinValuetodaySchema.class);

	@Getter
	private final String filePath;

	@Getter
	private final Class<? extends DatasetMapper> mapper;

	DatasetMetadata(String filePath, Class<? extends DatasetMapper> mapper) {
		this.filePath = filePath;
		this.mapper = mapper;
	}
}
