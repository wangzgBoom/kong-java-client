package com.github.vaibhavsinha.kong.api;

import com.github.vaibhavsinha.kong.model.plugin.EnabledPlugins;
import com.github.vaibhavsinha.kong.model.plugin.Plugin;
import com.github.vaibhavsinha.kong.model.plugin.PluginList;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
public interface PluginService {
    Plugin createPlugin(Plugin request);
    Plugin getPlugin(String nameOrId);
    Plugin updatePlugin(String nameOrId, Plugin request);
    Plugin createOrUpdatePlugin(Plugin request);
    Plugin deletePlugin(String usernameOrId);
    PluginList listPlugins(String id, String apiId, String consumerId, String name, Long size, String offset);
    EnabledPlugins listEnabledPlugins();
}