package com.github.kotlivetka.testplugin

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

class TestPlugin : JavaPlugin(), Listener {

    override fun onEnable() {
        println("Плагин запущен")
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val textComponent = Component.text("Привет", NamedTextColor.GREEN)
        event.player.sendMessage(textComponent)
    }

    @EventHandler
    fun onJump(event: PlayerJumpEvent) {
        event.player.inventory.addItem(ItemStack(Material.DIAMOND))
    }
}