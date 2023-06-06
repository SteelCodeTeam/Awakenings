package net.steelcodeteam.awakenings.data.player;

import net.minecraft.nbt.CompoundTag;
import net.steelcodeteam.awakenings.data.enums.ElevationEnum;

public interface IInvestedPlayerData {
    Boolean hasAnyBreath();

    Integer getQtyBreaths();

    void setQtyBreaths(Integer qtyBreaths);

    void addQtyBreaths(Integer qtyBreaths);

    void removeQtyBreaths(Integer qtyBreaths);

    Boolean getFirstLogin();

    void setFirstLogin(Boolean firstLogin);

    ElevationEnum getElevation();

    CompoundTag save();

    void load(CompoundTag nbt);
}
