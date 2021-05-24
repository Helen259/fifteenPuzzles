package com.example.fifteenpuzzles
import org.hamcrest.Matchers.arrayContainingInAnyOrder
import org.junit.Assert.assertThat
import org.junit.Test

class Test2  {
    @Test
    fun generateCorrect(){
        val generated  = Shuffling.shuffle()
        assertThat(generated, arrayContainingInAnyOrder(0,1,2,3,4,5,6,
            7,8,9,10,11,12,13,14,15))
        //arrayContainingInAnyOrder-создает матчер, который проверяет элементы массива,
        // порядок не имеет значения.
    }
}