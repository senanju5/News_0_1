package com.example.newspage

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    class LRUCache<K, V>(private val maxSize: Int) {

        private val cache = object : LinkedHashMap<K, V>(maxSize, 0.75f, true) {
            override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
                return size > maxSize
            }
        }

        @Synchronized
        fun get(key: K): V? {
            return cache[key]
        }

        @Synchronized
        fun put(key: K, value: V) {
            cache[key] = value
        }

        @Synchronized
        fun remove(key: K): V? {
            return cache.remove(key)
        }

        @Synchronized
        fun clear() {
            cache.clear()
        }

        @Synchronized
        fun size(): Int {
            return cache.size
        }

        @Synchronized
        fun isEmpty(): Boolean {
            return cache.isEmpty()
        }

        @Synchronized
        fun keys(): Set<K> {
            return cache.keys
        }

        @Synchronized
        fun values(): Collection<V> {
            return cache.values
        }
    }

//    class LRUCaches(private val capacity: Int) {
//
//        private val cache by lazy { LinkedHashMap<Int, Int>() }
//
//        fun get(key: Int): Int {
//            val value = cache[key] ?: -1
//
//            if (value != -1) {
//                // not present
//                put(key, value)
//            }
//
//            return value
//        }
//
//        fun put(key: Int, value: Int) {
//            cache.remove(key)
//
//            if (cache.size == capacity) {
//                cache.remove(cache.keys.first())
//            }
//
//            cache[key] = value
//        }
//
//    }

    class LruCaches <T, V>(private val capacity: Int) {

      private val lruCache by lazy { LinkedHashMap<T, V>() }

        fun put(key: T, value: V) {
            lruCache.remove(key)
            if(lruCache.size == capacity) {
                lruCache.remove(lruCache.keys.first())
            }

            lruCache[key] = value
        }

        fun get(key: T): V? {

            val value  = lruCache[key]

                if (value != null) {
                    put(key, value)
                }

            return value
        }

        fun print() {
            println(lruCache)
        }


    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * var obj = LRUCache(capacity)
     * var param_1 = obj.get(key)
     * obj.put(key,value)
     */


}

fun main() {
    val lruCache = ExampleUnitTest.LRUCache<String, String>(3)

//    lruCache.put("1", "one")
//    lruCache.put("2", "two")
//    lruCache.put("3", "three")
//    println(lruCache.keys()) // Output: [1, 2, 3]
//
//    lruCache.get("1")
//    lruCache.put("4", "four")
//    println(lruCache.keys()) // Output: [3, 1, 4]
//
//    lruCache.put("5", "five")
//    println(lruCache.keys()) // Output: [1, 4, 5]

//    val lruCaches = ExampleUnitTest.LRUCaches<>(3)
//     var param_1 = lruCaches.get(1)
//    lruCaches.put(1,1)
//
//    println("param 1 is $param_1")

    val lruCaches = ExampleUnitTest.LruCaches<Int, Int>(3)
    lruCaches.put(1,1)
    lruCaches.print()
    lruCaches.put(2,2)
    lruCaches.print()
    lruCaches.put(3,3)
    lruCaches.print()
    lruCaches.put(4,4)
    lruCaches.print()

}

