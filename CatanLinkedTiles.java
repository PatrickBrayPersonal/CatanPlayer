import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class CatanLinkedTiles{
    private int length;
    int ptrCount;
    TileNode ptr;
    TileNode root; // first element in list
 //CONSTRUCTOR
    public CatanLinkedTiles(){
      this.length = 19;
    }

    public boolean add(CatanTile c){
      TileNode a = new TileNode(); // new node to be added
      a.setTile(c);
      int count = 1; // gives number of nodes added compares against length
      TileNode temp = new TileNode();
      temp.setNext(root);
      if (root == null){// if array is completely empty root becomes "a"
        root = a;
        ptr = a;
        return true;
      }
      else{
        while(count < length && temp.getNext() != null){
          temp = temp.getNext();
          count++;
        }// check if end is filled
        if(temp.getNext()  == null){
          temp.setNext(a);
          ptr = temp;
          return true;
        }
        else{
          return false; // full
        }
      }
    }

    public CatanTile getCurrent(){
      if (root == null){ // if empty
        return null;
      }
      return ptr.getTile();
    }

    public CatanTile get(int i){
      int count = 0;
      TileNode temp = new TileNode();
      temp = root;
      while (count<i){ // treats zero as the first index
        temp = temp.getNext(); // goes through each one till i is reached
        if (temp == null){
          return null;
        }
        count++;
      }
      ptr = temp;
      return temp.getTile();
    }

    public CatanTile next(){
      if (root == null){ // if empty
        return null;
      }
      ptr = ptr.getNext(); // moves to next
      if (ptr == null){ // flips around back to front
        ptr = root;
      }
      return ptr.getTile();
    }

    public CatanTile previous(){
      TileNode temp = new TileNode();
      TileNode trailer = new TileNode();
      if(root == null){
        return null;
      }
      if (ptr == root){ // flips around to back
        temp = root;
        while(temp.getNext()!= null){
          temp = temp.getNext(); // goes through and returns the back
        }
        ptr = temp;
        return ptr.getTile();
      }
      else{
        temp = root.getNext();
        trailer = root;
        while (trailer.getNext() != ptr){ // trailer is carried along until temp reaches ptr
          temp = temp.getNext();
          trailer = trailer.getNext();
        }
        ptr = trailer;
        return ptr.getTile(); // ptr is set to trailer and returned
      }
    }

    public CatanTile find(int ID){
      TileNode temp = new TileNode();
      temp = root; // begins searching from the right of ptr
      int doneCheck = 0;
      while(doneCheck == 0){ // sorts through list till end
        if (temp.getTile().getID() == ID){
          ptr = temp;
          return temp.getTile();
        }
        temp = temp.getNext(); // advances
      }
      return null;
    }


    public CatanTile getMaxTile(){ // Also Sorts
      sortQTP();
      TileNode temp = new TileNode();
      TileNode trailer = new TileNode();
      temp = root.getNext();
      trailer = root;
      while (temp!= null){
        if (trailer.getTile().getQTP() > temp.getTile().getQTP()){
        }
        else{
          temp = temp.getNext();
          trailer = trailer.getNext();
        }
      }
      ptr = trailer;
      return trailer.getTile();

    }

    public CatanTile getMinTile(){ // Also Sorts
      reverseSortQTP();
      TileNode temp = new TileNode();
      TileNode trailer = new TileNode();
      temp = root.getNext();
      trailer = root;
      while (temp!= null){
        if (trailer.getTile().getQTP() > temp.getTile().getQTP()){
        }
        else{
          temp = temp.getNext();
          trailer = trailer.getNext();
        }
      }
      ptr = trailer;
      return trailer.getTile();

    }

    public void sortQTP(){ // this is a bubble sort
      int switchCount = 1;
      TileNode temp = new TileNode(); // is the later contact being compared
      TileNode trailer = new TileNode(); // is the earlier contact being compared
      TileNode caboose = new TileNode(); // allows for reattachment after a switch
        while(switchCount > 0){ // breaks once ordered list is formed
          switchCount = 0;
            temp = root.getNext(); // this tests the first two elements (before caboose is introduced)
            trailer = root;
            double tempQTP = temp.getTile().getQTP();
            double trailerQTP = trailer.getTile().getQTP();
            if (trailerQTP > tempQTP){ // if elements are out of order
              trailer.setNext(temp.getNext()); // switches elements
              temp.setNext(trailer);
              root = temp;
              switchCount++;
            }
          caboose = root; // after first two elements are introduced we evaluate the rest
          trailer = caboose.getNext();
          temp = trailer.getNext();

            while (temp != null){
              tempQTP = temp.getTile().getQTP();
              trailerQTP = trailer.getTile().getQTP();
              if (trailerQTP > tempQTP){
                trailer.setNext(temp.getNext());
                temp.setNext(trailer); // switches and renames elements according to their order
                caboose.setNext(temp);
                temp = trailer;
                trailer = temp;
                switchCount++;
              }
              temp = temp.getNext(); // advances checks
              trailer = trailer.getNext();
              caboose = caboose.getNext();
            }
        }
    }

    public void reverseSortQTP(){ // this is a bubble sort
      int switchCount = 1;
      TileNode temp = new TileNode(); // is the later contact being compared
      TileNode trailer = new TileNode(); // is the earlier contact being compared
      TileNode caboose = new TileNode(); // allows for reattachment after a switch
        while(switchCount > 0){ // breaks once ordered list is formed
          switchCount = 0;
            temp = root.getNext(); // this tests the first two elements (before caboose is introduced)
            trailer = root;
            double tempQTP = temp.getTile().getQTP();
            double trailerQTP = trailer.getTile().getQTP();
            if (trailerQTP < tempQTP){ // if elements are out of order
              trailer.setNext(temp.getNext()); // switches elements
              temp.setNext(trailer);
              root = temp;
              switchCount++;
            }
          caboose = root; // after first two elements are introduced we evaluate the rest
          trailer = caboose.getNext();
          temp = trailer.getNext();

            while (temp != null){
              tempQTP = temp.getTile().getQTP();
              trailerQTP = trailer.getTile().getQTP();
              if (trailerQTP < tempQTP){
                trailer.setNext(temp.getNext());
                temp.setNext(trailer); // switches and renames elements according to their order
                caboose.setNext(temp);
                temp = trailer;
                trailer = temp;
                switchCount++;
              }
              temp = temp.getNext(); // advances checks
              trailer = trailer.getNext();
              caboose = caboose.getNext();
            }
        }
    }

}
