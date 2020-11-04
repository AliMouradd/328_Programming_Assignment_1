# 328_Programming_Assignment_1
 Fraction Tree

Programming Assignment 1
The Fraction Tree
It is possible to build a fraction tree in the following way.  Starting with
L = 1,
on the Lth level of the tree, perform the following steps.
1.  Place the fraction 0/1 on the left and 1/0 on the right.
2.  Perform the following action L times,  between each pair of fractions a1/b1 and a2/b2
    on this level, insert the fraction (a1+a2)/(b1+b2).
3.  Index the fractions on this level by starting 0/1 with index 0 going up to 2^L.
4.  For each odd index 2i+ 1, your parent index on the line above is 2[i/2]+1
    All even indices are discarded from the tree.
