package io.github.xjrga.snack.other;

public enum Nutrient {
	carbohydrates_carbs_by_diff("205", "Carbohydrates, By Difference (g)", "carbohydrates_carbs_by_diff"),
	carbohydrates_fiber_insoluble("10018", "Carbohydrates, Fiber, Insoluble (g)", "carbohydrates_fiber_insoluble"),
	carbohydrates_fiber_soluble("10017", "Carbohydrates, Fiber, Soluble (g)", "carbohydrates_fiber_soluble"),
	carbohydrates_fiber("291", "Carbohydrates, Fiber (g)", "carbohydrates_fiber"),
	carbohydrates_fructose("212", "Carbohydrates, Fructose (g)", "carbohydrates_fructose"),
	carbohydrates_glucose("211", "Carbohydrates, Glucose (g)", "carbohydrates_glucose"),
	carbohydrates_glycemic_load("10006", "Carbohydrates, Glycemic Load (g)", "carbohydrates_glycemic_load"),
	carbohydrates_lactose("213", "Carbohydrates, Lactose (g)", "carbohydrates_lactose"),
	carbohydrates_starch("209", "Carbohydrates, Starch (g)", "carbohydrates_starch"),
	carbohydrates_sucrose("210", "Carbohydrates, Sucrose (g)", "carbohydrates_sucrose"),
	carbohydrates_sugars("269", "Carbohydrates, Sugars (g)", "carbohydrates_sugars"),
	energy_gross("208", "Energy, Gross (kcal)", "energy_gross"),
	fats_cholesterol("601", "Fats, Cholesterol (mg)", "fats_cholesterol"),
	fats_dha("621", "Fats, Docosahexaenoic Acid, DHA, 22:6 n-3 (g)", "fats_dha"),
	fats_epa("629", "Fats, Eicosapentaenoic Acid, EPA, 20:5 n-3 (g)", "fats_epa"),
	fats_lauric("611", "Fats, Lauric Acid, 12:0 (g)", "fats_lauric"),
	fats_linoleic("618", "Fats, Linoleic Acid, LA, 18:2 n-6 (g)", "fats_linoleic"),
	fats_linolenic("619", "Fats, Linolenic Acid, ALA, 18:3 n-3 (g)", "fats_linolenic"),
	fats_monounsaturated("645", "Fats, Monounsaturated Fat, MUFA (g)", "fats_monounsaturated"),
	fats_myristic("612", "Fats, Myristic Acid, 14:0 (g)", "fats_myristic"),
	fats_palmitic("613", "Fats, Palmitic Acid, 16:0 (g)", "fats_palmitic"),
	fats_polyunsaturated("646", "Fats, Polyunsaturated Fat, PUFA (g)", "fats_polyunsaturated"),
	fats_saturated("606", "Fats, Saturated Fat, SFA (g)", "fats_saturated"),
	fats_stearic("614", "Fats, Stearic Acid, 18:0 (g)", "fats_stearic"),
	fats_total("204", "Fats, Total Fat (g)", "fats_total"),
	minerals_calcium("301", "Minerals, Calcium (mg)", "minerals_calcium"),
	minerals_copper("312", "Minerals, Copper (mg)", "minerals_copper"),
	minerals_iron("303", "Minerals, Iron (mg)", "minerals_iron"),
	minerals_magnesium("304", "Minerals, Magnesium (mg)", "minerals_magnesium"),
	minerals_manganese("315", "Minerals, Manganese (mg)", "minerals_manganese"),
	minerals_phosphorus("305", "Minerals, Phosphorus (mg)", "minerals_phosphorus"),
	minerals_potassium("306", "Minerals, Potassium (mg)", "minerals_potassium"),
	minerals_selenium("317", "Minerals, Selenium (mcg)", "minerals_selenium"),
	minerals_sodium("307", "Minerals, Sodium (mg)", "minerals_sodium"),
	minerals_zinc("309", "Minerals, Zinc (mg)", "minerals_zinc"),
	other_alcohol("221", "Other, Alcohol (g)", "other_alcohol"),
	other_cost("10005", "Other, Cost ($)", "other_cost"),
	other_water("255", "Other, Water (g)", "other_water"),
	other_weight("10000", "Other, Weight (g)", "other_weight"),
	phytonutrients_anthocyanins("10024", "Phytonutrients, Anthocyanins (mg)", "phytonutrients_anthocyanins"),
	phytonutrients_caffeine("262", "Phytonutrients, Caffeine (mg)", "phytonutrients_caffeine"),
	phytonutrients_beta_carotene("321", "Phytonutrients, Carotene, Beta (mcg)", "phytonutrients_beta_carotene"),
	phytonutrients_carotenoids("10019", "Phytonutrients, Carotenoids (mcg)", "phytonutrients_carotenoids"),
	phytonutrients_flavanols("10022", "Phytonutrients, Flavanols (mg)", "phytonutrients_flavanols"),
	phytonutrients_flavanones("10023", "Phytonutrients, Flavanones (mg)", "phytonutrients_flavanones"),
	phytonutrients_flavones("10021", "Phytonutrients, Flavones (mg)", "phytonutrients_flavones"),
	phytonutrients_flavonoids("10026", "Phytonutrients, Flavonoids (mg)", "phytonutrients_flavonoids"),
	phytonutrients_flavonols("10020", "Phytonutrients, Flavonols (mg)", "phytonutrients_flavonols"),
	phytonutrients_isoflavones("10025", "Phytonutrients, Isoflavones (mg)", "phytonutrients_isoflavones"),
	phytonutrients_lutein_zeaxanthin("338", "Phytonutrients, Lutein + Zeaxanthin (mcg)",
			"phytonutrients_lutein_zeaxanthin"),
	phytonutrients_lycopene("337", "Phytonutrients, Lycopene (mcg)", "phytonutrients_lycopene"),
	phytonutrients_phytosterols("636", "Phytonutrients, Phytosterols (mg)", "phytonutrients_phytosterols"),
	phytonutrients_theobromine("263", "Phytonutrients, Theobromine (mg)", "phytonutrients_theobromine"),
	protein_complete("10001", "Protein, Complete Protein (g)", "protein_complete"),
	protein_total("203", "Protein, Total Protein (g)", "protein_total"),
	vitamins_vitamin_a("320", "Vitamins, A, RAE (mcg)", "vitamins_vitamin_a"),
	vitamins_vitamin_b12("418", "Vitamins, B12 (mcg)", "vitamins_vitamin_b12"),
	vitamins_vitamin_b6("415", "Vitamins, B6 (mg)", "vitamins_vitamin_b6"),
	vitamins_vitamin_c("401", "Vitamins, C (mg)", "vitamins_vitamin_c"),
	vitamins_choline("421", "Vitamins, Choline (mg)", "vitamins_choline"),
	vitamins_vitamin_d("328", "Vitamins, D (mcg)", "vitamins_vitamin_d"),
	vitamins_vitamin_e("323", "Vitamins, E (mg)", "vitamins_vitamin_e"),
	vitamins_folate("435", "Vitamins, Folate, DFE (mcg)", "vitamins_folate"),
	vitamins_vitamin_k("430", "Vitamins, K (mcg)", "vitamins_vitamin_k"),
	vitamins_niacin("406", "Vitamins, Niacin (mg)", "vitamins_niacin"),
	vitamins_pantothenic_acid("410", "Vitamins, Pantothenic Acid (mg)", "vitamins_pantothenic_acid"),
	vitamins_riboflavin("405", "Vitamins, Riboflavin (mg)", "vitamins_riboflavin"),
	vitamins_thiamin("404", "Vitamins, Thiamin (mg)", "vitamins_thiamin"),
	carbohydrates_digestible("10003", "Carbohydrates, Digestible (g)", "carbohydrates_digestible"),
	energy_carbohydrate("10011", "Energy, Carbohydrate (kcal)", "energy_carbohydrate"),
	energy_fat("10013", "Energy, Fat (kcal)", "energy_fat"),
	energy_fat_and_carbohydrate("10010", "Energy, Fat and Carbohydrate (kcal)", "energy_fat_and_carbohydrate"),
	energy_protein("10012", "Energy, Protein (kcal)", "energy_protein"),
	energy_alcohol("10014", "Energy, Alcohol (kcal)", "energy_alcohol"),
	energy_digestible("10009", "Energy, Digestible (kcal)", "energy_digestible"),
	fats_hcsfa("10015", "Fats, Hypercholesterolemic Fat (g)", "fats_hcsfa"),
	fats_lcn3pufa("10016", "Fats, Long Chain n-3 PUFA (g)", "fats_lcn3pufa");

	private final String Label;
	private final String Name;
	private final String Number;

	Nutrient( String number, String name, String label ) {

		Number = number;
		Name = name;
		Label = label;

	}

	public String getLabel() {

		return Label;

	}

	public String getName() {

		return Name;

	}

	public String getNumber() {

		return Number;

	}
}
