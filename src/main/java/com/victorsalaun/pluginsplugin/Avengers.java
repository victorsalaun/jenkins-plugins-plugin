package com.victorsalaun.pluginsplugin;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class Avengers extends AbstractDescribableImpl<Avengers> {

    private static final Logger LOGGER = Logger.getLogger(Avengers.class.getName());

    private String templateSystemMessage;

    @DataBoundConstructor
    public Avengers(String templateSystemMessage) {
        this.templateSystemMessage = templateSystemMessage;
    }

    public String getTemplateSystemMessage() {
        return templateSystemMessage;
    }

    @DataBoundSetter
    public void setTemplateSystemMessage(String templateSystemMessage) {
        this.templateSystemMessage = templateSystemMessage;
    }

    @Extension
    @Symbol("avengers")
    public static class DescriptorImpl extends Descriptor<Avengers> {

        @GuardedBy("this")
        private String templateSystemMessage;

        public DescriptorImpl() {
            super();
            load();
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject json) {
            setTemplateSystemMessage(json.get("templateSystemMessage").toString());
            return true;
        }

        synchronized String getTemplateSystemMessage() {
            return templateSystemMessage;
        }

        synchronized void setTemplateSystemMessage(@Nonnull String templateSystemMessage) {
            this.templateSystemMessage = templateSystemMessage;
            save();
            try {
                Objects.requireNonNull(Objects.requireNonNull(Jenkins.getInstanceOrNull()).getPlugin(PluginImpl.class)).applyTemplateMessageSystem();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
