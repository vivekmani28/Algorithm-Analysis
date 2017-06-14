# Algorithm-Analysis

Below three programming statergies were compared against each other by taking the same problem of matrix mulplication.
- Recursive
- Memoized
- Dynamic Programming

All three versions were implemented in Java.

### Inputs Used:
The input for all the three algorithms are the number of matrices and then the dimensions of all those matrices in an order a1, a2, a3 … such that first matrix is of order a1X a2 and second is of order a2 X a3 and so on. The below take sets of input (# of matrices < 30) shows good differences between all three versions of the algorithm. Since the time taken in recursive version increases almost exponentially, any number more than 30 will only allow us to analyze the dynamic programming and the memoized versions of the algorithm as the recursive version takes almost infinity time(more than 15 minutes). 


### Comparisons

![image](https://user-images.githubusercontent.com/22831490/27114873-a467d19a-5094-11e7-9165-f1cb2425c83b.png)

![image](https://user-images.githubusercontent.com/22831490/27114879-b2099810-5094-11e7-9a22-909c5777d419.png)

![image](https://user-images.githubusercontent.com/22831490/27114881-b7a32d18-5094-11e7-99d9-829f4fb08c8a.png)

### Findings:
The analysis so far shows that the running time and the # of multiplications in the recursive version seems to increase exponentially. This is because in this version there are repeated calculations done, which is also the reason behind the increase in the # of recursive calls. Also, we see that the overall multiplications in the recursive version is way too higher than the other two versions.

On the other hand, we see dynamic programming version and the memoized version performs great. The reason behind that both these versions store the values of the sub-problems somewhere using it for future reference and thus not repeating the calculations. Only difference between the two is that, in dynamic version the algorithm straight away calculates and stores the value for all possible combinations whereas in a memoized version, it checks the table via recursion and if the value is not available in the table it then calculates it. Thus, accounting for the non-zero number of recursive calls.
