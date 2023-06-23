import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
public class MainPQ
{
    private Scanner console;
    private PriorityQueue<Item> myQueue;

    public MainPQ()
    {
        console = new Scanner(System.in);
        myQueue = new PriorityQueue<Item>();
    }

    private void loadFile()
    {
        Scanner inFile;
        int id, inv;
        try
        {
            inFile = new Scanner(new File("file20.txt"));
            while(inFile.hasNext())
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
                inFile.nextLine();
                myQueue.add(new Item(id, inv));
            }
            System.out.println("File was loaded.\n");
            inFile.close();
        }
        catch(Exception error)
        {
            System.out.println(error.getMessage());
        }
    }

    private void add()
    {
        int id, inv;
        do
        {
            System.out.print("Enter Id # for item (-1 to quit): ");
            id = console.nextInt();
            console.nextLine();
            if(id == -1)
                return;
            System.out.print("Enter Inv # for item (-1 to quit): ");
            inv = console.nextInt();
            console.nextLine();
            if(inv != -1){
                myQueue.add(new Item(id, inv));
                System.out.println("Item was added to the priority Queue\n");
            }
        }
        while(inv != -1);
    }

    private void remove()
    {
        String input;
        console.nextLine();
        do
        {
            System.out.print("Enter enter to remove(-1 to quit): ");
            input = console.nextLine();
            if(input.equals("") && !"".equals("-1"))
            {
                try
                {
                    System.out.println("Removed: " + myQueue.remove() + "\n");
                }
                catch(NoSuchElementException error)
                {
                    System.out.println(error.getMessage()+"\n");
                }
            }
        }while(input.equals("") && !"".equals("-1"));
    }

    public void mainMenu()
    {
        int choice;
        System.out.println("PriorityQueue Tester Has Been Initiated");
        do
        {
            System.out.println(" (1) Load File");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Peek");
            System.out.println(" (4) Add");
            System.out.println(" (5) Remove");
            System.out.println("(-1) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.nextInt();
            System.out.println();

            if (choice > 0 && choice <= 5)
            {
                switch(choice)
                {
                    case 1:
                    loadFile();
                    break;

                    case 2:
                    if(myQueue.isEmpty())
                        System.out.println("Queue is empty\n");
                    else
                        System.out.println("Queue is NOT empty\n");
                    break;

                    case 3:
                    System.out.println(myQueue.peek());
                    break;

                    case 4:
                    add();
                    break;

                    case 5:
                    remove();
                    break;
                }
            }
            else if(choice == -1)
            {
                break;
            }
            else
            {
                System.out.println("Invalid Option Selected");
            }
        }
        while (choice != -1);
    }
}

