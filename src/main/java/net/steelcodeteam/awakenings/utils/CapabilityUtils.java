package net.steelcodeteam.awakenings.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.steelcodeteam.awakenings.data.player.IInvestedPlayerData;
import net.steelcodeteam.awakenings.modules.error_handling.error_utils.PlayerException;
import net.steelcodeteam.awakenings.modules.error_handling.exceptions.ErrorTypes;
import net.steelcodeteam.awakenings.setup.registries.DataTagRegister;


import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Collection of useful statics methods to manage our player capabilities.
 *
 * @author SteelCode Team
 * @since 1.5.1
 */
public class CapabilityUtils<T> {

    /**
     * Useful method to extract capabilities (data) from target ServerPlayer passed by parameter.
     *
     * @param player ServerPlayer from whom we are going to extract the capabilities.
     *
     * @return IInvestedPlayerData data extracted from target ServerPlayer
     *
     * @see IInvestedPlayerData
     */
    public static IInvestedPlayerData getCapability(@Nullable ServerPlayer player) throws PlayerException {


        if (player == null) {
            throw new PlayerException(ErrorTypes.PLAYER_ERROR);
        }

        // if player is present and has capabilities, we return capabilities, else, return null.
        if (player.getCapability(DataTagRegister.PLAYER_CAP).isPresent()) {
            return player.getCapability(DataTagRegister.PLAYER_CAP).orElseThrow(new PlayerException(ErrorTypes.PLAYER_CAPABILITY_ERROR));
        } else {
            throw new PlayerException(ErrorTypes.PLAYER_CAPABILITY_ERROR);
        }

    }

    /**
     * Useful method to extract capabilities (data) from target local Player passed by parameter.
     *
     * @param player local from whom we are going to extract the capabilities.
     *
     * @return IInvestedPlayerData data extracted from target Player.
     *
     * @see IInvestedPlayerData
     */
    public static IInvestedPlayerData getCapability(@Nullable Player player) throws PlayerException {
        if (player == null) {
            throw new PlayerException(ErrorTypes.PLAYER_ERROR);
        }

        if (player.getCapability(DataTagRegister.PLAYER_CAP).isPresent()) {
            return player.getCapability(DataTagRegister.PLAYER_CAP).orElseThrow(new PlayerException(ErrorTypes.PLAYER_CAPABILITY_ERROR));
        } else {
            throw new PlayerException(ErrorTypes.PLAYER_CAPABILITY_ERROR);
        }
    }

    public static IInvestedPlayerData getCapability(@Nullable Entity entity) throws PlayerException {

        if (entity == null) {
            throw new PlayerException(ErrorTypes.PLAYER_ERROR);
        }
        if (entity.getCapability(DataTagRegister.PLAYER_CAP).isPresent()) {
            return entity.getCapability(DataTagRegister.PLAYER_CAP).orElseThrow(new PlayerException(ErrorTypes.PLAYER_CAPABILITY_ERROR));
        } else {
            throw new PlayerException(ErrorTypes.PLAYER_CAPABILITY_ERROR);
        }
    }

}



