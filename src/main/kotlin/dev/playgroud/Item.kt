package dev.playgroud

data class Item(
    val barcodeNumber: Int,
    val name: String,
    val price: Int,
) {
    override fun toString(): String {
        return "바코드: $barcodeNumber, 이름: '$name', 가격: $price"
    }
}