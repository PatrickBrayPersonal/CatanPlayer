public class TileNode{
    public CatanTile tile;
    public TileNode next;

    public TileNode(CatanTile tile, TileNode next){
      this.tile = tile;
      this.next = next;
    }

    public TileNode(){

    }

    public void setTile(CatanTile tile){
      this.tile = tile;
    }

    public CatanTile getTile(){
      return tile;
    }

    public void setNext(TileNode next){
      this.next = next;
    }

    public TileNode getNext(){
      return next;
    }
}
