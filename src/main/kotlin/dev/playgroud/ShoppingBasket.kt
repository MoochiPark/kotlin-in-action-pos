package dev.playgroud

class ShoppingBasket {
    private val shoppingList: ArrayList<Item> = arrayListOf()

    fun add(item: Item): Boolean =
        this.shoppingList.add(item)

    fun calculate(): Int =
        this.shoppingList.sumOf { it.price }

    fun barcodeNumbers(): List<Int> =
        this.shoppingList.map { it.barcodeNumber }
}