package dev.playgroud

import kotlin.system.exitProcess

class MainProcess(
    private val inventory: Inventory = Inventory(),
) {
    fun run() {
        while (true) {
            println("1. 결제")
            println("2. 물품 등록")
            println("3. 재고 확인")
            println("4. 종료")
            print("선택해주세요 >> ")
            when (readLine()) {
                "1" -> PayProcess(inventory).run()
                "2" -> TODO("물품 등록")
                "3" -> inventory.printStocks()
                "4" -> exitProcess(0)
            }
        }
    }
}