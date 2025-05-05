package team.steelcode.awakenings.data;

public enum I18nEnum {
    ALUMINUM_BLOCK("block.awakenings.aluminum_block", "Bloque de aluminio", "Block of Aluminum"),
    ALUMINUM_ORE("block.awakenings.aluminum_ore", "Mena de aluminio", "Aluminum Ore"),

    ALUMINUM_INGOT("item.awakenings.aluminum_ingot", "Lingote de aluminio", "Aluminum Ingot"),
    ALUMINUM_NUGGET("item.awakenings.aluminum_nugget", "Pepita de aluminio", "Aluminum Nugget"),
    ALUMINUM_RAW("item.awakenings.aluminum_raw", "Aluminio crudo", "Aluminum Raw"),

    CREATIVE_TAB("tab.awakenings.default", "Awakenings", "Awakenings"),
    BREATHS("attribute.name.breaths", "Breaths", "Alientos"),

    NETHERITE_PLATE("item.awakenings.netherite_plate", "Placa de Netherita", "Netherite Plate"),
    ALUMINUM_PLATE("item.awakenings.aluminum_plate", "Placa de Aluminio", "Aluminum Plate"),
    NIGHTBLOOD("item.awakenings.nightblood", "Sangre Nocturna", "Nightblood"),
    NIGHTBLOOD_SHEATHED("item.awakenings.nightblood_sheathed", "Sangre Nocturna (Enfundada)", "Nightblood (Sheathed)"),
    SWORD_SHEATH("item.awakenings.sword_sheath", "Funda de espada", "Sword sheath"),

    MSG_NIGHTBLOOD("msg.awakenings.nightblood_says", "[Sangre Nocturna] ", "[NightBlood] "),
    MSG_NIGHTBLOOD_NOT_FOUND("msg.awakenings.nightblood_sheath_not_found", "Error 404: Funda no encontrada", "404 Error: Sheath Not Found")
    ;


    private final String key;
    private final String spanish;
    private final String english;

    I18nEnum(String key, String spanish, String english) {
        this.key = key;
        this.spanish = spanish;
        this.english = english;
    }

    public String getKey() {
        return key;
    }

    public String getSpanish() {
        return spanish;
    }

    public String getEnglish() {
        return english;
    }
}
