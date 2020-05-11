public class CatanTile{
  private int ID;
  private int dots;
  private int resource;
  private double QTP;
  private int[] spotBorders;
  private int tileBorderCount;
  private int[] tileBorders;

  CatanTile(int ID, int resource, int dots){
    this.ID = ID;
    this.resource = resource;
    this.dots = dots;
  }
  CatanTile(int ID){
    this.ID = ID;
  }

  public void setID(int a){
    ID = a;
  }
  public int getID(){
    return ID;
  }
  public void setDots(int a){
    dots = a;
  }
  public int getDots(){
    return dots;
  }
  public void setResource(int a){
    resource = a;
  }
  public int getResource(){
    return resource;
  }
  public void setQTP(double a){
    QTP = a;
  }
  public double getQTP(){
    return QTP;
  }
}
