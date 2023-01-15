public abstract class ArtificialObject {
    private final String ARTIFICIAL_OBJECT_NAME;
    private Fraction operatedBy;

    private boolean intact;

    public ArtificialObject(String n, Fraction op){
        ARTIFICIAL_OBJECT_NAME = n;
        operatedBy = op;
        intact = true;
    }

    public void setOperator(Fraction operator) {
        System.out.println(this.getArtificialObjectName() + " больше не используется " + operatedBy.getFractionName() + " теперь он принадлежит " + operator.getFractionName());
        operatedBy = operator;
    }

    public Fraction getOperatedBy() {
        return operatedBy;
    }

    public String getArtificialObjectName() {
        return ARTIFICIAL_OBJECT_NAME;
    }

    public boolean isIntact() {
        return intact;
    }

}
