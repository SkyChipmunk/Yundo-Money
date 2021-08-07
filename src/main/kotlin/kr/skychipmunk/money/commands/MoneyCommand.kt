package kr.skychipmunk.money.commands

import kr.heartpattern.spikot.command.Command
import kr.heartpattern.spikot.command.Root
import kr.heartpattern.spikot.command.dsl.Description
import kr.heartpattern.spikot.item.item
import kr.heartpattern.spikot.menu.openInventory
import kr.skychipmunk.money.meuns.MoneyMenus
import kr.skychipmunk.money.util.toPlayer
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player

@Root
class MoneyCommand : Command() {

    companion object : Description({
        name = setOf("코인교환", "화폐", "coin")
    })

    val player by sender().toPlayer()

    override fun execute() {
        player.openInventory(plugin, MoneyMenus())
        player.playSound(player.location, Sound.BLOCK_CHEST_OPEN, 1f, 1f)

    }
}