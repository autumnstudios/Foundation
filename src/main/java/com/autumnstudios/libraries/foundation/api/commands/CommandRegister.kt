package com.autumnstudios.libraries.foundation.api.commands

import org.bukkit.command.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin

class CommandRegister {

    val commands: MutableMap<CommandInfo, Command> = HashMap()

    fun register(cmd: String, plugin: JavaPlugin, commands: List<Command>) {
        for (c: Command in commands) run {
            var info: CommandInfo = CommandInfo(c.label, c.permission)
            addCommand(info, c)
        }
    }

    fun getCommandFromLabel(label: String): Command? {
        for ((key, v) in commands) {
            if (key.label.equals(label, true)) {
                return v;
            }
        }
        return null
    }

    fun addCommand(info: CommandInfo, cmd: Command) {
        commands.put(info, cmd)
    }

    fun getInfoFromCommand(cmd: Command) : CommandInfo? {
        for ((key, v) in commands) {
            if (v == cmd) {
                return key;
            }
        }
        return null
    }
}