package dev.playgroud.process

import dev.playgroud.Item
import dev.playgroud.repository.ItemRepository

class RegistrationItemProcess(
    private val itemRepository: ItemRepository,
) {
    fun run() {
        while (true) {
            print("상품의 바코드, 이름, 가격을 입력해주세요. (바코드 이름 가격 순) >> ")
            readLine()?.let {
                val (barcode, name, price) = it.split(" ")
                itemRepository.update(Item(barcode.toInt(), name, price.toInt()))
            } ?: println("잘못된 입력입니다.")
        }
    }
}