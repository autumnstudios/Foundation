package com.autumnstudios.libraries.foundation

import com.autumnstudios.libraries.foundation.api.commands.CommandRegister
import com.autumnstudios.libraries.foundation.modules.Module
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class ModuleRegister {

    companion object {
        fun registerModules(plugin: JavaPlugin, modules: List<Module>, register: CommandRegister) {
            Bukkit.getLogger().info("-----------------")
            Bukkit.getLogger().info("")
            Bukkit.getLogger().info("Registering modules")
            for (m in modules) {
                when (plugin.config.contains(m.getId())) {
                    true -> {
                        val enabled: Boolean = plugin.config.getBoolean(m.getId())
                        if (enabled) {
                            Bukkit.getLogger().info("ENABLING: ${m.getId()}:")
                            m.register(plugin, register)
                            Bukkit.getLogger().info("ENABLED: ${m.getId()}")
                            Bukkit.getLogger().info("")
                        } else {
                            Bukkit.getLogger().info("DISABLED: ${m.getId()}")
                        }
                    }
                    false -> {
                        Bukkit.getLogger().info("DISABLED: ${m.getId()}")
                    }
                }
            }
            Bukkit.getLogger().info("")
            Bukkit.getLogger().info("-----------------")
        }
    }
}