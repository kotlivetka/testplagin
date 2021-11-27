package com.github.kotlivetka.testplugin

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.*
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



    var location1= Location(null, 0.0, 0.0, 0.0)
    var location2= Location(null, 0.0, 0.0, 0.0)
    var locationCount=0
    @EventHandler
    fun onObject(event: BlockBreakEvent) {
        val location= event.block.location
        var timer=5
        if(locationCount++ %2 ==1) {
            location1=location
        } else {
            location2=location
            val centerX= location1.x + (location2.x - location1.x)
            val centerY= location1.y + (location2.y - location1.y)
            val centerZ= location1.z + (location2.z - location1.z)
            val centerLocation= Location(location.world, centerX, centerY, centerZ)
        }
        var taskId=0
        taskId=
        server.scheduler.runTaskTimer(this, Runnable {
            val entity = event.player.world.spawnEntity(event.block.location, EntityType.ZOMBIE)
            entity as Zombie
            entity.equipment.boots = ItemStack(Material.NETHERITE_BOOTS)
            entity.equipment.leggings = ItemStack(Material.DIAMOND_LEGGINGS)
            entity.equipment.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
            entity.equipment.helmet = ItemStack(Material.NETHERITE_HELMET)
            entity.customName(Component.text("seva", NamedTextColor.DARK_PURPLE))
            entity.isCustomNameVisible = true
            timer--
            event.player.sendMessage(Component.text(timer))
            Bukkit.getScheduler().cancelTask(taskId)
        }, 0,20*5) .taskId


    }

}