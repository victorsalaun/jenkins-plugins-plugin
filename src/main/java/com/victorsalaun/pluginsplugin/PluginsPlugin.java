package com.victorsalaun.pluginsplugin;

import hudson.Extension;
import hudson.PluginWrapper;
import hudson.model.UnprotectedRootAction;
import jenkins.model.Jenkins;
import org.jenkinsci.plugins.workflow.libs.GlobalLibraries;
import org.jenkinsci.plugins.workflow.libs.LibraryConfiguration;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return Jenkins.getActiveInstance().getPluginManager().getPlugins().stream().sorted(Comparator.comparing(PluginWrapper::getDisplayName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
    }

    public List<LibraryConfiguration> getSharedLibrariesList() {
        return GlobalLibraries.get().getLibraries().stream().sorted(Comparator.comparing(LibraryConfiguration::getName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
    }

}
