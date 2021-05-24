package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        //throw NotImplementedError("Not implemented")
        var arrNum = IntArray(sadArray.size){sadArray[it]}

        while (true) {
            val newArr = arrFinderBadElem(arrNum)
            if  (newArr.size == arrNum.size) {
                return arrNum
                break
            } else {
                arrNum = IntArray(newArr.size){newArr[it]}
            }
        }

    }

    fun arrFinderBadElem(analisArray: IntArray): IntArray {
        val numbers = analisArray.toMutableList()

        var index = 1
        while (index < analisArray.size - 1) {
            if ((analisArray[index - 1] + analisArray[index + 1]) < analisArray[index]) {
                numbers.remove(analisArray[index])
            }
            index++
        }
        return numbers.toIntArray()
    }

}
