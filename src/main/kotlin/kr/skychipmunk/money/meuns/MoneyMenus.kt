package kr.skychipmunk.money.meuns

import kr.heartpattern.spikot.item.item
import kr.heartpattern.spikot.menu.MenuProvider
import kr.skychipmunk.money.util.moneyChange
import org.bukkit.Material
import org.bukkit.event.inventory.ClickType

class MoneyMenus : MenuProvider() {

    override fun onEnable() {
        update {
            title = "화폐 거래창"
            size = 27

            val moneys = listOf("§6브론즈 코인" , "§7실버 코인" , "§e골드 코인" , "§d플레티넘 코인" , "§b다이아몬드 코인")
            moneys.forEachIndexed { index, money ->
                slot(if (index > 4) moneys.size else 10 + index) {
                    display = item(Material.NETHER_STAR) {
                        meta {
                            displayName = money

                            lore {
                                if (index > 3) {
                                    +""
                                    +"최종 코인입니다."
                                    +"좌클릭시 ${if (index > 3) moneys[index - 1] else money} §f1개를 $money §f100개로 교환합니다."
                                    return@lore
                                }
                                +""
                                +"우클릭시 $money §f100개를 ${if (index > 3) money else moneys[index + 1]} §f1개로 교환합니다."
                                +"좌클릭시 ${if (index > 3) money else moneys[index + 1]} §f1개를 $money §f100개로 교환합니다."
                            }
                        }
                    }
                    handler {
                        when(type) {
                            ClickType.RIGHT -> {
                                if (index > 3) return@handler
                                player.moneyChange(item(Material.NETHER_STAR){ meta { displayName = money }}, item(Material.NETHER_STAR){ meta { displayName = if (index> 3) money else moneys[index + 1] }}, 100 , 1)
                            }
                            ClickType.LEFT -> {
                                if (index > 3) {
                                    player.moneyChange(item(Material.NETHER_STAR){ meta { displayName = moneys[index] }}, item(Material.NETHER_STAR){ meta { displayName = moneys[index - 1] }}, 1 , 100)
                                    return@handler
                                }
                                player.moneyChange(item(Material.NETHER_STAR){ meta { displayName = if (index > 3) money else moneys[index + 1] }}, item(Material.NETHER_STAR){ meta { displayName = money }}, 1 , 100)
                            }
                            else -> return@handler
                        }
                    }

                }
            }
            slot(0..8) {
                display = item(Material.STAINED_GLASS_PANE) {
                    durability = 7
                    meta {
                        displayName = ""
                    }
                }
            }

            slot(9) {
                display = item(Material.STAINED_GLASS_PANE)  {
                    durability = 7
                    meta {
                        displayName = ""
                    }
                }
            }

            slot(17) {
                display = item(Material.STAINED_GLASS_PANE) {
                    durability = 7
                    meta {
                        displayName = ""
                    }
                }
            }

            slot(18..26) {
                display = item(Material.STAINED_GLASS_PANE) {
                    durability = 7
                    meta {
                        displayName = ""
                    }
                }
            }
        }
    }
}