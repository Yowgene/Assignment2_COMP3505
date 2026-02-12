# COMP 3505 - Software Testing

## Assignment Report #2 - Specification-Based Test Generation

### Group 4
- Augusto De Morais Silva
- Eugene Pardinez
- Ahad Chagani

### 1. 	Which test case design techniques have you used for designing your test cases, show one example from your test cases for each technique that you have used (If you have not used one of the techniques in your tests, you do not have to create an example).

We used Equivalence Class Partitioning  by dividing input domains into valid and invalid groups and selecting representative values from each group. In testing the contains(double) method for a range (1, 5), we identified three primary equivalence classes: values below the lower bound, values within the range, and values above the upper bound. We selected representative values such as 0 (below the lower bound), 3 (within the range), and 6 (above the upper bound). This ensured that each logical category of input was tested without unnecessary redundancy.

We also use Boundary Value Analysis because numerical range methods are  prone to boundary related defects. For the contains(double) method, we specifically tested the boundary values 1 and 5 to verify whether the endpoints are inclusive, as defined in the Javadoc. For the intersects(double, double) method, we tested cases where the compared range touches the boundary exactly, such as (-5, 1) and (5, 10), to ensure correct behavior at edge conditions.

We used decision based testing for methods involving conditional logic. The intersects() method behaves differently depending on whether ranges overlap, partially overlap, touch at boundaries, or are completely separate. We created separate tests for overlapping ranges, fully contained ranges, boundary-touching ranges, and non-overlapping ranges. This ensured that all logical branches implied by the specification were exercised.

### 2. 	If you were to develop test cases for org.jfree.data.DataUtilities, how can this dependency affect test cases that you develop for DataUtilities class. Discuss your answer (at this point, you do not need to develop test cases for this class).

### 3. 	Difficulties encountered, challenges overcome, and lessons learned from performing the assignment. (If there are any challenges or you are concerned with your learning progress that you do not want to share on the team document, please feel free to email your course instructor. I am always happy to hear from you and help you.)
