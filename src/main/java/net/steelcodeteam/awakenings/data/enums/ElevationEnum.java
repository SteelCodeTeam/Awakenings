package net.steelcodeteam.awakenings.data.enums;

import net.steelcodeteam.awakenings.modules.error_handling.error_utils.PlayerException;
import net.steelcodeteam.awakenings.modules.error_handling.exceptions.ErrorTypes;

import java.util.Arrays;
import java.util.Optional;

public enum ElevationEnum {

    LIFELESS("none", 0, 0),
    WITHOUT_ELEVATION("without", 1, 49),
    FIRST("first", 50, 199),
    SECOND("second", 200, 599),
    THIRD("third", 600, 999),
    FOUR("four", 1000, 1999),
    FIFTH("fifth", 2000,3499),
    SIX("six", 3500, 4999),
    SEVEN("seven", 5000, 9999),
    EIGHT("eight", 10000, 19999),
    NINE("nine", 20000, 49999),
    TEN("ten", 50000, Integer.MAX_VALUE);


    private final String name;
    private final Integer minBreaths;
    private final Integer maxBreaths;

    ElevationEnum(String name, Integer minBreaths, Integer maxBreaths) {
        this.name = name;
        this.minBreaths = minBreaths;
        this.maxBreaths = maxBreaths;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMinBreaths() {
        return this.minBreaths;
    }

    public Integer getMaxBreaths() {
        return this.maxBreaths;
    }

    public static ElevationEnum getElevation(Integer qtyBreaths) throws PlayerException {
        Optional<ElevationEnum> elevationOpt =  Arrays.asList(ElevationEnum.values()).stream()
                .filter(elevation -> elevation.getMaxBreaths() <= qtyBreaths && elevation.getMinBreaths() > qtyBreaths)
                .findFirst();

        if (elevationOpt.isPresent()) {
            return elevationOpt.get();
        } else {
            throw new PlayerException(ErrorTypes.ELEVATION_INDETERMINATE);
        }
    }
}
