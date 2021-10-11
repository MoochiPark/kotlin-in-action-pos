package dev.playgroud.repository

class Inventory(
    private val stockList: HashMap<Int, Int> = hashMapOf(
        1 to 100,
        2 to 13,
        3 to 14
    ),
) {
    fun existByBarcodeNumber(barcodeNumber: Int): Boolean = this.stockList.containsKey(barcodeNumber)

    fun saleUpdate(barcodeNumbers: List<Int>) {
        barcodeNumbers.forEach {
            val stock = this.stockList[it]
            if (stock != null) {
                stockUpdate(it, stock.dec())
            }
        }
    }

    private fun stockUpdate(barcodeNumber: Int, stock: Int): Int? =
        this.stockList.put(barcodeNumber, stock)

    fun getAll() = this.stockList
}