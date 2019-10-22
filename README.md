# NOTE: THE "DIRECTIONS TO RUN" WERE INCLUDED BECAUSE THE PROBLEM WAS SUBMITTED VIA ZIP FILE. THEY MAY BE IGNORED HERE.

# Assumptions:

From the problem description, as well as the relationship between the given input and given output, I was able to deduce the following assumptions:

* Input data will be supplied via 1 text file named “input.txt” (as specified in the instructions from the email containing this challenge)

* input.txt will contain information for at least 1 basket

* Input data for each basket will be separated from other baskets by 1 blank line.

* Input for shopping baskets will always follow the format of “input #” on the first line, followed by a variable number of lines corresponding to the number of discrete items.
    * Each of these lines will be in lower case and follow the pattern: 
item quantity, item name, “at”, price (with no symbols)

* Items that are imported will be specified by including the word “imported” somewhere in the item name

* Regardless of where the word “imported” is in the item’s name, the output will always follow the format “imported item name”

* No items other than the examples provided will be supplied in the input


# Notes on design:

In following good OOP principles, I aimed to separate the concerns of each class as much as possible, allowing them to be used flexibly and more easily expanded upon in the future.

I created the TxtFileAdaptor to isolate the process of translating data from a text file, as in a production scenario it is much more likely that the data will be input in another form.

In creating each Good I used a factory pattern, and I recognize that this could be seen as excessive, considering that as of now all Goods behave in the same way. However, noting that the instructions were to write code that can be evolved, I saw that this would be obviously useful in the future as unique information is inevitably added to each Good type.

Each kind of tax inherits from the super Tax class. Exceptions to taxes are enforced by the tax, rather than the good, as this would be informed by tax policy which Goods are unaware of.

The Receipt class is concerned with displaying the final information, allowing all other classes to not be concerned with displaying any information.

In order to list the desired output specified as the default, the Main class is supplied with the desired inputs, then imports the information from the supplied text file and converts it into Baskets, and then finally creates Receipts for the baskets related to the specified inputs. This process ensures that the requested results from the instructions will be printed when the program is run, but at the same time, any configuration of results can be produced independently of what data is being provided.

# Directions to run the program
1. Download "ProblemTwoSalesTaxesJava.zip" to your desired location
2. From your command line, navigate into the directory containing "ProblemTwoSalesTaxesJava.zip"
3. Once in the specified directory, type `unzip ProblemTwoSalesTaxesJava.zip`
4. Next, type `cd ProblemTwoSalesTaxesJava` to move into the newly created "ProblemTwoSalesTaxesJava" folder
5. From the "ProblemTwoSalesTaxesJava" folder, compile the code by typing `javac thoughtworks/codechallenge/*.java`
6. Finally, staying in the "ProblemTwoSalesTaxesJava" folder, run the program by typing `java thoughtworks/codechallenge/Main`

# Original Problem Directions

Problem Two: Sales Taxes
 
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
 
When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid.  The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
 
Write an application that prints out the receipt details for these shopping baskets...
 
Input:
 
Input 1:
1 book at 12.49
1 music CD at 14.99
1 chocolate bar at 0.85
 
Input 2:
1 imported box of chocolates at 10.00
1 imported bottle of perfume at 47.50
 
Input 3:
1 imported bottle of perfume at 27.99
1 bottle of perfume at 18.99
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.25
 
Output:
 
Output 1:
1 book : 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
 
Output 2:
1 imported box of chocolates: 10.50
1 imported bottle of perfume: 54.65
Sales Taxes: 7.65
Total: 65.15
 
Output 3:
1 imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 9.75
1 imported box of chocolates: 11.85
Sales Taxes: 6.70
Total: 74.68
