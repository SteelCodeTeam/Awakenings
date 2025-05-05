package team.steelcode.awakenings.data.generators;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.data.I18nEnum;

public class ModLanguageProviderEnglish extends LanguageProvider {

    public ModLanguageProviderEnglish(PackOutput output, String locale) {
        super(output, Awakenings.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        for (I18nEnum i18nEnum : I18nEnum.values()) {
            super.add(i18nEnum.getKey(), i18nEnum.getEnglish());
        }
    }
}
