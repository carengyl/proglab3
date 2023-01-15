public class SolRing extends ArtificialObject implements Stationary{
    public SolRing(String n, Fraction c, Fraction op){
        super(n, op);
    }

    @Override
    public void orbit() {
        System.out.println(this.getArtificialObjectName() + " неподвижно висит в космической пустоте");
    }
}
