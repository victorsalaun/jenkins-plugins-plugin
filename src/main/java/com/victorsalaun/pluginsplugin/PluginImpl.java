package com.victorsalaun.pluginsplugin;

import hudson.Plugin;
import jenkins.model.Jenkins;

import java.io.IOException;
import java.util.Objects;

public class PluginImpl extends Plugin {

    private transient Avengers avengers;

    @Override
    public void start() throws Exception {
    }

    @Override
    public synchronized void postInitialize() throws Exception {
        applyTemplateMessageSystem();
    }

    synchronized void applyTemplateMessageSystem() throws IOException {
        Avengers.DescriptorImpl descriptor = Objects.requireNonNull(Jenkins.getInstanceOrNull()).getDescriptorByType(Avengers.DescriptorImpl.class);
        if (descriptor == null) {
            return;
        }
        Objects.requireNonNull(Jenkins.getInstanceOrNull()).setSystemMessage(descriptor.getTemplateSystemMessage());
    }

}
