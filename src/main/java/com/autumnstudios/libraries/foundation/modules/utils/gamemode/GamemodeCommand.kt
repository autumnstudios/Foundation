package com.autumnstudios.libraries.foundation.modules.utils.gamemode

import com.autumnstudios.libraries.foundation.api.EChat
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerChatTabCompleteEvent

class GamemodeCommand : com.autumnstudios.libraries.foundation.api.commands.Command("", "") {

    override fun onCommand(sender: CommandSender, args: List<String>): Boolean {
        if (sender !is Player) {
            EChat.genSend("&c&lMUST BE PLAYER", sender)
            return false
        }

        val player : Player = sender
        if (args.size != 1) {
            EChat.genSend("&b/gm &fc/s/a/sp/creative/survival/adventure/spectator", player)
            return true
        }
        var result = "bad"
        when (args[0]) {
            "c" -> {
                player.gameMode = GameMode.CREATIVE
                result = "creative"
            }
            "s" -> {

                player.gameMode = GameMode.SURVIVAL
                result = "survival"
            }
            "a" -> {
                player.gameMode = GameMode.ADVENTURE
                result = "adventure"
            }
            "sp" -> {
                player.gameMode = GameMode.SPECTATOR
                result = "spectator"
            }

            "creative" -> {
                player.gameMode = GameMode.CREATIVE
                result = "creative"
            }
            "survival" -> {
                player.gameMode = GameMode.SURVIVAL
                result = "survival"
            }
            "adventure" -> {
                player.gameMode = GameMode.ADVENTURE
                result = "adventure"
            }
            "spectator" -> {
                player.gameMode = GameMode.SPECTATOR
                result = "spectator"
            }
            else -> {
                EChat.genSend("&b/gm &fc/s/a/sp/creative/survival/adventure/spectator", player)
                return true
            }
        }
        EChat.genSend("&bSet gamemode to &f$result", player)
        return true
    }

    override fun onTabComplete(sender: CommandSender, e: PlayerChatTabCompleteEvent): List<String>? {
        return listOf("creative", "survival", "spectator", "adventure")
    }
}