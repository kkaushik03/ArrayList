import java.util.NoSuchElementException;
public class PriorityQueue<E>
{
    private ArrayList<E> myArray;

    public PriorityQueue()
    {
        myArray = new ArrayList<E>();
        myArray.add(null);
    }

    public void add(E item)//cast to comparable
    {
        myArray.add(item);
        heapUp();
    }

    private void heapUp()
    {
        int index = myArray.size() - 1;
        while(index > 1)
        {
            Comparable toAdd = (Comparable)(myArray.get(index));
            Comparable parent = (Comparable)(myArray.get(index/2));
            if(toAdd.compareTo(parent) < 0)
                swap(index, index/2);
            index /= 2;
        }
    }

    public boolean isEmpty()
    {
        return myArray.size() == 1;
    }

    public E peek()
    {
        if(myArray.size() > 1)
            return myArray.get(1);
        return null;
    }

    public E remove()
    {
        if(isEmpty())
            throw new NoSuchElementException("NoSuchElementException: null");
        E temp = myArray.get(1);
        myArray.set(1, myArray.remove(myArray.size()-1));
        if(myArray.size() > 2)
            heapDown();
        return temp;
    }
    private void heapDown()
    {
        int currentIndex = 1;
        int tempIndex;
        Comparable currentItem, left, right, temp;
        while(hasLeft(currentIndex)) //while currentIndex has a left child
        {
            currentItem = (Comparable)myArray.get(currentIndex); //current parent
            left = (Comparable)myArray.get(currentIndex*2); //left child
            if(hasRight(currentIndex)) //if currentIndex has a right child
            {
                right = (Comparable)myArray.get(currentIndex*2+1); //right child
                if(left.compareTo(right) < 0) //if left value is less than right value
                {
                    temp = left; //temp is left child 
                    tempIndex = currentIndex*2; //tempIndex is left child index
                }
                else //right value is less than left value
                {
                    temp = right; //temp is right child
                    tempIndex = currentIndex*2+1; //tempIndex is right child index
                }
            }
            else //only has left child
            {
                temp = left; //temp is left child 
                tempIndex = currentIndex*2; //tempIndex is left child index
            }
            if(currentItem.compareTo(temp) > 0) //if parent is greater than smallest child
                swap(currentIndex, tempIndex); //swap them
            currentIndex = tempIndex; //currentIndex is now the child that was replaced
        }
    }
    private boolean hasLeft(int current)
    {
        if(current * 2 < myArray.size())
            return true;
        return false;
    }
    private boolean hasRight(int current)
    {
        if(current * 2 + 1 < myArray.size())
            return true;
        return false;
    }

    private void swap(int childIndex, int parentIndex)
    {
        E temp = myArray.get(childIndex);
        myArray.set(childIndex, myArray.get(parentIndex));
        myArray.set(parentIndex, temp);
    }
    
    private void aheapDown()
    {
        int currentIndex = 1;
        int tempIndex;
        Comparable currentItem, left, right, temp;
        while(hasLeft(currentIndex)) //while currentIndex has a left child
        {
            currentItem = (Comparable)myArray.get(currentIndex); //current parent
            left = (Comparable)myArray.get(currentIndex*2); //left child
            if(hasRight(currentIndex)) //if currentIndex has a right child
            {
                right = (Comparable)myArray.get(currentIndex*2+1); //right child
                if(left.compareTo(right) < 0) //if left value is less than right value
                {
                    temp = left; //temp is left child 
                    tempIndex = currentIndex*2; //tempIndex is left child index
                }
                else //right value is less than left value
                {
                    temp = right; //temp is right child
                    tempIndex = currentIndex*2+1; //tempIndex is right child index
                }
            }
            else //only has left child
            {
                temp = left; //temp is left child 
                tempIndex = currentIndex*2; //tempIndex is left child index
            }
            if(currentItem.compareTo(temp) > 0) //if parent is greater than smallest child
                swap(currentIndex, tempIndex); //swap them
            currentIndex = tempIndex; //currentIndex is now the child that was replaced
        }
    }
}