package com.victorsalaun.pluginsplugin;

import hudson.Extension;
import hudson.model.UnprotectedRootAction;

@Extension
public class PluginsPlugin implements UnprotectedRootAction {

    private static final String URL_BASE = "pluginsplugin";

    @Override
    public String getIconFileName() {
        return "/plugin/pluginsplugin/icon.png";
    }

    @Override
    public String getDisplayName() {
        return "Plugins List";
    }

    @Override
    public String getUrlName() {
        return URL_BASE;
    }

}
