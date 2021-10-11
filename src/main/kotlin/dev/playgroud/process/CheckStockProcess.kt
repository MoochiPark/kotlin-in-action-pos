package dev.playgroud.process

import dev.playgroud.repository.Inventory
import dev.playgroud.repository.ItemRepository

class CheckStockProcess(
    private val inventory: Inventory,
    private val itemRepository: ItemRepository,
) {
    fun run() {
        inventory.getAll()
            .forEach { println("바코드: ${it.key}, 이름: ${itemRepository.getByBarcodeNumber(it.key)}, 수량: ${it.value}") }
    }
}