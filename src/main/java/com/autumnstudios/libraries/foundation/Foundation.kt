package com.autumnstudios.libraries.foundation

import com.autumnstudios.libraries.foundation.api.commands.CommandEvent
import com.autumnstudios.libraries.foundation.api.commands.CommandRegister
import com.autumnstudios.libraries.foundation.modules.Module
import org.bukkit.plugin.java.JavaPlugin

class Foundation : JavaPlugin() {
    override fun onEnable() {

        saveDefaultConfig()

        if (!config.getBoolean("only-api")) {
            register()
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun register() {
        val modules = mutableListOf<Module>()
        val register: CommandRegister = CommandRegister()
        server.pluginManager.registerEvents(CommandEvent(register), this)
        ModuleRegister.registerModules(this, modules, register)
    }
}
