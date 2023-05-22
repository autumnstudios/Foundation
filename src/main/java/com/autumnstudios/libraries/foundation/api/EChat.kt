package com.autumnstudios.libraries.foundation.api

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class EChat {

    companion object {
        fun gen(msg: String) : String {
            return ChatColor.translateAlternateColorCodes('&', msg)
        }

        fun genSend(msg: String, target: CommandSender) {
            target.sendMessage(gen(msg))
        }

        fun genSend(msg: String, target: Player) {
            target.sendMessage(gen(msg))
        }
    }
}