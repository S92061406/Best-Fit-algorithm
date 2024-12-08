package eex5563;
import java.util.Scanner; // Import Scanner for user input


public class miniproject {
	

    // Method to allocate memory to blocks as per Best Fit algorithm 
    static void bestFit(int blockSize[], int m, int processSize[], int n) 
    { 
        int allocation[] = new int[n];  // Array to store block allocations for processes

        // Initially, no block is assigned to any process (-1 indicates no allocation)
        for (int i = 0; i < allocation.length; i++) 
            allocation[i] = -1; 
       
        // Pick each process and find a suitable block according to its size
        for (int i = 0; i < n; i++) 
        { 
            int bestIdx = -1;  // Variable to store the index of the best-fitting block
            for (int j = 0; j < m; j++) 
            { 
                if (blockSize[j] >= processSize[i])  // Check if block can accommodate the process
                { 
                    if (bestIdx == -1 || blockSize[bestIdx] > blockSize[j]) 
                        bestIdx = j; 
                } 
            } 

            // If a suitable block is found, allocate it to the current process
            if (bestIdx != -1) 
            { 
                allocation[i] = bestIdx;  // Assign block to process
                blockSize[bestIdx] -= processSize[i];  // Reduce available memory in the block
            } 
        } 

        // Display the allocation results
        System.out.println("\nProcess No.\tProcess Size\tBlock no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t"); 
            if (allocation[i] != -1) 
                System.out.print(allocation[i] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        } 
    } 
      
    // Main method to take input from the user 
    public static void main(String[] args) 
    { 
        Scanner scanner = new Scanner(System.in);  // Create Scanner object for user input

        // Ask for the number of blocks and their sizes
        System.out.print("Enter the number of memory blocks: "); 
        int m = scanner.nextInt(); 
        int blockSize[] = new int[m]; 

        System.out.println("Enter the size of each memory block:"); 
        for (int i = 0; i < m; i++) 
        { 
            System.out.print("Block " + (i + 1) + ": "); 
            blockSize[i] = scanner.nextInt(); 
        } 

        // Ask for the number of processes and their sizes
        System.out.print("Enter the number of processes: "); 
        int n = scanner.nextInt(); 
        int processSize[] = new int[n]; 

        System.out.println("Enter the size of each process:"); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("Process " + (i + 1) + ": "); 
            processSize[i] = scanner.nextInt(); 
        } 

        // Call the bestFit function to allocate memory to processes
        bestFit(blockSize, m, processSize, n); 
    } 

}
