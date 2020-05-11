public class CatanTranslator{

  public CatanTranslator(){

  }


  public String numberToResource(int a){
    if (a == 0){
      return "Wood";
    }
    if (a == 1){
      return "Brick";
    }
    if (a == 2){
      return "Sheep";
    }
    if (a == 3){
      return "Wheat";
    }
    if (a == 4){
      return "Ore";
    }
    else {
      return "Desert";
    }
  }

  public double round(double a){
    double out = Math.floor(a*10)/10;
    return out;
  }

  public int numberToDots(int a){
    if (a == 0){
      return 0;
    }
    if (a == 2 || a==12){
      return 1;
    }
    if (a == 3 || a == 11){
      return 2;
    }
    if (a == 4 || a == 10){
      return 3;
    }
    if (a == 5 || a == 9){
      return 4;
    }
    if (a == 6 || a == 8){
      return 5;
    }
    else {
      return 100;
    }
  }

  public int resourceToInt(char a){
    if (a == 'w'){
      return 0;
    }
    if (a == 'b'){
      return 1;
    }
    if (a == 's'){
      return 2;
    }
    if (a == 'g'){
      return 3;
    }
    if (a == 'o'){
      return 4;
    }
    if (a == 'd'){
      return 5;
    }
    return 8;
  }

  public int getCompat(int a){
    if (a == 0){
      return 1;
    }
    if (a == 1){
      return 0;
    }
    if (a == 3){
      return 4;
    }
    if (a == 4){
      return 3;
    }
    else {
      return -1;
    }
  }

  public String intToPlace(int a){
    if (a == 0){
      return "first";
    }
    if (a == 1){
      return "second";
    }
    if (a == 2){
      return "third";
    }
    if (a == 3){
      return "fourth";
    }
    else{
      return "idk";
    }
  }
}
