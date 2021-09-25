package brianmedina.advancedwelcome;

import brianmedina.advancedwelcome.listener.JoinListener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class Main extends PluginBase {

    @Override
    public void onEnable(){
        getDataFolder().mkdir();
        Config config = new Config(getDataFolder() + "/config.yml", Config.YAML);
        if(!config.exists("type")){
            String[] lines = new String[3];
            lines[0] = "§l§3Welcome to your server";
            lines[1] = "§3website§c: §4https://twitter.com/TheDevBrian";
            lines[2] = "line 3, you can add more lines";
            config.set("#type examples", "message title");
            config.set("type", "message");
            config.set("message", lines);
            config.set("title", "§l§3Welcome to your server");
            config.set("subtitle", "§3website§c: §4https://twitter.com/DevBrianMedina");
            config.save();
        }
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getLogger().info("§a--- -- ENABLED -- ---");
        getLogger().info("§a   --- TWITTER ---");
        getLogger().info("   §b@§aDevBrianMedina");
        getLogger().info("§bhttps://twitter.com/DevBrianMedina");
    }
}
