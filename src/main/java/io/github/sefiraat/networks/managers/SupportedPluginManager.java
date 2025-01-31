package io.github.sefiraat.networks.managers;

import com.google.common.base.Preconditions;
import com.molean.folia.adapter.Folia;
import io.github.sefiraat.networks.Networks;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SupportedPluginManager {

    private static SupportedPluginManager instance;

    private final boolean infinityExpansion;
    private final boolean netheopoiesis;
    private final boolean slimeHud;

    // region First Tick Only Registrations
    private boolean mcMMO;
    private boolean wildChests;

    // endregion

    public SupportedPluginManager() {
        Preconditions.checkArgument(instance == null, "Cannot instantiate class");
        instance = this;
        this.infinityExpansion = Bukkit.getPluginManager().isPluginEnabled("InfinityExpansion");
        this.netheopoiesis = Bukkit.getPluginManager().isPluginEnabled("Netheopoiesis");
        this.slimeHud = Bukkit.getPluginManager().isPluginEnabled("SlimeHUD");
        Folia.runAtFirstTick(Networks.getInstance(), this::firstTickRegistrations);
    }

    private void firstTickRegistrations() {
        this.wildChests = Bukkit.getPluginManager().isPluginEnabled("WildChests");
        this.mcMMO = Bukkit.getPluginManager().isPluginEnabled("mcMMO");
    }

    public boolean isInfinityExpansion() {
        return infinityExpansion;
    }

    public boolean isNetheopoiesis() {
        return netheopoiesis;
    }

    public boolean isSlimeHud() {
        return slimeHud;
    }

    public boolean isMcMMO() {
        return mcMMO;
    }

    public boolean isWildChests() {
        return wildChests;
    }

    public static SupportedPluginManager getInstance() {
        return instance;
    }
}
