package com.autumnstudios.libraries.foundation.api.commands

class CommandInfo(label: String, permission: String) {

    public val label: String;
    public val permission: String;
    public val cls: String;

    init {
        this.label = label
        this.permission = permission
        this.cls = "";
    }
}