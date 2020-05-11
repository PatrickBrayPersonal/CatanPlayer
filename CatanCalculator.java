import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CatanCalculator{
  CatanTranslator translator = new CatanTranslator();
  public CatanCalculator(){

  }
  public double[] calculateAbundance(double[] totalResourceYield){
    double[] abundance = new double[5];
    for (int rr = 0; rr<5; rr++){
      abundance[rr] = totalResourceYield[rr] / 11.6;
    }
    System.out.println("** Resource Abundances **");
    for (int rr = 0; rr<5; rr++){
      double out = abundance[rr];
      out = translator.round(out);
      System.out.println(translator.numberToResource(rr) + " = " + out);
    }
    return abundance;
  }


  public void calculateQTP(CatanLinkedTiles tls, double[] abundance){
    System.out.println("** Quality Tile Points **");
    tls.find(0);
    for (int ii = 0; ii<19; ii++){
      if(tls.getCurrent().getResource() == 5){
        tls.getCurrent().setQTP(0);
        //System.out.println("Tile " + tls.getCurrent().getID() + " = "+ translator.round(tls.getCurrent().getQTP()) + " points");
      }
      else{
      tls.getCurrent().setQTP(0.5*tls.getCurrent().getDots() + tls.getCurrent().getDots() / abundance[tls.getCurrent().getResource()]);
      //System.out.println("Tile " + tls.getCurrent().getID() + " = "+ translator.round(tls.getCurrent().getQTP()) + " points");
      }
      tls.next();
    }
  }


  public void calculateQSP(CatanLinkedSpots spts, CatanPlayer player){ // Compats/3
    int[] yieldByResource = new int[6];
    yieldByResource = player.getYieldByResource();
    spts.get(0);
    for (int ii =0 ; ii < 54; ii++){ // parses through spots
      int[] tempYieldByResource = new int[6];
      //tempYieldByResource = yieldByResource;
      CatanTile[] tileOutArr = new CatanTile[spts.getCurrent().getBorderTiles().length];
      tileOutArr = spts.getCurrent().getBorderTiles();
      double tempQSP = 0;
      double cmQSP = 0;

      for (int jj =0 ; jj<tileOutArr.length; jj++){ // Add base QTP
        tempQSP += tileOutArr[jj].getQTP();
        tempYieldByResource[tileOutArr[jj].getResource()] += tileOutArr[jj].getDots(); // temporarily adds this tiles resources
      }

      double compats = 0;

      if(tempYieldByResource[0]>0 && tempYieldByResource[1]>0){
        compats += tempYieldByResource[0]+tempYieldByResource[1];
      }
      if(tempYieldByResource[3]>0 && tempYieldByResource[4]>0){
        compats += tempYieldByResource[3]+tempYieldByResource[4];
      }
      double compModifier = compats/3;
      spts.getCurrent().setQSP(tempQSP+ compModifier);
      spts.next();
    }
  }


}
