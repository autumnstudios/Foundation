package com.autumnstudios.libraries.foundation.modules

import com.autumnstudios.libraries.foundation.api.commands.CommandRegister
import org.bukkit.plugin.java.JavaPlugin

abstract class Module {

    abstract fun getId() : String

    abstract fun register(plugin: JavaPlugin, register: CommandRegister) : Boolean
}