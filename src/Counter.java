//ID: 208748590
public class Counter {

    private int number;

    /**
     * a constructor.
     * @param beginningNumber - the initial number.
     */
    public  Counter (int beginningNumber){
        this.number = beginningNumber;
    }

    /**
     * add number to current count.
     * @param number - the sum we want to add.
     */
    public void increase(int number){
        this.number += number;
    }

    /**
     * subtract number from current count.
     * @param number - the sum we want to subtract.
     */
    public void decrease(int number){
        this.number -= number;
    }

    /**
     * a getter - get current count.
     * @return number.
     */
    public int getValue(){
        return this.number;
    }

    /**
     * a toString method, we want to override the default one.
     * @return number.
     */
    public String toString(){
        return this.number + " ";
    }
}