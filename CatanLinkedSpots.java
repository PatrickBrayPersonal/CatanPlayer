import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class CatanLinkedSpots {
  private int length;
  int ptrCount;
  SpotNode ptr;
  SpotNode root;
  //CONSTRUCTOR
  public CatanLinkedSpots(){
    this.length = 54;
  }

  public boolean add(CatanSpot c){
    SpotNode a = new SpotNode(); // new node to be added
    a.setSpot(c);
    int count = 1; // gives number of nodes added compares against length
    SpotNode temp = new SpotNode();
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

  public CatanSpot getCurrent(){
    if (root == null){ // if empty
      return null;
    }
    return ptr.getSpot();
  }


  public CatanSpot get(int i){
    int count = 0;
    SpotNode temp = new SpotNode();
    temp = root;
    while (count<i){ // treats zero as the first index
      temp = temp.getNext(); // goes through each one till i is reached
      if (temp == null){
        return null;
      }
      count++;
    }
    ptr = temp;
    return temp.getSpot();
  }

  public CatanSpot next(){
    if (root == null){ // if empty
      return null;
    }
    ptr = ptr.getNext(); // moves to next
    if (ptr == null){ // flips around back to front
      ptr = root;
    }
    return ptr.getSpot();
  }


  public CatanSpot previous(){
    SpotNode temp = new SpotNode();
    SpotNode trailer = new SpotNode();
    if(root == null){
      return null;
    }
    if (ptr == root){ // flips around to back
      temp = root;
      while(temp.getNext()!= null){
        temp = temp.getNext(); // goes through and returns the back
      }
      ptr = temp;
      return ptr.getSpot();
    }
    else{
      temp = root.getNext();
      trailer = root;
      while (trailer.getNext() != ptr){ // trailer is carried along until temp reaches ptr
        temp = temp.getNext();
        trailer = trailer.getNext();
      }
      ptr = trailer;
      return ptr.getSpot(); // ptr is set to trailer and returned
    }
  }

  public CatanSpot find(int ID){
    SpotNode temp = new SpotNode();
    temp = root; // begins searching from the right of ptr
    int doneCheck = 0;
    while(doneCheck == 0){ // sorts through list till end
      if (temp.getSpot().getID() == ID){
        ptr = temp;
        return temp.getSpot();
      }
      temp = temp.getNext(); // advances
    }
    return null;
  }

  public CatanSpot getMaxSpot(){ // Also Sorts
    sortQSP();
    SpotNode temp = new SpotNode();
    SpotNode trailer = new SpotNode();
    temp = root.getNext();
    trailer = root;
    while (temp!= null){
      if (trailer.getSpot().getQSP() > temp.getSpot().getQSP()){
      }
      else{
        temp = temp.getNext();
        trailer = trailer.getNext();
      }
    }
    ptr = trailer;
    return trailer.getSpot();

  }

  public CatanSpot getMinSpot(){ // Also Sorts
    reverseSortQSP();
    SpotNode temp = new SpotNode();
    SpotNode trailer = new SpotNode();
    temp = root.getNext();
    trailer = root;
    while (temp!= null){
      if (trailer.getSpot().getQSP() > temp.getSpot().getQSP()){
      }
      else{
        temp = temp.getNext();
        trailer = trailer.getNext();
      }
    }
    ptr = trailer;
    return trailer.getSpot();

  }

  public void sortQSP(){ // this is a bubble sort
    int switchCount = 1;
    SpotNode temp = new SpotNode(); // is the later contact being compared
    SpotNode trailer = new SpotNode(); // is the earlier contact being compared
    SpotNode caboose = new SpotNode(); // allows for reattachment after a switch
      while(switchCount > 0){ // breaks once ordered list is formed
        switchCount = 0;
          temp = root.getNext(); // this tests the first two elements (before caboose is introduced)
          trailer = root;
          double tempQSP = temp.getSpot().getQSP();
          double trailerQSP = trailer.getSpot().getQSP();
          if (trailerQSP > tempQSP){ // if elements are out of order
            trailer.setNext(temp.getNext()); // switches elements
            temp.setNext(trailer);
            root = temp;
            switchCount++;
          }
        caboose = root; // after first two elements are introduced we evaluate the rest
        trailer = caboose.getNext();
        temp = trailer.getNext();

          while (temp != null){
            tempQSP = temp.getSpot().getQSP();
            trailerQSP = trailer.getSpot().getQSP();
            if (trailerQSP > tempQSP){
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

  public void reverseSortQSP(){ // this is a bubble sort
    int switchCount = 1;
    SpotNode temp = new SpotNode(); // is the later contact being compared
    SpotNode trailer = new SpotNode(); // is the earlier contact being compared
    SpotNode caboose = new SpotNode(); // allows for reattachment after a switch
      while(switchCount > 0){ // breaks once ordered list is formed
        switchCount = 0;
          temp = root.getNext(); // this tests the first two elements (before caboose is introduced)
          trailer = root;
          double tempQSP = temp.getSpot().getQSP();
          double trailerQSP = trailer.getSpot().getQSP();
          if (trailerQSP < tempQSP){ // if elements are out of order
            trailer.setNext(temp.getNext()); // switches elements
            temp.setNext(trailer);
            root = temp;
            switchCount++;
          }
        caboose = root; // after first two elements are introduced we evaluate the rest
        trailer = caboose.getNext();
        temp = trailer.getNext();

          while (temp != null){
            tempQSP = temp.getSpot().getQSP();
            trailerQSP = trailer.getSpot().getQSP();
            if (trailerQSP > tempQSP){
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
