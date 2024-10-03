console.log((f = function () {
    let nb=""
    do{
    do {
        var n = prompt("Saisissez les chiffres:", "1")
    }while(isNaN(n)||(n>9)||(n<0))
    
        if (parseInt(n) != 0) {
            nb = nb + n
        }
    } while (n!=0)
    return nb
})())

