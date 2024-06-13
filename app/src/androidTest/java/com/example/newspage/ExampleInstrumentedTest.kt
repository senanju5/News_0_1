package com.example.newspage

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import kotlin.random.Random

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.newspage", appContext.packageName)
    }

    class LRUCache<K, V>(private val maxSize: Int) {

        private val cache by lazy { LinkedHashMap<K, V>(maxSize) }

        fun put(key: K, value: V) {
            cache.remove(key)
            if(cache.size == maxSize) {
                cache.remove( cache.keys.first())
            }
            cache[key] = value
        }

        fun get(key: K): V? {
            val value = cache[key]
            if (value != null) {
                put(key, value)
            }
            return value
        }

        fun print() {
            println(cache)
        }

    }
}



data class Deck(private val suits:String, private val values:String)

fun createDeck (): MutableList<Deck> {
    val card = mutableListOf<Deck>()
    val suits = listOf("Spades", "Hearts", "Diamonds", "Clubs")
    val values = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")

    for (suit in suits) {
        for (value in values) {
            card.add(Deck(suit, value))
        }
    }
    return card
}

fun shuffleDeck(deck: MutableList<Deck>){

    for (i in deck.indices.reversed()) {
        println(i)
    }

    for (i in deck.indices.reversed()) {
        val j = Random.nextInt(i + 1)
        val temp = deck[i]
        deck[i] = deck[j]
        deck[j] = temp
    }
}

fun  main () {
    val cache = ExampleInstrumentedTest.LRUCache<Int, Int>(3)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    cache.put(4, 4)
    cache.print()

    val deck = createDeck()
    shuffleDeck(deck)

}