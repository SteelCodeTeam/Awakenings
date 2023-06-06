package net.steelcodeteam.awakenings.data.player;

import net.minecraft.nbt.CompoundTag;
import net.steelcodeteam.awakenings.data.enums.ElevationEnum;
import net.steelcodeteam.awakenings.modules.error_handling.error_utils.PlayerException;
import net.steelcodeteam.awakenings.modules.error_handling.messages.LoggerUtils;

public class InvestedPlayerData implements IInvestedPlayerData {

    private Integer qtyBreaths;
    private final String qtyBreathsName = "qtyBreaths";

    private Boolean firstLogin;
    private final String firstLoginName = "firstLoginName";


    public InvestedPlayerData() {
        qtyBreaths = 0;
        firstLogin = true;
    }

    @Override
    public Boolean hasAnyBreath() {
        return qtyBreaths > 0;
    }

    @Override
    public Integer getQtyBreaths() {
        return qtyBreaths;
    }

    @Override
    public void setQtyBreaths(Integer qtyBreaths) {
        this.qtyBreaths = qtyBreaths;
    }

    @Override
    public void addQtyBreaths(Integer qtyBreaths) {
        this.qtyBreaths = this.qtyBreaths + qtyBreaths;
    }

    @Override
    public void removeQtyBreaths(Integer qtyBreaths) {
        this.qtyBreaths = this.qtyBreaths - qtyBreaths;
    }

    @Override
    public Boolean getFirstLogin() {
        return firstLogin;
    }

    @Override
    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    @Override
    public ElevationEnum getElevation() {
        try {
            return ElevationEnum.getElevation(this.qtyBreaths);

        } catch (PlayerException ex) {
            LoggerUtils.printLogWarn(ex.getMessage());
            this.qtyBreaths = 0;
            return ElevationEnum.WITHOUT_ELEVATION;

        } catch (Exception ex) {
            ex.printStackTrace();
            this.qtyBreaths = 0;
            return ElevationEnum.WITHOUT_ELEVATION;
        }
    }

    @Override
    public CompoundTag save() {
        CompoundTag tag = new CompoundTag();

        tag.putInt(qtyBreathsName, qtyBreaths);
        tag.putBoolean(firstLoginName, firstLogin);

        return tag;
    }

    @Override
    public void load(CompoundTag nbt) {
        this.setQtyBreaths(nbt.getInt(qtyBreathsName));
        this.setFirstLogin(nbt.getBoolean(firstLoginName));
    }
}
