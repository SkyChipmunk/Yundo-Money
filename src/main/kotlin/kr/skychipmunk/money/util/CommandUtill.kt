package kr.skychipmunk.money.util

import kr.heartpattern.spikot.command.property.CommandProperty
import kr.heartpattern.spikot.command.property.TransformerContext
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

fun TransformerContext.failWithMessage(message: String): Nothing {
    sender.sendMessage(message)
    fail()
}

fun <T : Any> CommandProperty<T?>.notNull(errorMsg: String = "인자를 입력해주세요."): CommandProperty<T> {
    return this.transform {
        it ?: failWithMessage(errorMsg)
    }
}

fun <T : Any> CommandProperty<T>.toInt(): CommandProperty<Int> {
    return this.transform { it.toString().toInt() }
}

fun CommandProperty<Int>.isMoney(errorMsg: String = "검색하던 배열 4를 넘었습니다."): CommandProperty<Int> {
    return this.transform {
        if (it <= 4) it else failWithMessage(errorMsg)
    }
}

fun CommandProperty<CommandSender>.toPlayer(errorMsg: String = "당신은 플레이어가 아닙니다."): CommandProperty<Player> {
    return this.transform { it as? Player ?: failWithMessage(errorMsg)}
}

fun CommandProperty<Player>.isOp(errorMsg: String = "당신은 권한이 없습니다."): CommandProperty<Player> {
    return this.transform { if (it.isOp) it else failWithMessage(errorMsg)}
}