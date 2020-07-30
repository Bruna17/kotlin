// WITH_RUNTIME

/*
 * KOTLIN CODEGEN BOX SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 1.4-rfc+0.3-591
 * MAIN LINK: inheritance, overriding -> paragraph 8 -> sentence 1
 * NUMBER: 3
 * DESCRIPTION: hashCode(): return type of a child override function is not a subtype of return type of a base class
 * EXCEPTION: compiletime
 */

open class BaseCase1(val a: Int, val b: CharSequence)

open class ChildCase1 : BaseCase1(1, "") {
    override fun hashCode(): Any = 1 //(1)
}

fun box(): String {
    val childCase1 = ChildCase1()
    childCase1.hashCode() //resolves to (1)
    return "NOK"
}