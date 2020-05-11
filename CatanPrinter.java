public class CatanPrinter{
  CatanTranslator translator = new CatanTranslator();
  public CatanPrinter(){

  }

  public void printQTP(CatanLinkedTiles tls,int number){
          System.out.println("** Best " + number + " Tiles **");
    System.out.println("Tile #" + tls.getMaxTile().getID() + " QTP = " + translator.round(tls.getMaxTile().getQTP())+ " points");
    tls.previous();
    //tls.next();
    for (int ii = 2; ii <= number; ii++){
      System.out.println("Tile #" + tls.getCurrent().getID() + " QTP = " + translator.round(tls.getCurrent().getQTP())+ " points");
      tls.previous();

    }
  }

  public void printQSP(CatanLinkedSpots spts, int number){
    System.out.println("** Best " + number + " Spots **");
    if (spts.getMaxSpot().getViability() == 1)
    System.out.println("Spot #" + spts.getMaxSpot().getID() + " QSP = " + translator.round(spts.getMaxSpot().getQSP())+ " points");
    spts.previous();
    //spts.next();
    for (int ii = 2; ii <= number; ii++){
      if (spts.getCurrent().getViability() == 1)
      System.out.println("Spot #" + spts.getCurrent().getID() + " QSP = " + translator.round(spts.getCurrent().getQSP())+ " points");
      spts.previous();

    }
  }
}
