package kr.skychipmunk.money

import kr.heartpattern.spikot.SpikotPlugin
import org.bukkit.plugin.java.annotation.dependency.Dependency
import org.bukkit.plugin.java.annotation.plugin.Plugin

@Dependency(value = "Spikot")
@Plugin(name = "Yundo-Money", version = "1.0")
class Money : SpikotPlugin()