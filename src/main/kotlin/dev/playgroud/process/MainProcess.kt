package dev.playgroud.process

import dev.playgroud.repository.Inventory
import dev.playgroud.repository.ItemRepository
import kotlin.system.exitProcess

class MainProcess(
    private val inventory: Inventory = Inventory(),
    private val itemRepository: ItemRepository = ItemRepository(),
) {
    fun run() {
        while (true) {
            println("1. 결제")
            println("2. 물품 등록")
            println("3. 재고 등록")
            println("4. 재고 확인")
            println("5. 종료")
            print("선택해주세요 >> ")
            when (readLine()) {
                "1" -> PayProcess(inventory, itemRepository).run()
                "2" -> RegistrationItemProcess(itemRepository).run()
                "3" -> TODO("재고 등록")
                "4" -> CheckStockProcess(inventory, itemRepository).run()
                "5" -> exitProcess(0)
            }
        }
    }
}