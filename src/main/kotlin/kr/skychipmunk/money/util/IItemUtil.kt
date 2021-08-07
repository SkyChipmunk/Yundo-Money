package kr.skychipmunk.money.util

import kr.heartpattern.spikot.item.item
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun Player.moneyChange(item: ItemStack, target: ItemStack, ra: Int, aa: Int) {
    if (ra <= getAmount(item)) {
        player.removeItem(item(Material.NETHER_STAR) { meta { displayName = item.itemMeta.displayName } }, ra)
        player.inventory.addItem(item(Material.NETHER_STAR) { amount = aa
            meta { displayName = target.itemMeta.displayName } })
        player.sendMessage("§b[§f Yundo Wolrd §b]§f 정상적으로 ${item.itemMeta.displayName} 코인 $ra 개를 ${target.itemMeta.displayName}§f 코인 $aa 개로 교환 하였습니다.")
        player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f)
        return
    }else {
        player.sendMessage("§b[§f Yundo Wolrd §b]§f ${item.itemMeta.displayName}§f 화페가 부족합니다")
        player.closeInventory()
        return
    }
}

fun Player.getAmount(itemStack: ItemStack): Int {
    return inventory.contents.filter { ChatColor.stripColor(it?.itemMeta?.displayName) == ChatColor.stripColor(itemStack.itemMeta.displayName) }
        .sumOf { it.amount }
}

fun Player.removeItem(itemStack: ItemStack, amount: Int) {
    var value = amount;
    inventory.contents.forEachIndexed { index, item ->
        if (item != null && item.itemMeta != null && item.itemMeta.displayName != null) {
            if (item.amount > value) {
                inventory.getItem(index).amount = inventory.getItem(index).amount - value
                return
            }
            if (item.amount == value) {
                inventory.setItem(index, item(Material.AIR))
                return
            }
            value -= item.amount
            inventory.setItem(index, item(Material.AIR))
        }
    }
}
