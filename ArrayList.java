public class ArrayList<E>
{
    private E[] myArray;
    private int mySize;
    public ArrayList()
    {
        myArray = (E[]) new Object[10];
        mySize = 0;
    }

    public ArrayList(int capacity)
    {
        myArray = (E[]) new Object[capacity];
        mySize = 0;
    }

    public int size()
    {
        return mySize;
    }

    public boolean isEmpty()
    {
        return mySize == 0;
    }

    public boolean add(E element)
    {
        if(myArray.length == mySize)//if array is full
            transferContents(); //double array size and transfer the contents
        myArray[mySize] = element; //adds element to end of the list
        mySize++; 
        return true;
    }

    public void add(int i, E element)
    {
        if(i > mySize || i < 0) //if index is not in bounds, throw exception
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index: " + i + ", Size: " + mySize);
        if(mySize == myArray.length) //if array is full,
            transferContents(); // double array size and transfer contents
        for(int r = mySize; r > i; r--) //start at the end of the array until reaches specified index
        {
            myArray[r] = myArray[r-1]; //swaps current value with index before it
        }
        myArray[i] = element; //inserts element into specified index after shifts have been made
        mySize++;
    } 

    public E set(int i, E element)
    {
        if(i > mySize || i < 0)//checks to see if inbounds
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index: " + i + ", Size: " + mySize);
        E temp = myArray[i];
        myArray[i] = element; //replaces what was at index i with new element
        return temp; //retruns what was previously at index i
    }
    
    public E get(int i)
    {
        if(i > mySize || i < 0)//checks to see if inbounds
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index: " + i + ", Size: " + mySize);
        return myArray[i]; //returns what is at index i
    }

    public E remove(int i)
    { 
        if(i >= mySize || i < 0)//checks to see if inbounds
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException: Index: " + i + ", Size: " + mySize);
        E temp = myArray[i]; //holds element that will be removed
        for(int r = i; r < mySize - 1; r++)
        {
            myArray[r] = myArray[r+1];//shifts elements left 1 from inputed index
        }
        myArray[mySize-1] = null; //accounts for last index in the array
        mySize--; //reduces size since element was removed
        return temp; //returns the removed value
    }

    private void transferContents()
    {
        E[] temp = (E[]) new Object[myArray.length * 2]; //creates new array with double the length
        for(int i = 0; i < mySize; i++)
        {
            temp[i] = myArray[i]; //fills temp array with values from myArray
        }
        myArray = temp; //points myArray to the temp array
    }
}
