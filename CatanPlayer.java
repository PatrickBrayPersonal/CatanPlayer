import java.util.ArrayList;
import java.util.List;
public class CatanPlayer{
  private int ID;
  List<CatanSpot> spots = new ArrayList<>();
  List<CatanSpot> cities = new ArrayList<>();
  List<CatanSpot> settlements = new ArrayList<>();
  private int spotCount = 0;
  private int cityCount = 0;
  private int settlementCount = 0;
  private int baseVictoryPoints = 0;
  private int[] yieldByResource = new int[6];
  public String name;
  public int[] cardsInHand = new int[5];

  public CatanPlayer(){

  }
  public CatanPlayer(int ID){
    this.ID = ID;
  }
  public void setName(String a){
    this.name = a;
  }
  public String getName(){
    return name;
  }

  public void setID(int a){
    ID = a;
  }
  public int getID(){
    return ID;
  }
  public void addSettlement(CatanSpot a, CatanLinkedSpots spts){
    spots.add(a);
    settlements.add(a);
    settlementCount++;
    spotCount++;
    baseVictoryPoints++;
    CatanSpot[] spotOutArr = new CatanSpot[a.getBorderSpots().length];
    spotOutArr = a.getBorderSpots();
    spts.get(a.getID()).setViability(0);
    for (int ii = 0; ii <  spotOutArr.length; ii ++){ // mark spots inviable
      spts.get(spotOutArr[ii].getID()).setViability(0);
    }
  }

  public List<CatanSpot> getSpots(){
    return spots;
  }
  public int getSpotCount(){
    return spotCount;
  }
  public int getSettlementCount(){
    return settlementCount;
  }
  public void addCity(CatanSpot a){
    cities.add(a);
    settlementCount--;
    cityCount++;
  }
  public int[] getYieldByResource(){
    int[] tempYieldByResource = new int[6];
    for (int ii = 0; ii< spotCount; ii++){ // parses through spots
      CatanTile[] tileOutArr = new CatanTile[spots.get(ii).getBorderTiles().length];
      tileOutArr = spots.get(ii).getBorderTiles();
        for (int jj = 0; jj < tileOutArr.length; jj++){ // parses through tiles
          tempYieldByResource[tileOutArr[jj].getResource()] += tileOutArr[jj].getDots();
        }
    }
    yieldByResource = tempYieldByResource;
    return yieldByResource;
  }

  public void addCard(int a){
    cardsInHand[a]++;
  }
}
