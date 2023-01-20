import kotlin.math.pow

fun main() {
    println("Введіть двійковий код: ")
    val binaryCode: String = readln()
    println(binaryToDecimalNumber(binaryCode))

}

fun binaryToDecimalNumber(binaryCode: String): Double {
    val listBinaryCodes = wholeAndFractionCode(binaryCode)
    val wholeBinaryCode = listBinaryCodes.first()
    val fractionBinaryCode = listBinaryCodes.last()
    return resultConvertBinaryToDec(wholeBinaryCode, fractionBinaryCode)
}

fun wholeAndFractionCode(binaryCode: String): List<String> {
    var wholeBinaryCode = ""
    var fractionBinaryCode = ""
    var flag = 0
    for (i in binaryCode) {
        if (flag == 0 && i != ',' && i.digitToInt() in (0..1)) {
            wholeBinaryCode += i
        } else if (i == ',') {
            flag++
        } else if (i.digitToInt() in (0..1)) fractionBinaryCode += i
    }
    return listOf(wholeBinaryCode, fractionBinaryCode)
}

fun resultConvertBinaryToDec(wholeBinary: String, fractionBinary: String): Double {
    val powerWhole: Int = wholeBinary.length - 1
    val powerFraction: Int = fractionBinary.length
    var result = 0.0
    var flag = 0
    for (i in powerWhole downTo 0) {
        if (wholeBinary[flag] == '1') result += 2.0.pow(i.toDouble())
        flag++
    }
    flag = 0
    for (i in 1..powerFraction) {
        if (fractionBinary[flag] == '1') result += 2.0.pow(-i.toDouble())
        flag++
    }
    return result
}
