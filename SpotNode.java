public class SpotNode{
    public CatanSpot spot;
    public SpotNode next;

    public SpotNode(CatanSpot spot, SpotNode next){
      this.spot = spot;
      this.next = next;
    }

    public SpotNode(){

    }

    public void setSpot(CatanSpot spot){
      this.spot = spot;
    }

    public CatanSpot getSpot(){
      return spot;
    }

    public void setNext(SpotNode next){
      this.next = next;
    }

    public SpotNode getNext(){
      return next;
    }
}
