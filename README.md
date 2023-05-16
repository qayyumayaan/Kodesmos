# Kodesmos: UHACCS Hackathon Project
Kodesmos turns an image or series of images into a parsable format by one of the most versatile graphing calculators: Desmos. Using our technology, one can submit an image or short clip and watch as their creation comes to life on the calculator. Written by Ayaan Qayyum and Ali Ahmed.  

Here is our demonstration video: 
[[Watch the video]](https://youtu.be/6IL5mgzmCOE)

We grew inspiration from the classical technology of the Cathode Ray Tube and how it parsed analog signal data for its use in media and utility playback. We wanted to demonstrate the utility of the Dot Matrix, so we used the Desmos graphing calculator. 

We have the technology to convolve an image of any size or resolution and use byte analysis and computation to return a signal parseable with a Cathode Ray Tube device. Desmos has to support up to an index of a thousand items long, resulting in an effective resolution of 31 by 31. 

We built it written in Java using the Abstract Window Toolkit. We also used the macro software AutoHotKey to translate data from Java to Desmos. The free software Desmos hosts our front end. 

We are proud of our ability to split work and work closely as a two-person team elegantly. We entered this hackathon knowing little to nothing about how Java handles image data. In our work, we learned a lot about the Abstract Window Toolkit packages in Java and how Java can handle image and image data. We also learned quite a bit about what Desmos can accomplish regarding image processing and projection. 

One of our project's major bottlenecks is that Desmos can only support up to an effective dot matrix resolution of 31 by 31. Our project is heavy on image processing, so we can reuse our work, particularly convolving our input image, to create better technology. Our next step is creating a version of this program that converts the image into a vector. 
