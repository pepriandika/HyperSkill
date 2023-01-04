package cinema

fun main() {
    println("Enter the number of rows:")
    val row = readln().toInt()
    println("Enter the number of seats in each row:")
    val seat = readln().toInt()
    val mutlist = mutableListOf<MutableList<String>>()
    val totalSeluruhKursih = row * seat
    var tiketTerjual = 0
    val hargaTiket = 10
    val hargaTiket2 = 8
    var currentIncome = 0
    var total = 0
    var j = 0
    repeat(row+1) {
        mutlist.add(mutableListOf())
        for (i in 0..seat) {  
        mutlist[j].add("S")
        mutlist[j][0] = "$j"
        }
        j++
    }
    mutlist[0].clear() 
    for (k in 0..seat) {
        mutlist[0].add("$k")
    }
    mutlist[0][0] = " "

    var persen = "0.00"
    

    if (totalSeluruhKursih <= 60){
        total= (totalSeluruhKursih * hargaTiket)
    } else {
        if (row % 2 == 0) {
            total = (totalSeluruhKursih / 2 * hargaTiket) + (totalSeluruhKursih / 2 * hargaTiket2)
        } else {
            total = ((row / 2)* seat * hargaTiket) + ((row / 2 + 1) * seat * hargaTiket2)
        }
    }
    
    

    fun showTheSeats() {
        println("\nCinema:") 
        for (l in 0..row) {
    	println("${mutlist[l].joinToString(" ")}")
        }
        println()
    }

    fun buyATicket() {
     	println("Enter a row number:")
        val rowNum = readln().toInt()
        println("Enter a seat number in that row:")
        val seatNum = readln().toInt()
        println()
        val totalSeluruhKursi = row * seat
        val genapDepan: Boolean = row % 2 == 0 && (rowNum <= row / 2)
        val genapBelakang: Boolean = row % 2 == 0 &&  (rowNum > row / 2)
        val ganjilDepan: Boolean = row % 2 == 1 && (rowNum <= row / 2)

        try {
            if (mutlist[rowNum][seatNum] == "B") {
                println("That ticket has already been purchased!")
                buyATicket()
            } else {
                tiketTerjual++
                val e: Float = totalSeluruhKursih.toFloat()
                val d: Float = tiketTerjual.toFloat()
                val a: Float = (100f / e) * d
                val formatPercentage = "%.2f".format(a)
                persen = formatPercentage // 0.00
                mutlist[rowNum][seatNum] = "B"
                print("Ticket price: ")
                
                if (totalSeluruhKursi <= 60){
                    currentIncome += hargaTiket
                    print("\$$hargaTiket")   
                    total = totalSeluruhKursi * hargaTiket
                } else if (genapDepan) {
                    currentIncome += hargaTiket
                	print("\$$hargaTiket")   
                    
                } else if (genapBelakang) {
                    currentIncome += hargaTiket2
                	print("\$$hargaTiket2")    
                    
                } else if (ganjilDepan) {
                    currentIncome += hargaTiket
                	print("\$$hargaTiket")     
                    
                } else { 
                    currentIncome += hargaTiket2
                	print("\$$hargaTiket2")
                    
                }             
            }
        } catch (e: IndexOutOfBoundsException) {
            println("Wrong input!")
            buyATicket()
        }
    }

    fun statistics(){
        println("Number of purchased tickets: $tiketTerjual")
        println("Percentage: $persen%")
        println("Current income: \$$currentIncome")
        println("Total income: \$$total")
    }

    fun menu() {
    println()
    println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
    val menu = readln().toInt()
        when (menu) {
            1 -> {
                showTheSeats()
                menu()
            }
            2 -> {
                buyATicket()
                menu()
            }
            3 -> {
                statistics()
                menu()
            }
            0 -> {
                return
            }
            else -> {
                println("Invalid Input")
                
            }
        }
    }
    
    menu()     
}