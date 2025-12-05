package io.github.iidogninjx1.fakejoin;

import org.bukkit.plugin.java.JavaPlugin;

public class FakeJoinPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command executors and tab completers
        if (this.getCommand("fakejoin") != null) {
            FakeJoinCommand joinExecutor = new FakeJoinCommand(this);
            this.getCommand("fakejoin").setExecutor(joinExecutor);
            this.getCommand("fakejoin").setTabCompleter(joinExecutor);
        }

        if (this.getCommand("fakeleave") != null) {
            FakeLeaveCommand leaveExecutor = new FakeLeaveCommand(this);
            this.getCommand("fakeleave").setExecutor(leaveExecutor);
            this.getCommand("fakeleave").setTabCompleter(leaveExecutor);
        }

        this.getLogger().info("FakeJoin enabled");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("FakeJoin disabled");
    }
}
