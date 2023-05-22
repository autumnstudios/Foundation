package com.autumnstudios.libraries.foundation.modules.utils.gamemode

import com.autumnstudios.libraries.foundation.api.commands.Command
import com.autumnstudios.libraries.foundation.api.commands.CommandRegister
import com.autumnstudios.libraries.foundation.modules.Module
import org.bukkit.plugin.java.JavaPlugin

class GamemodeModule : Module() {
    override fun getId(): String {
        return "gamemode"
    }

    override fun register(plugin: JavaPlugin, register: CommandRegister): Boolean {
        val commands: ArrayList<Command> = ArrayList<Command>()
        commands.add(GamemodeCommand())
        register.register("gm", plugin, commands)
        return true
    }
}