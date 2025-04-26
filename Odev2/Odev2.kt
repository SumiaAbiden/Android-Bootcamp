package com.sumia.kotlindersleri.Odev2

class Odev2 {
    fun soru1(derece: Double) : String{
        val fahrenheit = (derece * 1.8) + 32
        return "Girilen derece degeri $fahrenheit fahrenhiet'a esittir"
    }


    fun soru2(sayi1:Int, sayi2:Int){
        val cevre = 2*(sayi1+sayi2)
        println("Girilen kenar degerlerine gore dikdortgen cevresi = $cevre")
    }


    fun soru3(sayi:Int): String {
        var faktoryel = 1
        for(i in 1..sayi){
            faktoryel *= i
        }
        return "$sayi sayisinin faktoryel degeri = $faktoryel"
    }

    fun soru4(kelime:String) : String{
        var sayac = 0
        for (i in kelime){
            if (i.equals('a')){
                sayac++
            }
        }
        return "$kelime kelimesinde $sayac tane 'a' harfi bulunur"
    }


    fun soru5(x:Int) : String{
        var toplam = (x-2)*180
        return "$x kenara sahip seklin ic acilar toplami = $toplam"
    }


    fun soru6(gun:Int) : String{
        val toplamSaat = gun*8
        var maas = 0
        if(toplamSaat <= 160){
            maas = toplamSaat * 10
        }
        else{
            val fazlaMesai = (toplamSaat - 160)
            maas = 160 * 10 + fazlaMesai * 20
        }
        return "$gun gunluk calisma icin $maas TL maas verilmistir"
    }


    fun soru7(kotaMiktari : Int) : String{
        var ucret=0
        if(kotaMiktari <= 50){
            ucret = 100
        }else{
            val fazlaKullanim = kotaMiktari - 50
            ucret = 100 + fazlaKullanim * 4
        }
        return "Girilen kota miktari icin ucret = $ucret TL"
    }
}