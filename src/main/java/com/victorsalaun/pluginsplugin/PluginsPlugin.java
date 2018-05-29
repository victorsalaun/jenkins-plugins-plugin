package com.victorsalaun.pluginsplugin;

import hudson.Extension;
import hudson.PluginWrapper;
import hudson.model.UnprotectedRootAction;
import jenkins.model.Jenkins;

import java.util.List;

@Extension
public class PluginsPlugin implements UnprotectedRootAction {

    private static final String URL_BASE = "pluginsplugin";

    @Override
    public String getIconFileName() {
        return "/plugin/plugins-plugin/icon.png";
    }

    @Override
    public String getDisplayName() {
        return "Plugins List";
    }

    @Override
    public String getUrlName() {
        return URL_BASE;
    }

    public List<PluginWrapper> getPluginsList() {
        return Jenkins.getActiveInstance().getPluginManager().getPlugins();
    }

}
