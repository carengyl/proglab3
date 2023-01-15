public enum Fraction {
    UN("Объединенные Нации"),
    MCR("Марсианская Конгрессионная Республика"),
    OAP("Альянс Свободных Планет"),
    FREE_NAVY("Свободный флот"),
    INDEPENDENT("Независимый");

    private final String fractionName;
    Fraction(String fractionName){
        this.fractionName = fractionName;
    }

    public String getFractionName(){
        return fractionName;
    }
}

