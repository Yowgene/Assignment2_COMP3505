# COMP 3505 - Software Testing

## Assignment Report #2 - Specification-Based Test Generation

### Group 4
- Augusto De Morais Silva
- Eugene Pardinez
- Ahad Chagani

---

### 1. 	Which test case design techniques have you used for designing your test cases, show one example from your test cases for each technique that you have used.

We used Equivalence Class Partitioning  by dividing input domains into valid and invalid groups and selecting representative values from each group. In testing the contains(double) method for a range (1, 5), we identified three primary equivalence classes: values below the lower bound, values within the range, and values above the upper bound. We selected representative values such as 0 (below the lower bound), 3 (within the range), and 6 (above the upper bound). This ensured that each logical category of input was tested without unnecessary redundancy.

We also use Boundary Value Analysis because numerical range methods are  prone to boundary related defects. For the contains(double) method, we specifically tested the boundary values 1 and 5 to verify whether the endpoints are inclusive, as defined in the Javadoc. For the intersects(double, double) method, we tested cases where the compared range touches the boundary exactly, such as (-5, 1) and (5, 10), to ensure correct behavior at edge conditions.

We used decision based testing for methods involving conditional logic. The intersects() method behaves differently depending on whether ranges overlap, partially overlap, touch at boundaries, or are completely separate. We created separate tests for overlapping ranges, fully contained ranges, boundary-touching ranges, and non-overlapping ranges. This ensured that all logical branches implied by the specification were exercised.

---

### 2. 	If you were to develop test cases for org.jfree.data.DataUtilities, how can this dependency affect test cases that you develop for DataUtilities class. Discuss your answer.

DataUtilities class depends on values2D for its methods like (calculateColumnTotal(), calculateRowTotal()), which can’t be instantiated directly since it's an interface. To get the data for testing, a complete implementation of the class is needed for it to be used, which can affect the behaviours of getColumnCount(),getRowCount(), and getValue(), which will be used for the test data. 
	
We can use an array of object type(Object[][]) to create a test case instance of dataUtilities. This will be useful for values2D as it requires a 2D structure(like a table) to provide for row and column values needed in its method. This will also allow the usage of null values and other data types in the test case, which will make it flexible.

---

### 3. 	Difficulties encountered, challenges overcome, and lessons learned from performing the assignment.

One of the  challenges in this assignment was learning to rely strictly on the Javadoc specification rather than the actual implementation. Since the provided version of JFreeChart intentionally contains defects, some tests failed even though they were correctly written according to the specification. This required a shift in mindset: the purpose of testing is to validate the implementation against the specification, not to adjust tests to match incorrect behavior.

During the planning phase for the DataUtilities class, we struggled to understand how to approach the test since it requires 2D. We had to research a bit on how to tackle this difficulty. As a result, we figured out that we need to create an array to create a test case scenario for the data utilities class.

We also encountered minor technical challenges while setting up JUnit 5 and ensuring proper configuration in Eclipse. Understanding the structure of test classes, annotations such as @BeforeEach, and assertion methods required some initial adjustment. However, once properly configured, the testing framework became straightforward to use.
