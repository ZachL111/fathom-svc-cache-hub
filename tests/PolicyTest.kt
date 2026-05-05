fun main() {
    val signalcase_1 = Signal(92, 103, 12, 15, 11)
    check(Policy.score(signalcase_1) == 228)
    check(Policy.classify(signalcase_1) == "accept")
    val signalcase_2 = Signal(96, 74, 14, 6, 7)
    check(Policy.score(signalcase_2) == 237)
    check(Policy.classify(signalcase_2) == "accept")
    val signalcase_3 = Signal(90, 78, 19, 15, 11)
    check(Policy.score(signalcase_3) == 185)
    check(Policy.classify(signalcase_3) == "accept")
}
