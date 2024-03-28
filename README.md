# ImageProcessing

This repository contains Java code for basic image processing operations.

## Overview

The ImageProcessing project provides functionality for performing various image processing tasks, including:

- Converting images to grayscale
- Scaling images up or down
- Reading and writing images from/to files
- Additional image manipulation functions

## Usage

To use the image processing functions provided by this project, follow these steps:

1. Clone the repository to your local machine:

    ```
    git clone https://github.com/j-barak/ImageProcessing.git
    ```

2. Import the project into your Java IDE (such as IntelliJ IDEA or Eclipse).

3. Use the provided classes and methods to perform image processing tasks as needed in your Java projects.

## Examples

Here are some examples of how to use the image processing functions:

```java
// Load an image from a file
MyImage myImage = ImageProcessor.loadImageFromFile("example.jpg");

// Convert the image to grayscale
int[][][] grayscaleImage = ImageProcessor.rgb2gray(myImage);

// Scale the image up
int[][] scaledImage = ImageProcessor.scaleImage(2.0, 2.0, grayscaleImage);

// Save the scaled image to a file
ImageProcessor.saveImageToFile("scaled_image.jpg", scaledImage);
```

## Contributing

Contributions to the ImageProcessing project are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
