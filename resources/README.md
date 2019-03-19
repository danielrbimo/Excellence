# Animation


We are using the out.svg as the output file and read the file from the test by getting access to the filename from the views. The views take in the file name and model usually as a parameter. The model now has extra methods. It has getLeftTopMostPosn that gets access to the lefttopmost position. GetBoundingDimension that shows how big the width and height of the dimension is. GetShapes method that gets the type string by taking in the input string using Map. And getTransformation that gets transformation which takes in all small values that is used to animate. We also made the abstract class for view to make the code concise because every views needs to be decided whether it should be visible or not. 

In addition, the main method is taking in the argument command line to run animation.  For example, when it takes in the -in small demo.txt -view text -speed 2, it will use smalldemo.txt for the animation file and create a text view with its output going to system.out and a speed of 2 ticks per second. 
When it takes in -view svg -out out.svg -in buildings.txt, it will use buildings.txt for the animation file, and create an SVG view with its output going to the file out.svg, with a speed of 1 tick per second. When it takes in the -in smalldemo.txt -view text, it will use smalldemo.txt for the animation file and create a text view with its output going to System.out. 
When it takes in -in smalldemo.txt -speed 50 -view visual: it will use smalldemo.txt for the animation file, and create a visual view to show the animation at a speed of 50 ticks per second. 