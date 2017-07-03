package it.raqb.spongepl.scst;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

import java.io.IOException;

/**
 * Created by Raqbit on 1-7-17.
 */
public class ConfigHelper {

    private ConfigurationLoader<CommentedConfigurationNode> configManager;
    public CommentedConfigurationNode rootNode;

    public ConfigHelper(ConfigurationLoader<CommentedConfigurationNode> _configManager){
        this.configManager = _configManager;
        try {
            this.rootNode = _configManager.load();
        } catch (IOException e) {
            SCST.INSTANCE.logger.error("Could not load config file, see stacktrace:");
            e.printStackTrace();
        }
    }

    public void saveConfig(){
        try {
            this.configManager.save(rootNode);
        } catch (IOException err) {
            SCST.INSTANCE.logger.error("Could not save config file, see stacktrace:");
            err.printStackTrace();
        }
    }
}