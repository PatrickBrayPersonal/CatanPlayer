public class CatanPort{
  private int intType;
  private String stringType;
  private int spotLoc;
  private double QPP;

  CatanPort(int intType, int spotLoc){
    this.intType = intType;
    this.spotLoc = spotLoc;
  }

  public void setType(int a){
    intType = a;
  }
  public int getIntType(){
    return intType;
  }
  public String getStringType(){
    return stringType;
  }
  public void setSpotLoc(int a){
    spotLoc = a;
  }
  public int getSpotLoc(){
    return spotLoc;
  }
  public void setQPP(double a){
    QPP = a;
  }
  public double getQPP(){
    return QPP;
  }
}
