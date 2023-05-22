package com.autumnstudios.libraries.foundation.api.commands

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatTabCompleteEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent

class CommandEvent(register: CommandRegister) : Listener {

    val register: CommandRegister
    init {
        this.register = register;
    }

    @EventHandler
    fun onCommand(e: PlayerCommandPreprocessEvent) {
        val cmd: List<String> = e.message.split(" ")
        val label: String = cmd[0]
        var args: List<String> = cmd.drop(0)
        if (register.getCommandFromLabel(label) != null) run {
            val command: Command = register.getCommandFromLabel(label)!!
            val info: CommandInfo? = register.getInfoFromCommand(command)
            if (info != null) {
                if (e.player.hasPermission(info.permission))
                    command.onCommand(e.player, args)
            }
        }

    }

    @EventHandler
    fun onTabComplete(e: PlayerChatTabCompleteEvent) {
        if (!e.chatMessage.startsWith("/"))  {
            return
        }
        val cmd: List<String> = e.chatMessage.split(" ")
        val label: String = cmd[0]
        var args: List<String> = cmd.drop(0)
        if (register.getCommandFromLabel(label) != null) run {
            val command: Command = register.getCommandFromLabel(label)!!
            val tabComplete: List<String> = command.onTabComplete(e.player, e)!!
            if (tabComplete != null) {
                command.onTabComplete(e.player, e)
            }

        }


    }
}