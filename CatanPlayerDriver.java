import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class CatanPlayerDriver{
  public static void main(String[] args){
    int[] dotInArr = new int[19];
    int[] resourceInArr = new int[19];
    int[] tileNumberArr = new int[19];
    CatanTranslator translator = new CatanTranslator();
    CatanCalculator calculator = new CatanCalculator();
    CatanPrinter printer = new CatanPrinter();
    PlayerInterface iFace = new PlayerInterface();
    Scanner scanner = new Scanner(System.in);


    // Temporary
    CatanPlayer playerOne = new CatanPlayer(1);

    System.out.println("** ENTER DEBUG MODE? \n 1 for yes 0 for no");
    int debug = scanner.nextInt();
    if (debug == 1){
      iFace.debugMode(spts);
    }
    else{
    //***SECTION 1: TILE VALUE INPUT***
    int inputChoice = iFace.introduction();
    if (inputChoice == 0){
      iFace.customInput();
    }
    else{
      iFace.premadeBoards(inputChoice);
    }
  }
    dotInArr = iFace.dotInArr;
    resourceInArr = iFace.resourceInArr;
    tileNumberArr = iFace.tileNumberArr;


    //***SECTION 2: BOARD CREATION***
    // Create Tile and Spot References
    int[][] tileRef = new int[54][3];
    int[][] spotRef = new int[54][3];
    ReferenceMaker makeRef = new ReferenceMaker();
    tileRef = makeRef.getTileRef();
    spotRef = makeRef.getSpotRef();

    // Create Linked Lists for Tiles and Spots
    CatanLinkedTiles tls = new CatanLinkedTiles();
    CatanLinkedSpots spts = new CatanLinkedSpots();

    // Create Tile and Spot Arrays
    CatanTile[] tileArr = new CatanTile[19];
    CatanSpot[] spotArr= new CatanSpot[54];

    // Add IDs to Tile Array
    for (int ii = 0; ii<19; ii++){
      tileArr[ii] = new CatanTile(ii);
    }

    // Add IDs to Spot Array
    for (int ii = 0; ii<54; ii++){
      spotArr[ii] = new CatanSpot(ii);
    }

    // Add Data to Tiles and Create Linked List
    for (int ii = 0; ii< 19 ; ii++){
      tileArr[ii].setDots(dotInArr[ii]);
      tileArr[ii].setResource(resourceInArr[ii]);
      tls.add(tileArr[ii]);
    }

    // Create Spots Linked List
    for (int ii = 0; ii < 54 ; ii++){
      spts.add(spotArr[ii]);
    }

    // Add Data to Spot Linked List
    for (int ii = 0; ii < 54; ii++){
      int tileBorderCount = 0;
      int spotBorderCount = 0;
      for(int jj = 0; jj < 3; jj++){ // number of tile borders on each spot
        if (tileRef[ii][jj] != 19){ // 19 == null or ocean however you see it
          tileBorderCount++;
        }
      }
      for(int ll = 0; ll < 3; ll++){ // number of border spots for each spot
        if (spotRef[ii][ll] != 54){ // 54 == null or ocean
          spotBorderCount++;
        }
      }
      CatanTile[] tilesInArr = new CatanTile[tileBorderCount]; // create tiles and spots arrays
      CatanSpot[] spotsInArr = new CatanSpot[spotBorderCount];
      for (int kk = 0; kk < tileBorderCount; kk++){ // fill tiles and spots arrays
        tilesInArr[kk] = tls.find(tileRef[ii][kk]);
      }
      for (int mm = 0; mm < spotBorderCount; mm++){
        spotsInArr[mm] = spts.find(spotRef[ii][mm]);
      }
      spotArr[ii].setBorderTiles(tilesInArr);
      spotArr[ii].setBorderSpots(spotsInArr);
    }
    //***SECTION 3: TILE ANALYSIS***

    // Calcualate Dots of Each resource
    double[] totalResourceYield = new double[5];
        for (int ii = 0; ii < 19; ii++){
          if (ii == 0){
          int resource = tls.getCurrent().getResource();
            if (resource < 5){
            totalResourceYield[resource] += tls.getCurrent().getDots();
            }
          }
          else {
              int resource = tls.next().getResource();
                if (resource < 5){
                totalResourceYield[resource] += tls.getCurrent().getDots();
                }
          }
        }
      //Calculate Abundance of Each Resource
      // Abundance = yield / 11.6
      double[] abundance = new double[5];
      abundance = calculator.calculateAbundance(totalResourceYield);

      // Calculate Minimum and Maximum Abundances
      double abundanceMin = 100;
      double abundanceMax = 0;
      for (int rr = 0; rr<5; rr++){
        if (abundanceMin > abundance[rr]){
          abundanceMin = abundance[rr];
        }
        if (abundanceMax < abundance[rr]){
          abundanceMax = abundance[rr];
        }
      }
      // Calculate QTP
      // QTP = 0.5*yield+ yield / abundance
      calculator.calculateQTP(tls, abundance);

      // Sort Tiles By QTP and give top 3
      printer.printQTP(tls,19);
      //***SECTION 4: PORT ANALYSIS***

      //***SECTION 5: SPOT ANALYSIS***
      // Calculate QSP  QSP = ΣQTP(CM) + ΣQTP + QPP
      System.out.println("** Quality Spot Points **");
      calculator.calculateQSP(spts,playerOne);
      // Sort Spots by QSP and Give Top 3
      printer.printQSP(spts,10);


      // Player Input
      iFace.playerInput();
      // Tile Placement
      iFace.tilePlacement(spts);
      System.out.println("Viability of 18  " + spts.get(18).getViability());

      // Check best available Now
      printer.printQSP(spts,10); /// DIDNT WORK







  }
}
