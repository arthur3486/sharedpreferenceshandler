package com.arthurivanets.sharedpreferenceshandler.model;

import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultBoolean;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultInt;
import com.arthurivanets.sharedpreferenceshandler.annotations.DefaultString;
import com.arthurivanets.sharedpreferenceshandler.annotations.Property;

public final class AppSettings {


    @DefaultInt(-1)
    @Property
    private int mainId;

    @DefaultInt(1)
    @Property
    private int openCount;

    @DefaultString("Hello!")
    @Property
    private String homeMessage;

    @DefaultString("Hi!")
    @Property
    private String greetingMessage;

    @DefaultBoolean(true)
    @Property
    private boolean isSoundEnabled;




    public AppSettings() {
        this.mainId = -1;
        this.openCount = 1;
        this.homeMessage = "Hello!";
        this.greetingMessage = "Hi!";
        this.isSoundEnabled = true;
    }




    public AppSettings setMainId(int mainId) {
        this.mainId = mainId;
        return this;
    }




    public int getMainId() {
        return this.mainId;
    }




    public AppSettings setOpenCount(int openCount) {
        this.openCount = openCount;
        return this;
    }




    public int getOpenCount() {
        return this.openCount;
    }




    public AppSettings setHomeMessage(String homeMessage) {
        this.homeMessage = homeMessage;
        return this;
    }




    public String getHomeMessage() {
        return this.homeMessage;
    }




    public AppSettings setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
        return this;
    }




    public String getGreetingMessage() {
        return this.greetingMessage;
    }




    public AppSettings setSoundEnabled(boolean isSoundEnabled) {
        this.isSoundEnabled = isSoundEnabled;
        return this;
    }




    public boolean isSoundEnabled() {
        return this.isSoundEnabled;
    }




    @Override
    public String toString() {
        return new StringBuilder()
            .append("AppSettings(mainId -> ").append(this.mainId)
            .append(", openCount -> ").append(this.openCount)
            .append(", homeMessage -> ").append(this.homeMessage)
            .append(", greetingMessage -> ").append(this.greetingMessage)
            .append(", isSoundEnabled -> ").append(this.isSoundEnabled)
            .append(")")
            .toString();
    }




}
