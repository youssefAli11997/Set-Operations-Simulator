package set.operations;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author youssefali
 */
public class SetOfStrings {
    
    private ArrayList<String> universe;
    private int numberOfSets;
    private ArrayList<ArrayList<String> > sets;
    
    public SetOfStrings(ArrayList<String> universe, int numberOfSets, ArrayList<ArrayList<String> > sets){
        this.universe = universe;
        Collections.sort(universe);
        this.numberOfSets = numberOfSets;
        this.sets = sets;
        sets.stream().forEach((set) -> {
            Collections.sort(set);
        });
    }
    
    // compare function
    private int comp(String a, String b){
        return a.compareToIgnoreCase(b);
    }
    
    public ArrayList<String> getUniverse(){
        return this.universe;
    }
    public void setUniverse(ArrayList<String> universe){
        this.universe = universe;
    }
    
    public int getSetsNumber(){
        return this.numberOfSets;
    }
    public void setSetsNumber(int numberOfSets){
        this.numberOfSets = numberOfSets;
    }
    
    public ArrayList<ArrayList<String> > getSets(){
        return this.sets;
    }
    public void setSets(ArrayList<ArrayList<String> > sets){
        this.sets = sets;
    }
    
    public ArrayList<String> union(int a, int b){
    	return union(sets.get(a), sets.get(b));
    }
    
    public ArrayList<String> union(ArrayList<String> a, ArrayList<String> b){
        ArrayList<String> c = new ArrayList<>();
        for(String idx : a){
            c.add(idx);
        }
        for(String idx : b){
            if(!isIn(idx, c))
                c.add(idx);
        }
        
        return c;
    }
    
    
    public ArrayList<String> intersect(int a, int b){
    	return intersect(sets.get(a), sets.get(b));
    }
    
    public ArrayList<String> intersect(ArrayList<String> a, ArrayList<String> b){
        ArrayList<String> c = new ArrayList<>();
 
        for(String idx : a){
            if(isIn(idx, b))
                c.add(idx);
        }
        
        return c;
    }
    
    public ArrayList<String> complement(int a){
    	return complement(sets.get(a));
    }
    
    public ArrayList<String> complement(ArrayList<String> a){
        ArrayList<String> c = new ArrayList<>();
        
        for(String idx : this.universe){
            if(!isIn(idx, a))
                c.add(idx);
        }
        
        return c;
    }
    
    public ArrayList<String> difference(int a, int b){
    	return difference(sets.get(a), sets.get(b));
    }
    
    public ArrayList<String> difference(ArrayList<String> a, ArrayList<String> b){
        ArrayList<String> c = new ArrayList<>();
 
        for(String idx : a){
            if(!isIn(idx, b))
                c.add(idx);
        }
        
        return c;
    } 
    
    private boolean isIn(String idx, ArrayList<String> arr){
        for(String curr : arr){
            if(curr.equals(idx))
                return true;
        }
        return false;
    }
}