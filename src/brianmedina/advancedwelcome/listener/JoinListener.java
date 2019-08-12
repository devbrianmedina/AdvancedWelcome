package brianmedina.advancedwelcome.listener;

import brianmedina.advancedwelcome.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.Config;

public class JoinListener implements Listener {

    private Main owner;

    public JoinListener(Main main){
        this.owner = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.setJoinMessage("");
        Player player = event.getPlayer();
        Config config = new Config(owner.getDataFolder() + "/config.yml", Config.YAML);
        if(config.getString("type").equals("message")){
            for(String line : config.getStringList("message")){
                player.sendMessage(line);
            }
        } else if(config.getString("type").equals("title")){
            player.sendTitle(config.getString("title"), config.getString("subtitle"));
        }
        player.getLevel().loadChunk(player.getChunkX(), player.getChunkZ());
    }
}
