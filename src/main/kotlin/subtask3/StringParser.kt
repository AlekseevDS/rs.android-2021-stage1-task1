package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val returnSubStr = mutableListOf<String>()
        for ((index, element) in inputString.withIndex()) {

            when (element) {

                '<' -> returnSubStr.add(parserStr(inputString, '<','>',index))
                '(' -> returnSubStr.add(parserStr(inputString, '(',')',index))
                '[' -> returnSubStr.add(parserStr(inputString, '[',']',index))
            }
        }
        return returnSubStr.toTypedArray()
    }

    fun parserStr(inputStr: String, fstChar: Char,
                  lastChar: Char, index: Int): String {
        val startIndex = index + 1
        var endIndex = inputStr.indexOf(lastChar, startIndex)
        var subSrtr = inputStr.substring(startIndex, endIndex)

        while (subSrtr.count( { c: Char -> c == fstChar } ) !=
            subSrtr.count( { c: Char -> c == lastChar } )) {
            val newendIndex = inputStr.indexOf(lastChar, endIndex + 1)
            val newSubStr = inputStr.substring(endIndex, newendIndex)
            subSrtr = subSrtr.plus(newSubStr)
            endIndex = newendIndex
        }
        return subSrtr
    }
}
