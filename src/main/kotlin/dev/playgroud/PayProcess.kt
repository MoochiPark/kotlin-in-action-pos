package dev.playgroud

import java.lang.NumberFormatException

class PayProcess(
    private val inventory: Inventory,
    private val itemRepository: ItemRepository = ItemRepository(),
    private val shoppingBasket: ShoppingBasket = ShoppingBasket(),
) {
    fun run() {
        while (true) {
            println("p. 결제하기")
            println("c. 이전으로")
            print("메뉴를 선택하거나 바코드를 찍어주세요 >> ")
            when (val input = readLine()) {
                "p" -> pay()
                "c" -> return
                else -> addItem(input)
            }
        }
    }

    private fun pay() {
        inventory.saleUpdate(shoppingBasket.barcodeNumbers())
        println("총 결제할 금액: ${shoppingBasket.calculate()}")
//        TODO("결제 방식에 따른 결제 진행")
    }

    private fun addItem(barcode: String?) {
        if (barcode != null) {
            val barcodeNumber: Int =
                try {
                    barcode.toInt()
                } catch (e: NumberFormatException) {
                    println("바코드 형식에 맞지 않습니다.")
                    return
                }
            val item = itemRepository.getByBarcodeNumber(barcodeNumber)

            if (item != null && inventory.existByBarcodeNumber(barcodeNumber)) {
                println("추가한 상품: $item")
                shoppingBasket.add(item)
            } else {
                println("등록되지 않거나 재고가 없는 상품입니다.")
            }

        } else {
            println("바코드가 제대로 입력되지 않았습니다.")
        }
    }
}