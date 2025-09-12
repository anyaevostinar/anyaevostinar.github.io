class BankAccounts(var checking_balance,
                   var savings_balance) {

    // Deposits money into checking account
    fun depositChecking(amount: Double){
        /* YOUR CODE HERE */

    }

    // Deposits money into the savings account.
    fun depositSavings(amount: Double){
        /* YOUR CODE HERE */
     
    }

    // Transfers money from checking to savings
    fun transferFromCheckingToSavings(amount: Double){
        /* YOUR CODE HERE */
        
    }

    // Transfers money from savings to checking
    fun transferFromSavingsToChecking(amount: Double){
        /* YOUR CODE HERE */

    }

    // Gets the total amount stored in both accounts
    fun getTotalBalance(): Double{
        /* YOUR CODE HERE */
    }

}

fun main() {
    // Should end up with default balances of 0.00 in both accounts
    val elephant = BankAccounts()

    //Deposit $20.00 and $15.50 into elephant's checking and savings account respectively
    /* YOUR CODE HERE */
    
    //Transfer $18.10 from elephant's checking to savings
    /* YOUR CODE HERE */

    //Transfer $16.60 from elephant's savings to checking
    /* YOUR CODE HERE */

    println("Elephant checking amount = ${elephant.checking_balance}")
    println("Elephant savings amount = ${elephant.savings_balance}")
    println("Elephant total = ${elephant.getTotalBalance()}")

}