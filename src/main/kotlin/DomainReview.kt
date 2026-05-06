data class DomainReview(val signal: Int, val slack: Int, val drag: Int, val confidence: Int)

object DomainReviewLens {
    fun score(item: DomainReview): Int = item.signal * 2 + item.slack + item.confidence - item.drag * 3

    fun lane(item: DomainReview): String = when {
        score(item) >= 140 -> "ship"
        score(item) >= 105 -> "watch"
        else -> "hold"
    }
}
