package Main2;

public class ArrayAccessor {
    private int[] array;

    public ArrayAccessor(int[]array){
        this.array = array;
    }
    
    public int getElement(int position) throws ArrayIndexOutOfBoundsException{
        if (position < 0 || position >= array.length) {
            throw new ArrayIndexOutOfBoundsException("指定された位置は範囲外です");
        }
        return array[position];
    }
}