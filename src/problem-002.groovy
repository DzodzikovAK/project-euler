/**
 * Even Fibonacci numbers.
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 */

def sumEvenFibonacciNotGreaterThan = { max ->
    def addIfEven = { init, toAdd ->
        toAdd % 2 == 0 ? init + toAdd : init
    }

    def sum = { first, second, result ->
        if (second > max) {
            result
        } else {
            call second, first + second, addIfEven(result, second)
        }
    }.trampoline()

    sum.trampoline(1, 2, 0)()
}

// test
println sumEvenFibonacciNotGreaterThan(4000000)