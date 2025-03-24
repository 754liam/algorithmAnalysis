This program generates an array with 20 random integer elements. This array is then copied and passed to 4 different sorting algorithms, which then each sort the array from least to greatest. Each exchange within the sorting algorithm is logged in a counter variable. Once all arrays are sorted, this counter variable is returned through a method and the amount of passes each sort made are outputted. This program is effective at demonstrating how different sorting algorithms have different time complexities, and if one wishes the size of the array can be shifted to test how time complexity shifts with n-size.
How to go about analyzing an algorithm's time complexity:
Analyzing an algorithm's time complexity in relation to its input size is generally the way to go about understanding and estimating it's time to complete. This is usually done using big-O notation, for example, O(n): this means that an algorithm grows in time linearly as input size (n) also grows. There are many other standard functions of time complexity, like O(1) where an algorithm's time remains constant, or O(n^2) where an algorithm's time grows quadratically with inputs. Analyzing the algorithms' structure is one of the best ways to deduct time complexity – for example, if you see an algorithm that runs through an array of n size once, then you can deem it to have O(n) time complexity. If you see an algorithm that runs nested loops where each element is compared to every other element (like bubble sort for example), then you can deem it to have O(n^2) time complexity, and if you see an algorithm use a recursive divide-and-conquer approach like merge sort, then you can deem it to have O(n log n) time complexity. Essentially, you can analyze the number of operations and algorithm would need to go through to complete a task. You can also time and algorithm with a certain n, and see how this time goes with respect to n growing/decreasing; similarly, you can count the number of operations performed by an algorithm with respect to n. For example, if you had a code like: 

Int[] arr = {1,2,3,4,5}; 

Int sum = 0; 

For (int x = 0; x<arr.length; x++){ 

Sum = sum + arr[x]; 

} 

Return sum; 

You can see it runs through each of the array’s indexes, and since there is no branching, dividing, or nesting, you can deem it to have O(n) time complexity. Understanding time complexity is vital in the case of optimization, and equivalently optimization is vital in the case of optimizing business operations.
