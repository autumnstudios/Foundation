package com.autumnstudios.libraries.foundation.api.commands

import org.bukkit.command.CommandSender
import org.bukkit.event.player.PlayerChatTabCompleteEvent

abstract class Command(label: String, permission: String) {

    public val label: String;
    public val permission: String

    init {
        this.label = label;
        this.permission = permission
    }

    abstract fun onCommand(sender: CommandSender, args: List<String>) : Boolean

    abstract fun onTabComplete(sender: CommandSender, e: PlayerChatTabCompleteEvent) : List<String>?

}
