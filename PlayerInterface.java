import java.util.*;
public class PlayerInterface{
  public int playerCount;
  public int aiCount;
  int[] dotInArr = new int[19];
  int[] resourceInArr = new int[19];
  int[] tileNumberArr = new int[19];
  List<CatanPlayer> players = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);
  CatanTranslator translator = new CatanTranslator();
  public PlayerInterface(){

  }

  public void debugMode(CatanLinkedSpots spts){
    premadeBoards(1);

      CatanPlayer newPlayerOne = new CatanPlayer(1);
      newPlayerOne.setName("Matthew");
      players.add(newPlayerOne);

      CatanPlayer newPlayerTwo = new CatanPlayer(2);
      newPlayerTwo.setName("Mark");
      players.add(newPlayerTwo);

      CatanPlayer newPlayerThree = new CatanPlayer(3);
      newPlayerThree.setName("Luke");
      players.add(newPlayerThree);

      CatanPlayer newPlayerFour = new CatanPlayer(4);
      newPlayerFour.setName("John");
      players.add(newPlayerFour);


  }
  public int introduction(){
    System.out.println("** Welcome to the Catan Player! **");
    System.out.println("Please enter the total number of players for this game (3 or 4)");
    playerCount= scanner.nextInt();
    System.out.println("How many AI players would you like to add?");
    aiCount = scanner.nextInt();
    System.out.println("Press a number for a premade board or 0 for custom input");
    int choice = scanner.nextInt();
    return choice;
  }

  public void customInput(){
    System.out.println("Input the resources of your board left to right and bottom to top. No spaces all lowercase");
    System.out.println("Wood = w, Brick = b, GRAIN = g, Sheep = s, Ore = o, Desert = d");
    String buffer = scanner.nextLine(); //dont know why I have to do this...
    String resourceString = scanner.nextLine();
    for (int ii = 0; ii < 19; ii++){
      resourceInArr[ii] = translator.resourceToInt(resourceString.charAt(ii));
    }
    System.out.println("Input the numbers on your board left to right and bottom to top.");
    System.out.println("Press ENTER after each number");
    for (int ii = 0; ii < 19; ii++){
      int number = scanner.nextInt();
      tileNumberArr[ii] = number;
      dotInArr[ii] = translator.numberToDots(number);
    }
  }

  public void premadeBoards(int choice){
    if (choice == 1){
      int[] numInArr = {3,3,9,5,6,11,4,8,9,5,2,6,10,12,8,10,4,11,0};
      int[] tempResourceInArr = {4,2,2,4,0,2,1,3,3,0,3,0,1,1,2,0,3,4,5};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 2){
      int[] numInArr = {3,8,10,6,4,5,9,2,9,11,6,12,5,10,3,11,0,8,4};
      int[] tempResourceInArr = {2,0,1,0,0,2,3,4,3,0,3,2,2,3,4,4,5,1,1};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 3){
      int[] numInArr = {11,8,9,6,12,5,9,3,2,11,0,5,8,10,4,6,4,10,3};
      int[] tempResourceInArr = {1,2,1,4,3,2,1,0,2,3,5,4,0,3,0,0,3,2,4};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 4){
      int[] numInArr = {8,10,9,3,5,6,12,6,4,0,3,11,2,9,11,4,5,10,8};
      int[] tempResourceInArr = {0,2,3,0,1,4,3,3,2,5,2,4,4,0,2,1,3,1,0};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 5){
      int[] numInArr = {8,10,0,3,4,5,9,6,9,11,6,12,2,10,3,11,5,8,4};
      int[] tempResourceInArr = {3,1,5,4,4,3,4,1,0,0,3,2,1,2,0,0,2,2,3};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 6){
      int[] numInArr = {2,2,1,3,0,3,4,3,4,0,0,0,2,5,3,2,1,4,1};
      int[] tempResourceInArr = {};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 7){
      int[] numInArr = {8,10,9,3,4,5,0,6,9,11,6,12,2,10,3,11,5,8,4};
      int[] tempResourceInArr = {0,2,2,4,0,4,5,0,1,0,3,3,3,2,2,1,4,3,1};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 8){
      int[] numInArr = {8,10,9,3,4,5,12,6,9,11,6,11,2,10,3,4,5,0,8};
      int[] tempResourceInArr = {1,2,2,4,0,0,3,2,3,1,0,4,3,4,2,3,1,5,0};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
    if (choice == 9){
      int[] numInArr = {8,10,9,3,4,5,12,6,9,11,6,11,2,10,3,4,5,0,8};
      int[] tempResourceInArr = {0,4,2,3,2,3,4,1,3,3,0,0,1,1,0,2,2,5,4};
      if (numInArr.length != 19){
        System.out.println(" ### ERROR Missing Numbers ###");
      }
      if (tempResourceInArr.length != 19){
        System.out.println(" ### ERROR Missing Resources ###");
      }
      for (int ii = 0; ii < 19; ii++){
        dotInArr[ii] = translator.numberToDots(numInArr[ii]);
        tileNumberArr[ii] = numInArr[ii];
        resourceInArr[ii] = tempResourceInArr[ii];
      }
    }
  }

  public void playerInput(){
    System.out.println("\n\n  Roll dice to determine your player order!");
    for (int ii = 0; ii < playerCount; ii++){
      System.out.println("Enter name for the player going " + translator.intToPlace(ii));

      if (ii == 0){String buffer = scanner.nextLine();} //dont know why I have to do this...

      String name = scanner.nextLine();
      CatanPlayer newPlayer = new CatanPlayer(ii);
      newPlayer.setName(name);
      players.add(newPlayer);
    }
  }

  public void tilePlacement(CatanLinkedSpots spts){
    System.out.println(" Time to place your tiles and roads! ");
    for (int ii = 0; ii < playerCount; ii++){ // FIRST SETTLEMENT
      System.out.println(players.get(ii).getName() + " input the location of the first settlement you have placed ");
      int choice = scanner.nextInt();
      players.get(ii).addSettlement(spts.get(choice), spts);
      spts.get(choice).setFeature(1);
      spts.get(choice).setOwner(ii);

      System.out.println("What spot does the road you placed connect to? ");
    }
    for (int ii = playerCount-1; ii >= 0; ii--){ // SECOND SETTLEMENT
      System.out.println(players.get(ii).getName() + " input the location of the second settlement you have placed ");
      int choice = scanner.nextInt();
      players.get(ii).addSettlement(spts.get(choice), spts);
      spts.get(choice).setFeature(1);
      spts.get(choice).setOwner(ii);

      CatanTile[] tileOutArr = new CatanTile[spts.get(choice).getBorderTiles().length]; // pick up from second settlement
      tileOutArr = spts.get(choice).getBorderTiles();
      for (int jj = 0; jj < tileOutArr.length; jj++){
        if(tileOutArr[jj].getResource()!=5)
        players.get(ii).addCard(tileOutArr[jj].getResource());
      }

      System.out.println("What spot does the road you placed connect to? ");
    }
  }
}
