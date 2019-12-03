public class Analyzer
{

    // the methods below were referenced from https://learn.zybooks.com/zybook/UFLCOP3502ZhouFall2019 and stackoverflow.com

    public static int linearSearch(String[]dataSet, String element)
    {
        int i;

        for (i = 0; i < dataSet.length; ++i) {
            if (dataSet[i].equals(element)) {                    //goes through every element until it matches or doesnt
                return i;
            }
        }

        return -1; /* not found */
    }

   public static int binarySearch(String[]dataSet, String element)
    {
        int l = 0, r = dataSet.length - 1;
        while (l <= r)
        {
            int m = l + (r - l) / 2;

            int res = element.compareTo(dataSet[m]);

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }


   // Uses a binary search to find specified element in the dataSet. Returns index of element, or -1 if not found.


    public static void main (String[] args)
    {
      String[] stringdata = StringData.getData();      //accesses data set from StringData

      String nothere = "aaaaa";     //what we are looking for


       long start = System.nanoTime();
       int keyIndex = linearSearch(stringdata, nothere);      // time and run linear search
       long end = System.nanoTime();

        if (keyIndex == -1)
        {
            System.out.println(nothere + " was not found using linear.");
            System.out.println("took: "+ (end - start) +" nanoseconds");// if element was not found print not found statement and runtime

        }
        else

        {
            System.out.println("Found " + nothere + " using linear at index " + keyIndex + ".");// if element WAS  found print found statement and runtime
            System.out.println("took: " + (end - start) + " nanoseconds");

        }



        long start2 = System.nanoTime();
        int keyIndex2 = binarySearch(stringdata, nothere);      // time and run binary search
        long end2 = System.nanoTime();

        if (keyIndex2 == -1)
        {
            System.out.println(nothere + " was not found using binary.");
            System.out.println("took: "+ (end2 - start2) +" nanoseconds");        // if element was not found print not found statement and runtime

        }
        else

        {
            System.out.println("Found " + nothere + " using binary at index " + keyIndex2 + ".");  // if element WAS  found print found statement and runtime
            System.out.println("took: " + (end2 - start2) + " nanoseconds");

        }






    }
}
