package com.github.kotlivetka.testplugin

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Sheep
import org.bukkit.entity.Zombie
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
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
    @EventHandler
    fun onObject(event: BlockBreakEvent) {
       val entity= event.player.world.spawnEntity(event.block.location,EntityType.ZOMBIE)

        entity as Zombie
        entity.equipment.boots=ItemStack(Material.GOLDEN_BOOTS)
        entity.equipment.leggings=ItemStack(Material.GOLDEN_LEGGINGS)
        entity.equipment.chestplate=ItemStack(Material.GOLDEN_CHESTPLATE)
        entity.equipment.helmet=ItemStack(Material.GOLDEN_HELMET)
        entity.customName(Component.text("seva", NamedTextColor.DARK_PURPLE))
        entity.isCustomNameVisible=true
    }

}