package kr.skychipmunk.money.commands

import kr.heartpattern.spikot.command.Command
import kr.heartpattern.spikot.command.Root
import kr.heartpattern.spikot.command.dsl.Description
import kr.heartpattern.spikot.item.item
import kr.skychipmunk.money.util.*
import org.bukkit.Material
import org.bukkit.entity.Player

@Root
class MoneyGiveCommand : Command() {

    val moneys = listOf("§6브론즈 코인", "§7실버 코인", "§e골드 코인", "§d플레티넘 코인", "§b다이아몬드 코인")

    companion object : Description({
        name = setOf("코인얻기")
    })

    val player by sender().toPlayer().isOp("§b[§f Yundo Wolrd §b]§f 당신은 권한이 없습니다")
    val money by arg(0).notNull("§b[§f Yundo Wolrd §b]§f 인자를 제대로 입력해주세요").toInt().isMoney("§b[§f Yundo Wolrd §b]§f 코인 코드를 제대로 입력해주세요!")

    override fun execute() {
        if (player.inventory.firstEmpty() == -1) {
            player.sendMessage("§b[§f Yundo Wolrd §b]§f 인벤토리 칸이 부족합니다")
            return
        }else {
            player.inventory.addItem(item(Material.NETHER_STAR){ meta { displayName = moneys[money] }})
        }
    }
}