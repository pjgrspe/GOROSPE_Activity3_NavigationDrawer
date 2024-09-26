package ph.edu.auf.navigationdrawerlesson.helpers

import kotlin.random.Random

class QuotesGenerator private constructor(private val quotes: List<String>){
    private var lastIndex: Int? = null
    fun getRandomQuote(): String {
        var random: Int
        do {
            random = Random.nextInt(0, quotes.size)
        } while (random == lastIndex)
        lastIndex = random
        return quotes[random]
    }

    class QuoteBuilder{
        internal val quotes = mutableListOf<String>()
        fun build() = QuotesGenerator(quotes)
    }

    companion object {
        private val loveQuotes = listOf(
            "I love you.",
            "I love you more than yesterday.",
            "I love you more than I did yesterday.",
            "I love you more than I did yesterday and less than I will tomorrow.",
        )

        private val motivationalQuotes = listOf(
            "You are capable of amazing things.",
            "You are capable of more than you know.",
            "You are capable of more than you think.",
            "You are capable of more than you think you are.",
        )

        private val virgilAblohQuotes = listOf(
            "You can use your own story to change the narrative.",
            "I want to make a product that is based on an idea.",
            "The best way to predict the future is to create it."
        )

        private val basquiatQuotes = listOf(
            "I don't think about art when I'm working. I try to think about life.",
            "I am not a black artist, I am an artist.",
            "I cross out words so you will see them more; the fact that they are obscured makes you want to read them."
        )

        private val steveJobsQuotes = listOf(
            "Stay hungry, stay foolish.",
            "Your work is going to fill a large part of your life.",
            "Innovation distinguishes between a leader and a follower."
        )

        fun generateLoveQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(loveQuotes) }
        }

        fun generateVirgilAblohQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(virgilAblohQuotes) }
        }

        fun generateBasquiatQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(basquiatQuotes) }
        }

        fun generateSteveJobsQuotes(): QuoteBuilder {
            return QuoteBuilder().apply { quotes.addAll(steveJobsQuotes) }
        }

        fun generateAllQuotes(): QuoteBuilder {
            val allQuotes = mutableListOf<String>()
            allQuotes.addAll(loveQuotes)
            allQuotes.addAll(motivationalQuotes)
            allQuotes.addAll(virgilAblohQuotes)
            allQuotes.addAll(basquiatQuotes)
            allQuotes.addAll(steveJobsQuotes)
            return QuoteBuilder().apply { quotes.addAll(allQuotes) }
        }

    }

}